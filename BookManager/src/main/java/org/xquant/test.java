package org.xquant;

import net.sf.json.JSONArray;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xquant.dao.BookMapper;
import org.xquant.pojo.Book;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args){
        String conf = "spring.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        System.out.println(sqlSessionFactory);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.通过sqlSession 获得mapper对象，参数为映射文件中对应的接口类的class对象
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);


        //4.通过mapper对象来执行操作
        List<Book> books = mapper.getAllBooks( 5,8);
        Book book = books.get(0);
        Date date1 = book.getPublish_time();
        System.out.println(date1);
        SimpleDateFormat date2 = new SimpleDateFormat("yy/MM/dd");
        String time = date2.format(date1);
        System.out.println(time);

        //关闭资源
        sqlSession.close();
        JSONArray jsonArray = JSONArray.fromObject(books);
        System.out.println("执行操作：");
        String request = "11";
        int m = 0, n = 0;

        m = Integer.parseInt(request);
        System.out.println("m的值：" + m + "长度：" + request.length() + "第一个" + request.indexOf(0));
        System.out.println(jsonArray);
    }
}
