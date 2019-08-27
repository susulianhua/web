package org.xquant.service;

import org.springframework.stereotype.Service;
import org.xquant.dao.BookMapper;
import org.xquant.pojo.Book;
import org.xquant.service.impl.BookService;


import javax.annotation.Resource;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks(int start, int limit){ return bookMapper.getAllBooks(start, limit); }

    @Override
    public List<Book> getBookByName(String i ){ return bookMapper.getBookByName(i); }

    @Override
    public Book getBookById(int book_id){ return bookMapper.getBookById(book_id);}

    @Override
    public int addBook(Book book){
        return bookMapper.addBook(book);
    }

    @Override
    public void deleteBook(int i ){ bookMapper.deleteBook(i);};

    @Override
    public void updateBook(Book book){
        bookMapper.updateBook(book);
    }

    @Override
    public int getBookCount(){
        return bookMapper.getBookCount();
    }
}
