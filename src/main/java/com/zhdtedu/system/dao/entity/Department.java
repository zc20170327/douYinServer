package com.zhdtedu.system.dao.entity;

//import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
//import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Table(name = "sys_department")
@Data
public class Department {
    @Id
    @Column(name = "DEPT_ID_")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int	id;
    //名称
    @Column(name = "DEPT_NAME_",length = 111)
    private String	name;
    //上级部门
    @Column(name = "PART_ID_",length = 11)
    private int	partId;
    //是否启用 1代表启用 0代表不启用
    @Column(name = "DEPT_STATUS_",length = 5)
    private Integer	status;
    //用户id
    @Column(name = "USER_ID_",length = 5)
    private Integer	userId;
    //多对多不维护的一方属性，只写mappedBy，值和维护方的属性值一致
   @ManyToMany(mappedBy="departments",fetch = FetchType.LAZY)
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
