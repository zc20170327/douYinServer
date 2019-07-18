package com.zhdtedu.riverchiefs.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVoExample;
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
        RcsArchiveFlowVoExample example = new RcsArchiveFlowVoExample();
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoByExample(example);
        pageModel.setList(page.getResult());
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNum);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }

    @Override
    public PageModel selectRcsArchiveFlowVoByExample(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        RcsArchiveFlowVoExample example = new RcsArchiveFlowVoExample();
        RcsArchiveFlowVoExample.Criteria criteria = example.createCriteria();
        if(rcsArchiveFlowVo!=null){
            if(rcsArchiveFlowVo.getArchNum()!=null && rcsArchiveFlowVo.getArchNum().length()>0){
                criteria.andArchNumLike("%"+rcsArchiveFlowVo.getArchNum()+"%");
            }
            if(rcsArchiveFlowVo.getQuestionFrom()!=null && rcsArchiveFlowVo.getQuestionFrom().length()>0){
                criteria.andQuestionFromEqualTo(rcsArchiveFlowVo.getQuestionFrom());
            }
            if(rcsArchiveFlowVo.getQuestionType()!=null && rcsArchiveFlowVo.getQuestionType().length()>0){
                criteria.andQuestionTypeLike("%"+rcsArchiveFlowVo.getQuestionType()+"%");
            }
            if(rcsArchiveFlowVo.getSuosLiuy()!=null && rcsArchiveFlowVo.getSuosLiuy().length()>0){
                criteria.andSuosLiuyLike("%"+rcsArchiveFlowVo.getSuosLiuy()+"%");
            }
            if(rcsArchiveFlowVo.getStatus()!=null && rcsArchiveFlowVo.getStatus().length()>0){
                criteria.andStatusEqualTo(rcsArchiveFlowVo.getStatus());
            }
            if(rcsArchiveFlowVo.getDeptName()!=null && rcsArchiveFlowVo.getDeptName().length()>0){
                criteria.andDeptNameEqualTo(rcsArchiveFlowVo.getDeptName());
            }
        }
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoByExample(example);
        pageModel.setList(page.getResult());
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNo);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }


}
