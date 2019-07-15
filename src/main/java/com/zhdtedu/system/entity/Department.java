package com.zhdtedu.system.entity;

//import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
//import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
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
    @Column(name = "SD_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long	id;
    //名称
    @Column(name = "SDNAME",length = 111)
    private String	name;
    //上级部门
    @Column(name = "S_ID",length = 11)
    private int	sId;
    //是否启用 1代表启用 0代表不启用
    @Column(name = "STATUS",length = 5)
    private Integer	status;
    //用户id
    @Column(name = "U_id",length = 5)
    private Integer	uId;
    //多对多不维护的一方属性，只写mappedBy，值和维护方的属性值一致
   @ManyToMany(mappedBy="departments",fetch = FetchType.LAZY)
    private List<SysUser> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }
}
