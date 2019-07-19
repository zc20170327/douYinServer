package com.zhdtedu.riverchiefs.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveFlowVoMapper;
import com.zhdtedu.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RcsArchiveFlowVoServiceImpl implements RcsArchiveFlowVoService{

    @Autowired
    private RcsArchiveFlowVoMapper rcsArchiveFlowVoMapper;

    @Autowired
    private PageModel pageModel;

    @Override
    public PageModel selectRcsArchiveFlowVoList(int currentPageNum,int pageSize) {
        PageHelper.startPage(currentPageNum, pageSize);
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoList();
        pageModel.setList(page.getResult());
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNum);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }

    @Override
    public PageModel selectRcsArchiveFlowVoByCondition(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoByCondition(rcsArchiveFlowVo);
        pageModel.setList(page.getResult());
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNo);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }

    @Override
    public RcsArchiveFlowVo getRcsArchiveFlowVoById(String id) {
         return  rcsArchiveFlowVoMapper.getRcsArchiveFlowVoById(id);
    }


}
