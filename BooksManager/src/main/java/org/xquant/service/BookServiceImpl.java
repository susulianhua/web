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
    public List<Book> getAllBooks(){ return bookMapper.getAllBooks(); }

    @Override
    public List<Book> getBookByName(String i ){ return bookMapper.getBookByName(i); }

    @Override
    public int addBook(Book book){
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int i ){  return bookMapper.deleteBook(i); }

    @Override
    public int updateBook(Book book){
        return bookMapper.updateBook(book);
    }
}
