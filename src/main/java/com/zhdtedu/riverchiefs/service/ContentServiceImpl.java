package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.bean.TbContent;
import com.zhdtedu.riverchiefs.bean.TbContentExample;
import com.zhdtedu.riverchiefs.dao.mapper.TbContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private  TbContentMapper tbContentMapper;
    @Override
    public List<TbContent> getContentList(long parentId,int pageNo,int pageSize) {
      TbContentExample example=new TbContentExample();
      TbContentExample.Criteria criteria= example.createCriteria();
        criteria.andParentidEqualTo(parentId);
        List<TbContent> contentList=tbContentMapper.selectByExample2(parentId,pageNo-1,pageSize);
        System.out.println("contentList"+contentList.get(0));
        return   contentList;
    }

    @Override
    public int getTotalCount(long parentId, int pageNo, int pageSize) {
        return tbContentMapper.getTotalCount(parentId,pageNo-1,pageSize);

    }
}
