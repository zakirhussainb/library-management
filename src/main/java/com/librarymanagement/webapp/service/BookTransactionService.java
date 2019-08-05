package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.*;
import com.librarymanagement.webapp.repository.BookTransactionRepository;
import com.librarymanagement.webapp.util.BookItemStatus;
import com.librarymanagement.webapp.util.BookStatus;
import com.librarymanagement.webapp.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BookTransactionService {

    @Autowired
    private LibraryCardService libraryCardService;
    @Autowired
    private BookItemService bookItemService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BookTransactionRepository repository;
    @Autowired
    private BookTransactionService bookTransactionService;

    private static final int BOOKS_ISSUED = 1;

    public BookTransaction checkOutABook(BarCodeReader barCodeReader) {
        LibraryCard newLibraryCard = libraryCardService.findByBarCode(barCodeReader.getLibraryCardBarCode());
        Account account = accountService.findAccountByLibraryCard(newLibraryCard);
        BookItem bookItem = bookItemService.findByBarCode(barCodeReader.getBookItemBarCode());
        if(bookItem.getStatus() == BookItemStatus.AVAILABLE) {
            return issueBookItemToAccount(account, bookItem);
        } else {
            throw new Error("The book item " + bookItem.getBook().getTitle() + " cannot be issued to " + account.getPerson().getName());
        }
    }

    private BookTransaction issueBookItemToAccount(Account account, BookItem bookItem) {
        int numberOfBooksIssued = account.getBooksIssued();
        if(numberOfBooksIssued > Constants.MAX_BOOKS_ISSUED_TO_USER) {
            throw new Error("Maximum quota for " + account.getPerson().getName() + " is exceeded");
        }
        BookTransaction bookTransaction = new BookTransaction();
        bookTransaction.setAccountId(account.getId());
        bookTransaction.setBookItemId(bookItem.getId());
        accountService.incrementTotalBooksCheckedOut(account, numberOfBooksIssued);
        bookItemService.updateBookItemStatus(bookItem, BookItemStatus.LOANED);
        return repository.save(bookTransaction);
    }

    public BookTransaction returnBook(BarCodeReader barCodeReader) {
        LibraryCard newLibraryCard = libraryCardService.findByBarCode(barCodeReader.getLibraryCardBarCode());
        Account account = accountService.findAccountByLibraryCard(newLibraryCard);
        BookItem bookItem = bookItemService.findByBarCode(barCodeReader.getBookItemBarCode());
        if(bookItem.getStatus() == BookItemStatus.LOANED) {
            return returnBookItemToLibrary(bookItem);
        } else {
            throw new Error("The book item " + bookItem.getBook().getTitle() + " cannot be issued to " + account.getPerson().getName());
        }
    }

    private BookTransaction returnBookItemToLibrary(BookItem bookItem) {
        BookTransaction bookTransaction = findByBookItemId(bookItem.getId());
        Account account = accountService.findAccountById(bookTransaction.getAccountId());
        int numberOfBooksIssued = account.getBooksIssued();
        Date currentDate = new Date();
        if(currentDate.compareTo(bookItem.getDueDate()) <= 0) {
            accountService.decrementTotalBooksCheckedOut(account, numberOfBooksIssued);
        }
        return bookTransaction;
    }

    private BookTransaction findByBookItemId(Long id) {
        Optional<BookTransaction> result = repository.findByBookItemId(id);
        if(!result.isPresent()) {
            throw new IllegalArgumentException("No Book Transaction found");
        }
        return result.get();
    }

    /*private void reserveBookItemToAccount(BarCodeReader barCodeReader) {
        LibraryCard newLibraryCard = libraryCardService.findByBarCode(barCodeReader.getLibraryCardBarCode());
        Account newAccount = accountService.findAccountByLibraryCard(newLibraryCard);
        BookItem newBookItem = bookItemService.findByBarCode(barCodeReader.getBookItemBarCode());
        if(newBookItem.getStatus() == BookStatus.LOANED) {
            BookTransaction bookTransaction = findByAccountIdAndBookItemId(newAccount.getId(), newBookItem.getId());
        }
    }

    private BookTransaction findByAccountIdAndBookItemId(Long accountId, Long bookItemId) {
        Optional<BookTransaction> result = repository.findByAccountIdAndBookItemId(accountId, bookItemId);
        if(!result.isPresent()) {
            throw new IllegalArgumentException("No book transaction ")
        }
    }*/
}
