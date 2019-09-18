package com.zhdtedu.system.dao.mapper;
import com.zhdtedu.system.dao.entity.Transaction;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;
import java.util.List;


public interface TransactionMapper {
    int insert(Transaction transaction);
    int deleteById(int id);
    int updateById(Transaction transaction);
    //获取任务数据总条数
    int getTotalCount();
    //获取任务数据列表
    List<Transaction> getLists(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize,@Param("transactionId") int transactionId);
    //获取根据条件获取任务数
    List<Transaction> get(Transaction transaction);
}
