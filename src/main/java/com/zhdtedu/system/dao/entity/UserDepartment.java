package com.zhdtedu.system.dao.entity;

import lombok.Data;

import javax.persistence.Entity;

public class UserDepartment {
    private  int userId;
    private  int departmentId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
