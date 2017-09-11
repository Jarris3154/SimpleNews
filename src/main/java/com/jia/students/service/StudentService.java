package com.jia.students.service;

import com.jia.students.domain.Student;
import com.jia.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student){
        studentRepository.save(student);
        return student;
    }

    public List<Student> find(){
        return studentRepository.findAll();
    }

    public Student findOne(String studentId) {
        return studentRepository.findOne(studentId);
    }

    public void delete(String studentId){
        studentRepository.delete(studentId);
    }

    public Student update(Student student){
        return studentRepository.update(student);
    }
}
