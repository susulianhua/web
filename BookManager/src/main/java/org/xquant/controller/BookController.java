package org.xquant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.xquant.pojo.*;
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
    public NormalResponse addBook(HttpServletRequest request){
        String bookname = request.getParameter("book_name");
        String bookid = request.getParameter("book_id");
        int bookid1 = Integer.parseInt(bookid);
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        int price1 = Integer.parseInt(price);
        String state = request.getParameter("state");
        int state1 = state.equals("1")?1:0;
        String date = request.getParameter("publish_time");
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
        int t = bookService.addBook(book);
        return new NormalResponse(t);

    }

    @RequestMapping("/getAll")
    @ResponseBody
    public Object getAll(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int start = Integer.parseInt(request.getParameter("start"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String query = request.getParameter("query");
        if(query == null){
        List<Book> books = bookService.getAllBooks(start, start + limit);
        List<BookReturn> result = new LinkedList<BookReturn>();
        for(Book book:books){
            BookReturn bookReturn = new BookReturn(book);
            result.add(bookReturn);
        }
        long total = bookService.getBookCount();
        return new NormalResponse(result, total);}
        else{
            List<Book> books = bookService.getBookByName(query);
            List<BookReturn> result = new LinkedList<BookReturn>();
            for(Book book: books){
                BookReturn bookReturn = new BookReturn(book);
                result.add(bookReturn);
            }
            return new NormalResponse(result, (long)books.size());
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Response deleteBook(@RequestBody List<BookId> list) {
        System.out.println(list);
        for (BookId m : list) {
            int n = m.getBookid();
            bookService.deleteBook(n);
        }
        NormalResponse response = new NormalResponse();
        return response;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Response updateBook(HttpServletRequest request){
        String bookname = request.getParameter("book_name");
        int bookid = Integer.parseInt(request.getParameter("book_id"));
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int state = Integer.parseInt(request.getParameter("state"));
        String date = request.getParameter("publish_time");
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
        book.setBook_id(bookid);
        book.setPrice(price);
        book.setdescription(description);
        book.setState(state);
        book.setPublish_time(date1);
        NormalResponse response = new NormalResponse();
            bookService.updateBook(book);
        return response;


    }
}
