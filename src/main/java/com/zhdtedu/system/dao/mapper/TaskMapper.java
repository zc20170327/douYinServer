package com.zhdtedu.system.dao.mapper;
import java.util.ArrayList;
import com.zhdtedu.system.dao.entity.Task;
import org.apache.ibatis.annotations.Param;


public interface TaskMapper {
    int insert(Task task);
    int deleteById(int id);
    int updateById(Task task);
    //获取任务数据总条数
    int getTotalCount();
    //获取任务数据列表
    ArrayList<Task> getLists(@Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize);
    //获取根据条件获取任务数
    Task get(Task task);
}
