package org.xquant.service.impl;

import org.apache.ibatis.annotations.Param;
import org.xquant.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    List<Book> getBookByName( String book_name);

    int addBook(Book book);

    int deleteBook( int book_id);

    int updateBook(Book book);
}
