package org.xquant.service;

import org.springframework.stereotype.Service;
import org.xquant.dao.StudentMapper;
import org.xquant.pojo.Student;
import org.xquant.service.impl.StudentService;


import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    public StudentServiceImpl(){}

    public List<Student> getAllStudents(){ return studentMapper.getAllStudents(); }

    public Student getStudentBySno(String sno){
        return studentMapper.getStudentBySno(sno);
    }

    public int addStudent(Student student){
        return studentMapper.addStudent(student);
    }

    public int deleteStudent(String sno){
        return studentMapper.deleteStudent(sno);
    }

    public int updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }
}
