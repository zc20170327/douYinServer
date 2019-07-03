package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.bean.TbContent;

import java.util.List;


public interface ContentService {
    List<TbContent> getContentList(long parentId,int pageNo,int pageSize);
    int  getTotalCount(long parentId,int pageNo,int pageSize);
}
