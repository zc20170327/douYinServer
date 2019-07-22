package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.SysFileInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

public interface SysFileInfoService {

    public void uploadFile(File file, HttpServletRequest request);

    public void save(SysFileInfo file);

    public SysFileInfo getFileInfo(Integer id);

    public void deleteFileInfo(Integer id);

    public List<SysFileInfo> selectByFileCode(String code);

    public void updateFileCode(String oldCode,String nowCode);

}
