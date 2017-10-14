//package com.jia.departments.controller;
//
//import com.jia.departments.model.Department;
//import com.jia.departments.repository.DepartmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/departments")
//public class DepartmentController {
//	@Autowired
//	private DepartmentRepository departmentRepository;
//	@Autowired
//	private MongoTemplate mongoTemplate;
//
//	// 查询所有新闻
//	@RequestMapping(method = RequestMethod.GET)
//	public List<Department> find() {
//		return departmentRepository.findAll();
//	}
//
//	// 增加新闻
//	@RequestMapping(method = RequestMethod.POST)
//	public Department save(@RequestBody Department department) {
//		departmentRepository.save(department);
//		return department;
//	}
//
//	// 按照id查询新闻
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public Department findOne(@PathVariable String id) {
//		return departmentRepository.findOne(id);
//	}
//
//
//	// 删除新闻
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public void delete(@PathVariable String id) {
//		departmentRepository.delete(id);
//	}
//
//}
