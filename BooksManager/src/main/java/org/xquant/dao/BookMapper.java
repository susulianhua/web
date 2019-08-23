package org.xquant.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xquant.pojo.Book;

import java.util.List;


public interface BookMapper {

    List<Book> getAllBooks();

    List<Book> getBookByName(@Param("book_name") String book_name);

    int addBook(Book book);

    int deleteBook(@Param("book_id") int book_id);

    int updateBook(Book book);
}
