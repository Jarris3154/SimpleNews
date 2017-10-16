package com.jia.Dvd.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Dvd {

    @Id
    private String id;
    //Dvd名称
    private String name;
    //借出日期
    private Date lendOutDate;
    //借出次数
    private int lendCount;
    //默认为可借出
    private LendState lendState = LendState.RETURNED;

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

    public Date getLendOutDate() {
        return lendOutDate;
    }

    public void setLendOutDate(Date lendOutDate) {
        this.lendOutDate = lendOutDate;
    }

    public int getLendCount() {
        return lendCount;
    }

    public void setLendCount(int lendCount) {
        this.lendCount = lendCount;
    }

    public LendState getLendState() {
        return lendState;
    }

    public void setLendState(LendState lendState) {
        this.lendState = lendState;
    }
}
