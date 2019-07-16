package com.zhdtedu.system.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserDepartment {
    private  int uId;
    private  int dId;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public void setuId(Long valueOf) {
    }
}
