package org.xquant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xquant.pojo.Book;
import org.xquant.pojo.BookReturn;
import org.xquant.service.impl.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/select")
    @ResponseBody
    public List<BookReturn> selectBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("bookname");
        List<Book> books = bookService.getBookByName(name);
        List<BookReturn> result = new LinkedList<BookReturn>();
        for(Book book: books){
            BookReturn bookReturn = new BookReturn(book);
            result.add(bookReturn);
        }
        return result;
    }
    @RequestMapping("/add")
    @ResponseBody
    public Integer addBook(HttpServletRequest request){
        String bookname = request.getParameter("bookName");
        String bookid = request.getParameter("bookId");
        int bookid1 = Integer.parseInt(bookid);
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        int price1 = Integer.parseInt(price);
        String state = request.getParameter("state");
        int state1 = state.equals("1")?1:0;
        String date = request.getParameter("publishtime");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try{
            date1 = simpleDateFormat.parse(date);
        }catch (ParseException px){
            px.printStackTrace();
        }
        Book book = new Book();
        book.setauthor(author);
        book.setBook_name(bookname);
        book.setBook_id(bookid1);
        book.setPrice(price1);
        book.setdescription(description);
        book.setState(state1);
        book.setPublish_time(date1);
        return bookService.addBook(book);

    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<BookReturn> getAll(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Book> books = bookService.getAllBooks();
        List<BookReturn> result = new LinkedList<BookReturn>();
        for(Book book:books){
            BookReturn bookReturn = new BookReturn(book);
            result.add(bookReturn);
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int deleteBook(HttpServletRequest request){
        String bookid = request.getParameter("bookid");
        int bookid1 = Integer.parseInt(bookid);
        return bookService.deleteBook(bookid1);
    }

}
