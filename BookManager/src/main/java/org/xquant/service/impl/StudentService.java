package org.xquant.service.impl;

import org.apache.ibatis.annotations.Param;
import org.xquant.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentBySno(String sno);

    int addStudent(Student student);

    int deleteStudent(String sno);

    int updateStudent(Student student);
}
