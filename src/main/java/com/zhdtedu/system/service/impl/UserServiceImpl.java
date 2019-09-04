package com.zhdtedu.system.service.impl;
import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.dao.mapper.TaskMapper;
import com.zhdtedu.system.dao.mapper.UserMapper;
import com.zhdtedu.system.service.TaskService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public RcsResult insert(User user) {
        User  userTemp;
        try{
            //验证用户名是否存在
            userTemp=new User();
            userTemp.setUserName(user.getUserName());
            int countName=userMapper.get(userTemp);
            if(countName>0){
                return RcsResult.build(500,"用户名存在");
            }
            //验证手机号码是否存在
            userTemp=new User();
            userTemp.setPhone(user.getPhone());
            int countPhone=userMapper.get(userTemp);
            if(countPhone>0){
                return RcsResult.build(500,"手机号存在");
            }
            userMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult deleteById(int id) {
        try{
            userMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }

    @Override
    public RcsResult update(User user) {
        try{
            userMapper.updateById(user);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }
        return RcsResult.ok();

    }

    @Override
    public PageModel getPages(String  pageIndex, int pageSize) {
        int counts=0;
        List<User> userLists=null;
        int  currentPageNo=0;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        //获取当前条件下的总条数
        try {
            counts=userMapper.getTotalCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        //计算当前页，结束页
        PageModel pageModel=  new PageModel(currentPageNo,counts,pageSize);
        //获取当前页的数据
        try {
            userLists= userMapper.getLists(currentPageNo,pageSize);

        }catch (Exception e){
            e.printStackTrace();
        }
        pageModel.setList(userLists);
        return  pageModel;
    }

    @Override
    public RcsResult login(String name, String password) {
        try {
            int count =userMapper.login(name,password);
            if (count>0){
                return RcsResult.build(201,"登录成功",1);
            }else{
                return RcsResult.build(404,"登录失败",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
    }

    @Override
    public RcsResult userTasks(User user) {
        try {
            List<User> users = userMapper.userTasks(user);
            return RcsResult.ok(users);
        }catch(Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }
    }
}
