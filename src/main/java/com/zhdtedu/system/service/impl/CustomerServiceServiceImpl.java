package com.zhdtedu.system.service.impl;
import com.zhdtedu.system.dao.entity.CustomerService;
import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.dao.entity.Transaction;
import com.zhdtedu.system.dao.mapper.CustomerServiceMapper;
import com.zhdtedu.system.service.CustomerServiceService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {
    @Autowired
    CustomerServiceMapper customerServiceMapper;

    @Override
    public RcsResult insert(CustomerService customerService) {
        try{
            customerServiceMapper.insert(customerService);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }
    @Override
    public RcsResult deleteById(int id) {
        try{
            customerServiceMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }

    @Override
    public RcsResult update(CustomerService customerService) {
        try{
            customerServiceMapper.updateById(customerService);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }
        return RcsResult.ok();

    }

    @Override
    public PageModel getPages(String  pageIndex, String pageSize,String customerId) {
        int counts=0;
        List<CustomerService> transactionLists=null;
        int  currentPageNo=0;
        int  pageSizeNo=0;
        int customerNo=0;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        if(pageSize != null){
            try{
                pageSizeNo = Integer.valueOf(pageSize);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        if(customerId != null){
            try{
                customerNo = Integer.valueOf(customerId);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        //获取当前条件下的总条数
        try {
            counts=customerServiceMapper.getTotalCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        //计算当前页，结束页
        PageModel pageModel=  new PageModel(currentPageNo,counts,pageSizeNo);
        //获取当前页的数据
        try {
            transactionLists= customerServiceMapper.getLists(currentPageNo,pageSizeNo,customerNo);

        }catch (Exception e){
            e.printStackTrace();
        }
        pageModel.setList(transactionLists);
        return  pageModel;
    }

}
