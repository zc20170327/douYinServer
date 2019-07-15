package com.zhdtedu.system.mapper;


import com.zhdtedu.system.entity.Department;
import com.zhdtedu.system.entity.SysUser;
import com.zhdtedu.system.entity.UserDepartment;
import com.zhdtedu.util.PageUtil;

import java.util.List;

public interface SysUserMapper {

    /**
     * 查询所有用户
     */
     List<SysUser> findAllSysuser(PageUtil pageUtil);
    /**
     * 统计条数
     */
     List<SysUser> countUser();
    /**
     * 锁定该用户
     */
     void userDeleteById(Integer id);
    /**
     * 根据用户ID解锁用户
     */
     void userClearById(Integer id);
    /**
     * 查询所有部门
     */
     List<Department> findAllRole();
    /**
     * 添加用户
     */
     void sysuserAdd(SysUser sysuser);
    /**
     * 添加用户部门
     */
     void userRoleAdd(UserDepartment ud);
    /**
     * 修改用户
     */
     void updateUser(SysUser sysuser);
    /**
     * 根据Id查询用户
     */
     SysUser findById(Integer id);
    /**
     * 根据用户ID查询部
     * */
     List<Department> findRoleByUid(Integer id);
    /**
     * 修改部门(删除该用户原有部门)
     */
     void deleteRoles(Integer id);
    /**
     * 修改部门(添加用户部门)
     */
     void AddUserRole(UserDepartment userDepartment);

}