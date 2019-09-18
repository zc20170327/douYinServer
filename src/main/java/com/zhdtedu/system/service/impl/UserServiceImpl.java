package com.zhdtedu.system.service.impl;
import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.dao.entity.Transaction;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.dao.mapper.TaskMapper;
import com.zhdtedu.system.dao.mapper.TransactionMapper;
import com.zhdtedu.system.dao.mapper.UserMapper;
import com.zhdtedu.system.service.TaskService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TransactionMapper transactionMapper;


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
            List<User> users =userMapper.login(name,password);
            if (users.size()>0){
                return RcsResult.build(201,"登录成功",users);
            }else{
                return RcsResult.build(404,"登录失败",users);
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

    @Override
    public RcsResult get(User user) {
        try {
            List<User> users=userMapper.getUser(user);
            return RcsResult.ok(users);
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }

    }

    @Override
    public RcsResult recharge(int userId, int amount) {
        try {
            Transaction transaction=new Transaction();
            transaction.setTransactionTime(new Date());
            transaction.setUserId(userId);
            transaction.setAmount(amount);
            transaction.setStatus("未审核");
            transaction.setType("充值");
            transactionMapper.insert(transaction);
            return RcsResult.build(201,"用户ID"+userId+"充值成功:"+amount+";请管理员及时审核");

        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }

    }
    @Override
    public RcsResult withdraw(int userId, int amount) {
        try {
            Transaction transaction=new Transaction();
            transaction.setTransactionTime(new Date());
            transaction.setUserId(userId);
            transaction.setAmount(amount);
            transaction.setStatus("未审核");
            transaction.setType("提现");
            transactionMapper.insert(transaction);
            return RcsResult.build(201,"用户ID"+userId+"提现成功:"+amount+";请管理员及时审核");

        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }
    }
    @Override
    public RcsResult rechargeReview(int userId, int amount,int operatorId,int transactionId) {
        User user=new User();
        user.setUserId(userId);
        try {
            List<User> users=userMapper.getUser(user);
            if(users.size()>0){
                User newUser=users.get(0);
                newUser.setIntegral(newUser.getIntegral()+amount);
                //更新用户积分
                userMapper.updateById(newUser);
                //更新交易订单的信息
                Transaction transaction=new Transaction();
                transaction.setId(transactionId);
                List<Transaction> transactions=transactionMapper.get(transaction);
                if(transactions.size()>0){
                    transaction=transactions.get(0);
                    transaction.setStatus("审核");
                    transaction.setOperatorId(operatorId);
                    transaction.setReviewTime(new Date());
                    transactionMapper.updateById(transaction);
                }
                else{
                    return  RcsResult.build(500,"充值订单不存在");
                }
                return RcsResult.build(201,newUser.getUserName()+"充值成功:"+amount);
            }else{
                return  RcsResult.build(500,"充值用户不存在");
            }
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }

    }

    @Override
    public RcsResult withdrawReview(int userId, int amount,int operatorId,int transactionId) {
        User user=new User();
        user.setUserId(userId);
        try {
            List<User> users=userMapper.getUser(user);
            if(users.size()>0){
                User newUser=users.get(0);
                newUser.setIntegral(newUser.getIntegral()-amount);
                userMapper.updateById(newUser);
                //更新交易订单的信息
                Transaction transaction=new Transaction();
                transaction.setId(transactionId);
                List<Transaction> transactions=transactionMapper.get(transaction);
                if(transactions.size()>0){
                    transaction=transactions.get(0);
                    transaction.setStatus("审核");
                    transaction.setOperatorId(operatorId);
                    transaction.setReviewTime(new Date());
                    transactionMapper.updateById(transaction);
                }
                else{
                    return  RcsResult.build(500,"充值订单不存在");
                }
                return RcsResult.build(201,newUser.getUserName()+"提现成功:"+amount);
            }else{
                return  RcsResult.build(500,"充值用户不存在");
            }
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }

    }

    @Override
    public void imageRecharge(int userId, int amount) {
        User user=new User();
        user.setUserId(userId);
        try {
            List<User> users=userMapper.getUser(user);
            if(users.size()>0){
                User newUser=users.get(0);
                newUser.setIntegral(newUser.getIntegral()+amount);
                //更新用户积分
                userMapper.updateById(newUser);
            }else{
            }
        }catch (Exception e){

        }
    }
}
