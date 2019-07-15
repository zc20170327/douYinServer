package com.zhdtedu.system.entity;
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
public class SysUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "SU_ID")
    private Long id;
    //名称
    @Column(name = "SYNAME",length = 111)
    private String	name;
    //电话号码
    @Column(name = "TELEPHONE")
    private String	telephone;
    //邮箱
    @Column(name = "MAILBOX")
    private String mailbox;
    //职务
    @Column(name = "ROLE")
    private Date	role;
    //是否启用 1代表启用 0代表不启用
    @Column(name = "STATUS",length = 5)
    private Integer	status;

    //部门id
    @Column(name = "D_ID",length = 5)
    private Integer	dId;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_user_department",
            joinColumns= {@JoinColumn(name = "US_ID", referencedColumnName = "SU_ID")},
            inverseJoinColumns= {@JoinColumn(name = "DE_ID", referencedColumnName = "SD_ID")})
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

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
