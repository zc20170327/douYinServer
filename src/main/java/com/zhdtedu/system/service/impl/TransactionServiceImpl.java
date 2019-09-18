package com.zhdtedu.system.service.impl;



import com.zhdtedu.system.dao.entity.Transaction;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.dao.mapper.TransactionMapper;
import com.zhdtedu.system.service.TransactionService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionMapper transactionMapper;

    @Override
    public RcsResult insert(Transaction transaction) {
        try{
            transactionMapper.insert(transaction);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult deleteById(int id) {
        try{
            transactionMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }

    @Override
    public RcsResult update(Transaction transaction) {
        try{
            transactionMapper.updateById(transaction);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }
        return RcsResult.ok();

    }

    @Override
    public PageModel getPages(String  pageIndex, String pageSize,String transactionId) {
        int counts=0;
        List<Transaction> transactionLists=null;
        int  currentPageNo=0;
        int  pageSizeNo=0;
        int transactionNo=0;
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
        if(transactionId != null){
            try{
                transactionNo = Integer.valueOf(transactionId);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        //获取当前条件下的总条数
        try {
            counts=transactionMapper.getTotalCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        //计算当前页，结束页
        PageModel pageModel=  new PageModel(currentPageNo,counts,pageSizeNo);
        //获取当前页的数据
        try {
            transactionLists= transactionMapper.getLists(currentPageNo,pageSizeNo,transactionNo);

        }catch (Exception e){
            e.printStackTrace();
        }
        pageModel.setList(transactionLists);
        return  pageModel;
    }

    @Override
    public RcsResult get(Transaction transaction) {
        try {
            List<Transaction> transactions=transactionMapper.get(transaction);
            return RcsResult.ok(transactions);
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }
    }
}
