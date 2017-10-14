package com.jia.departments.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

public class Department {
	@Id
	private String id;
	//部门名
	private String name;

	//部门编号
	@Indexed(unique = true)
	private Integer number;

	@LastModifiedDate
	private Date lastModifiedDate;

	@LastModifiedBy
	private String lastModifiedBy;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
}
