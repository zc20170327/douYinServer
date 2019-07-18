package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.*;
import com.zhdtedu.system.dao.mapper.UserDepartmentMapper;
import com.zhdtedu.system.dao.mapper.UserMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDepartmentMapper userDepartmentMapper;

	@Override
	public List<User> getUserList(int departId, int pageNo, int pageSize) {
		List<User> userList = userMapper.selectByExample2(departId, pageNo, pageSize);
		return userList;
	}

	@Override
	public int getTotalCount(int id) {
		return userMapper.getTotalCount(id);
	}

	@Override
	public User getUser(int id) {
		return null;
	}

	@Override
	public RcsResult updateUser(User user) {
		try {
			userMapper.updateByPrimaryKey(user);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.ok();
	}

	@Override
	public RcsResult deleteUser(int id) {
		try {
			userMapper.deleteByUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}

	@Override
	public RcsResult saveUser(User user) {
		try {
			userMapper.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);

	}

	@Override
	public RcsResult getNodeList() {
		List<User> userList = null;
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		try {
			userList = userMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.ok(userList);
	}

	@Override
	public RcsResult userDepartmentAdd(UserDepartment userDepartment) {
		try {
			userDepartmentMapper.insert(userDepartment);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);

	}

	@Override
	public RcsResult userDepartmentDelete(int userId) {
		try {
			userDepartmentMapper.deleteByUserDepartment(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}


}

