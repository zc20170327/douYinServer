package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.util.SearchCondition;

import java.util.List;

public interface RcsArchiveInfoService {

    public List<RcsArchiveInfo> pageQuery(SearchCondition sc);

    public RcsArchiveInfo getRcsArchiveInfo(Integer id);

    public void addRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo);

    public void modifyRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo);

    public void deleteRcsArchiveInfo(Integer id);

}
