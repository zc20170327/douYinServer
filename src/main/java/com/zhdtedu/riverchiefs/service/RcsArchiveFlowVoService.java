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
}
