package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.CustomerService;
import com.zhdtedu.system.dao.entity.Transaction;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;

public interface CustomerServiceService {
    //新增监测点数据
    RcsResult insert(CustomerService customerService);
    //根据ID删除监测点
    RcsResult deleteById(int id);
    //根据ID更新监测点
    RcsResult update(CustomerService customerService);
    //根据起始页获取数据
    PageModel getPages(String pageIndex, String pageSize, String transactionId);
}
