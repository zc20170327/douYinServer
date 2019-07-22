package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.util.PageModel;

public interface RcsArchiveFlowVoService {
    /**
     * 查询所有代办案卷
     * @param currentPageNum
     * @param pageSize
     * @return
     */
    public PageModel selectRcsArchiveFlowVoList(int currentPageNum, int pageSize);

    /**
     * 带条件查询
     * @param currentPageNo
     * @param pageSize
     * @param rcsArchiveFlowVo
     * @return
     */
    public PageModel selectRcsArchiveFlowVoByCondition(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 根据案卷编号查询vo
     * @param id
     * @return
     */
    public  RcsArchiveFlowVo getRcsArchiveFlowVoById(String id);

    /**
     * 查询已办案卷
     * @param currentPageNum
     * @param pageSize
     * @return
     */
    public PageModel selectRcsArchiveFlowVoHandledList(int currentPageNum, int pageSize);



    /**
     * 根据条件查询已办列表
     * @param currentPageNo
     * @param pageSize
     * @param rcsArchiveFlowVo
     * @return
     */
    public PageModel selectRcsArchiveFlowVoHandledListByConditon(int currentPageNo, int pageSize,RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 查询已派列表
     * @param currentPageNum
     * @param pageSize
     * @return
     */
    public PageModel getRcsArchiveFlowVoDispatchedList(int currentPageNum, int pageSize);

    /**
     * 根据条件查询已派列表
      * @param currentPageNo
     * @param pageSize
     * @param rcsArchiveFlowVo
     * @return
     */
    public PageModel selectRcsArchiveFlowVoDispatchedListByConditon(int currentPageNo, int pageSize,RcsArchiveFlowVo rcsArchiveFlowVo);
}
