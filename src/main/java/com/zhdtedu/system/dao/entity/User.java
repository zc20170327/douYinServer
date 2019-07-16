package com.zhdtedu.system.dao.entity;
//import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
//import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sys_users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USER_ID_")
    private Long id;
    //名称
    @Column(name = "USER_NAME_",length = 111)
    private String	name;
    //电话号码
    @Column(name = "TELEPHONE_")
    private String	telephone;
    //邮箱
    @Column(name = "MAILBOX_")
    private String mailbox;
    //职务
    @Column(name = "ROLE_")
    private Date	role;
    //是否启用 1代表启用 0代表不启用
    @Column(name = "USER_STATUS_",length = 5)
    private Integer	status;

    //部门id
    @Column(name = "DEPART_ID_",length = 5)
    private Integer	departId;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_user_department",
            joinColumns= {@JoinColumn(name = "USER_ID_", referencedColumnName = "USER_ID_")},
            inverseJoinColumns= {@JoinColumn(name = "DEPT_ID_", referencedColumnName = "DEPT_ID_")})
    private List<Department> departments = new ArrayList<>();

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Date getRole() {
        return role;
    }

    public void setRole(Date role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
