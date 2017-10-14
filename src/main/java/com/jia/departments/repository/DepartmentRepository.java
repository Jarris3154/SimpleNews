package com.jia.departments.repository;

import com.jia.departments.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "departments")
public interface DepartmentRepository extends MongoRepository<Department, String> {

    List<Department> findAll();

    Department findOne(String id);
}
