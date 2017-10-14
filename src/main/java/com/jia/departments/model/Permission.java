package com.jia.departments.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="permissions")
public class Permission {
    @Id
    private String id;
    //权限名
    private String name;
    //权限编号
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

}
