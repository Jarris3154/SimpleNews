package com.jia.students.repository;

import com.jia.students.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {
    public List<Student> findByName(String name);

    public List<Student> findById(String id);

    public List<Student> findAll();

}
