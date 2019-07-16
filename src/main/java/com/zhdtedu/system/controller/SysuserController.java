//package com.zhdtedu.system.controller;
//
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//
//import com.zhdtedu.system.entity.Department;
//import com.zhdtedu.system.entity.SysUser;
//import com.zhdtedu.system.entity.UserDepartment;
//import com.zhdtedu.system.service.SysuserService;
//import com.zhdtedu.util.PageUtil;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import static java.lang.Long.*;
//
//
//@Controller
//@RequestMapping("/sysuser")
//public class SysuserController {
//	@Resource
//	private SysuserService sysuserService;
//
//	private final String reMain = "redirect:/sysuser/findAllSysuser";
//	/**
//	 * 查询所有用户
//	 * @param requestMap
//	 * @param page
//	 * @return
//	 */
//	@RequestMapping("/findAllSysuser")
//	public String findAllSysuser(Map<String ,Object> requestMap , String page){
//		int currentPage = 1 ;
//		if(page != null){
//			currentPage = Integer.parseInt(page);
//		}
//		PageUtil pageUtil = new PageUtil(currentPage);
//		List<SysUser> sysusers = sysuserService.findAllSysuser(pageUtil);
//		List<Department> sysroles = sysuserService.findAllRole();
//		requestMap.put("sysroles", sysroles);
//		requestMap.put("sysusers", sysusers);
//		requestMap.put("pageUtil", pageUtil);
//		return "/sysuser/sysuserMain";
//
//	}
//
//
//	/**
//	 * 添加用户
//	 * @param sysuser
//	 * @param roleId
//	 * @return
//	 */
//	@RequestMapping("/sysuserAdd")
//	public String sysuserAdd(SysUser sysuser ,Integer[] roleId){
//		sysuser.setName(sysuser.getName());
//		sysuser.setStatus(0);
//		sysuser.setMailbox(sysuser.getMailbox());
//		sysuser.setTelephone(sysuser.getTelephone());
//		sysuser.setRole(sysuser.getRole());
//		sysuserService.sysuserAdd(sysuser);
//		for (Integer dId : roleId) {
//			Department d = new Department();
//			d.setId(valueOf(dId));
//
//			UserDepartment urid = new UserDepartment();
//			urid.setuId(valueOf(sysuser.getId()));
//			urid.setdId(dId);
//
//			sysuserService.userRoleAdd(urid);
//		}
//		return reMain;
//	}
//	/*@RequestMapping("/userUpdateInit")
//	public String userUpdateInit(Integer id , Map<String,Object> requestMap){
//		Sysuser user = sysuserService.findById(id);
//		List<Sysrole> roles = sysuserService.findRoleByUid(id);
//		String roleIds = "";
//		for (Sysrole role : roles) {
//			roleIds += role.getId()+",";
//		}
//		roleIds = roleIds.substring(0,roleIds.length()-1);
//		List<Sysrole> roleInfo = sysuserService.findAllRole();
//		System.out.println(roleIds);
//		requestMap.put("user", user);
//		requestMap.put("roles", roleIds);
//		requestMap.put("roleInfo", roleInfo);
//		return "sysuserUpdate";
//	}*/
//
//
//	/**
//	 * 修改用户
//	 * @return
//	 * @throws Exception
//	 */
//	/*@RequestMapping("/updateSysuser")
//	public String updateSysuser(Sysuser sysuser,Integer[] roleIds){
//		sysuserService.updateUser(sysuser);
//
//		List<Sysrole> findRoleByUid = sysuserService.findRoleByUid(sysuser.getId());
//		for (int i = 0; i <=findRoleByUid.size(); i++) {
//			sysuserService.deleteRoles(sysuser.getId());
//		}
//
//		UserRoleId userRoleId = new UserRoleId();
//		for (Integer role : roleIds) {
//			Sysrole sysrole = new Sysrole();
//			sysrole.setId(role);
//			userRoleId.setSysuser(sysuser);
//			userRoleId.setSysrole(sysrole);
//			sysuserService.AddUserRole(userRoleId);
//		}
//		return reMain;
//	}*/
//}
