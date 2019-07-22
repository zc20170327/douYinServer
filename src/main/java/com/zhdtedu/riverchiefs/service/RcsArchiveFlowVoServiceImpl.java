package com.zhdtedu.riverchiefs.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveFlowVoMapper;
import com.zhdtedu.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RcsArchiveFlowVoServiceImpl implements RcsArchiveFlowVoService{

    List<RcsArchiveFlowVo>  list;
    double hour = 0;

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

    @Override
    public PageModel selectRcsArchiveFlowVoHandledList(int currentPageNum, int pageSize) {
        PageHelper.startPage(currentPageNum, pageSize);
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoHandledList();
        pageModel.setList(page.getResult());
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNum);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }

    @Override
    public PageModel getRcsArchiveFlowVoDispatchedList(int currentPageNum, int pageSize) {
        PageHelper.startPage(currentPageNum, pageSize);
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoDispatchedList();
        list = page.getResult();
        for (RcsArchiveFlowVo ra:list) {
            ra.setHours((int) getDistanceTime(ra.getOperTime(),new Date()));
        }
        pageModel.setList(list);
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNum);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }

    @Override
    public PageModel selectRcsArchiveFlowVoHandledListByConditon(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoHandledListByConditon(rcsArchiveFlowVo);
        pageModel.setList(page.getResult());
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNo);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }

    @Override
    public PageModel selectRcsArchiveFlowVoDispatchedListByConditon(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        Page<RcsArchiveFlowVo> page = (Page<RcsArchiveFlowVo>)rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoDispatchedListByConditon(rcsArchiveFlowVo);
        pageModel.setList(page.getResult());
        pageModel.setTotalRecords((int)page.getTotal());
        pageModel.setPageSize(page.getPageSize());
        pageModel.setCurrentPageNum(currentPageNo);
        pageModel.setTotalPageNum(page.getPageNum());
        return  pageModel;
    }

    /**
     * 计算历时（小时）
     * @param startTime
     * @param endTime
     * @return
     */
    public double getDistanceTime(Date startTime, Date endTime) {
        long time1 = startTime.getTime();
        long time2 = endTime.getTime();
        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        hour = (diff / (60 * 60 * 1000));
        return hour;
    }

}
