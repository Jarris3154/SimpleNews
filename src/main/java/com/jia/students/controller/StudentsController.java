package com.jia.students.controller;

import com.jia.students.model.Student;
import com.jia.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentRepository studentRepository;

    // 查询所有学生
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> find() {
        return studentRepository.findAll();
    }

    // 增加新闻
    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        student.setName(student.getName());
        student.setBirthDate(student.getBirthDate());
        studentRepository.save(student);
        return student;
    }

    // 按照id查询新闻
    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public Student findOne(@PathVariable String studentId) {
        return studentRepository.findOne(studentId);
    }


    // 删除学生
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Student student) {
        studentRepository.delete(student);
    }

    // 更新学生的所有需要更新的信息
    @RequestMapping(method = RequestMethod.PUT)
    public void updateMulti(@RequestBody Student student) {

    }

}
