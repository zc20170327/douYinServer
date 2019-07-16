/*
package com.zhdtedu.system.service;

import com.zhdtedu.system.entity.Department;
import com.zhdtedu.system.entity.SysUser;
import com.zhdtedu.system.entity.UserDepartment;
import com.zhdtedu.util.PageUtil;

import java.util.List;

public interface SysuserService {

	*/
/**
	 * 查询所有用户
	 * @return
	 *//*

	public List<SysUser> findAllSysuser(PageUtil pageUtil);

	*/
/**
	 * 锁定该用户
	 * @param id
	 *//*

	public void userDeleteById(Integer id);

	*/
/**
	 * 根据用户ID解锁用户
	 * @param id
	 * @return
	 *//*

	public void userClearById(Integer id);
	*/
/**
	 * 查询所有部門
	 * @return
	 *//*

	public List<Department> findAllRole();

	*/
/**
	 * 添加用户
	 * @param sysuser
	 *//*

	public void sysuserAdd(SysUser sysuser);

	*/
/**
	 * 添加用户部門
	 * @param ud
	 *//*

	public void userRoleAdd(UserDepartment ud);
	*/
/**
	 * 修改用户
	 * @param sysuser
	 *//*

	public void updateUser(SysUser sysuser);
	*/
/**
	 * 根据Id查询用户
	 * @param id
	 * @return
	 *//*

	public SysUser findById(Integer id);
	*/
/**
	 * 根据用户ID查询部門
	 * @param id
	 * @return
	 *//*

	public List<Department> findRoleByUid(Integer id);
	*/
/**
	 * 修改部门(删除该用户原有部门)
	 * @param id
	 *//*

	public void deleteRoles(Integer id);
	*/
/**
	 * 修改部门(添加用户部门)
	 * @param userDepartment
	 *
	 *//*

	public void AddUserRole(UserDepartment userDepartment);

}
*/
