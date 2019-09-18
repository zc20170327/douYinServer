package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;

public interface UserService {
        //新增监测点数据
        RcsResult insert(User user);
        //根据ID删除监测点
        RcsResult deleteById(int id);
        //根据ID更新监测点
        RcsResult update(User user);
        //根据起始页获取数据
        PageModel getPages(String pageIndex, int pageSize);
        //登录
        RcsResult  login(String name ,String  password);
        //获取用户的任务
        RcsResult userTasks(User user);
        //更具条件获取用户信息
        RcsResult get(User user);
        //用户充值
        RcsResult recharge(int  userId,int amount);
        //用户提现
        RcsResult withdraw(int  userId,int amount);
        //用户充值审核
        RcsResult rechargeReview(int userId, int amount,int operatorId,int transactionId);
        //用户提现审核
        RcsResult withdrawReview(int userId, int amount,int operatorId,int transactionId);
        //图片识别后的充值，不用审核
        void  imageRecharge(int  userId,int amount);

}
