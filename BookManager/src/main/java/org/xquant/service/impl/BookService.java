package org.xquant.service.impl;

import org.xquant.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks(int start, int limit);

    List<Book> getBookByName( String book_name);

    Book getBookById(int book_id);

    int addBook(Book book);

    void deleteBook( int book_id);

    void updateBook(Book book);

    int getBookCount();
}
