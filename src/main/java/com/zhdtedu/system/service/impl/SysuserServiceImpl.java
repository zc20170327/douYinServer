package com.zhdtedu.system.service.impl;
import javax.annotation.Resource;

import com.zhdtedu.system.entity.Department;
import com.zhdtedu.system.entity.SysUser;
import com.zhdtedu.system.entity.UserDepartment;
import com.zhdtedu.system.mapper.SysUserMapper;
import com.zhdtedu.system.service.SysuserService;
import com.zhdtedu.util.PageUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {

	@Resource
	private SysUserMapper sysuserDAO;

	/**
	 * 查询所有用户
	 * @return
	 */
	public List<SysUser> findAllSysuser(PageUtil pageUtil) {
		//查询记录总数
		int totalCount = sysuserDAO.countUser().size();
		pageUtil.setTotalCount(totalCount);

		List<SysUser> Sysuser = sysuserDAO.findAllSysuser(pageUtil);
		return Sysuser;
	}

	/**
	 * 锁定该用户
	 */
	public void userDeleteById(Integer id) {
		sysuserDAO.userDeleteById(id);
	}

	/**
	 * 根据用户ID解锁用户
	 * @param id
	 * @return
	 */
	public void userClearById(Integer id) {
		sysuserDAO.userClearById(id);
	}
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Department> findAllRole() {
		return sysuserDAO.findAllRole();
	}
	/**
	 * 添加用户
	 * @param sysuser
	 */
	public void sysuserAdd(SysUser sysuser) {
		sysuserDAO.sysuserAdd(sysuser);
	}
	/**
	 * 添加用户角色
	 * @param ur
	 */
	public void userRoleAdd(UserDepartment ur) {
		sysuserDAO.userRoleAdd(ur);

	}
	/**
	 * 修改用户
	 * @param sysuser
	 */
	public void updateUser(SysUser sysuser) {
		sysuserDAO.updateUser(sysuser);
	}
	/**
	 * 根据Id查询用户
	 * @param id
	 * @return
	 */
	public SysUser findById(Integer id) {
		return sysuserDAO.findById(id);
	}
	/**
	 * 根据用户ID查询角色
	 * @param id
	 * @return
	 */
	public List<Department> findRoleByUid(Integer id) {
		return sysuserDAO.findRoleByUid(id);
	}

	/**
	 * 修改角色(删除该用户原有角色)
	 * @param id
	 */
	public void deleteRoles(Integer id) {
		sysuserDAO.deleteRoles(id);
	}
	/**
	 * 修改角色(添加用户角色)
	 * @param userRoleId
	 */
	public void AddUserRole(UserDepartment userRoleId) {
		sysuserDAO.AddUserRole(userRoleId);

	}
}
