package com.zhdtedu.system.dao.mapper;
import com.zhdtedu.system.dao.entity.CustomerService;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerServiceMapper {
    int insert(CustomerService customerService);
    int deleteById(int id);
    int updateById(CustomerService customerService);
    int getTotalCount();
    List<CustomerService> getLists(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("customerId") int customerId);
}
