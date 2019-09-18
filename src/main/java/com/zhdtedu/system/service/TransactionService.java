package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.Transaction;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.web.multipart.MultipartFile;

public interface TransactionService {
    //新增监测点数据
    RcsResult insert(Transaction transaction);
    //根据ID删除监测点
    RcsResult deleteById(int id);
    //根据ID更新监测点
    RcsResult update(Transaction transaction);
    //根据起始页获取数据
    PageModel getPages(String  pageIndex, String pageSize,String transactionId);
    //更具条件获取用户信息
    RcsResult get(Transaction transaction);
}
