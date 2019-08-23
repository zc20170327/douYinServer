package com.zhdtedu.system.dao.mapper;
import com.zhdtedu.system.dao.entity.UserTask;
public interface UserTaskMapper {
    int insert(UserTask userTask);
    int deleteById(int id);
    int updateById(UserTask userTask);
    int get(UserTask userTask);
}
