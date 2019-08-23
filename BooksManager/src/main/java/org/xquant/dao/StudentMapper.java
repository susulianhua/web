package org.xquant.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xquant.pojo.Student;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> getStudent();

    List<Student> getAllStudents();

    Student getStudentBySno(@Param("sno") String sno);

    int addStudent(Student student);

    int deleteStudent(@Param("sno") String sno);

    int updateStudent(Student student);
}
