package com.jia.students.controller;

import com.jia.students.domain.Student;
import com.jia.students.repository.StudentRepository;
import com.jia.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;
    // 查询所有学生
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> find() {
        return studentService.find();
    }

    // 增加新闻
    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    // 按照id查询新闻
    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public Student findOne(@PathVariable String studentId) {
        return studentService.findOne(studentId);
    }


    // 删除学生
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(String studentId) {
        studentService.delete(studentId);
    }

    // 更新学生的所有需要更新的信息
    @RequestMapping(method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

}
