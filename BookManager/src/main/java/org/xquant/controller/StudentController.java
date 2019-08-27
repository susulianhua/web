package org.xquant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xquant.pojo.Student;
import org.xquant.service.impl.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/getstudent")
    @ResponseBody
    public List<Student> getStudents(){
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addStudnet(HttpServletRequest request){
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        String ssex = request.getParameter("ssex");
        String spwd = request.getParameter("spwd");
        String stel = request.getParameter("stel");
        String sage = request.getParameter("sage");
        int sage1 = Integer.parseInt(sage);
        Student student = new Student();
        student.setSage(sage1);
        student.setSno(sno);
        student.setSname(sname);
        student.setSpwd(spwd);
        student.setStel(stel);
        student.setSsex(ssex);
        return studentService.addStudent(student);
    }

    @RequestMapping("/select")
    @ResponseBody
    public Student getStudnetsById(HttpServletRequest request){
        String sno = request.getParameter("studentNum");
        Student student = studentService.getStudentBySno(sno);
        return student;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int deleteStudent(HttpServletRequest request){
        String sno = request.getParameter("sno");
        return studentService.deleteStudent(sno);
    }
}
