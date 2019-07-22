package com.zhdtedu.system.service.impl;

import com.zhdtedu.system.dao.entity.SysFileInfo;
import com.zhdtedu.system.dao.mapper.SysFileInfoMapper;
import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysFileInfoService")
public class SysFileInfoServiceImpl implements SysFileInfoService {

    @Resource
    SysFileInfoMapper sysFileInfoMapper;

    @Override
    public void uploadFile(File file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("");
        String tempCode = request.getParameter("tempId");
        if(tempCode!=null && !tempCode.equals("")){
            SysFileInfo sfi = new SysFileInfo();
            sfi.setFileCode(tempCode);
            sfi.setTempCode(tempCode);
            System.out.println("===========file.getName()========"+file.getName());
            sfi.setFileName(file.getName());
            sfi.setFilePath(file.getPath());
            sfi.setFileSize(file.length());
            sfi.setUploadDate(new Date());
//            if(FileUtils.getFileType("fileType").equals(".pdf")){
//                sfi.setUrl(file.getPath());
//                sfi.setStatus("true");
//            }else if(FileUtils.getFileType("fileType").equals(".jpg")){
//                sfi.setUrl(file.getPath());
//                sfi.setStatus("true");
//            }else if(FileUtils.getFileType("fileType").equals(".png")){
//                sfi.setUrl(file.getPath());
//                sfi.setStatus("true");
//            }else{
//                boolean flag = OfficeToPdfTools.convert2PDF(file.getPath(), path+"\\"+
//                        file.getName()+".pdf");
//                sfi.setUrl(path+"\\"+
//                        file.getName()+".pdf");
//                sfi.setStatus(flag+"");
//            }
            sfi.setFileType(FileUtils.getFileType(file.getName()));
            sfi.setExt(FileUtils.getFileSize(file.length()));
            this.save(sfi);
        }
    }

    @Override
    public void save(SysFileInfo file) {
        sysFileInfoMapper.insertSelective(file);
    }

    @Override
    public SysFileInfo getFileInfo(Integer id) {
        return sysFileInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteFileInfo(Integer id) {
        SysFileInfo file = this.getFileInfo(id);
        System.out.println("==========file========"+file);
        File f = new File(file.getFilePath());
        f.getAbsolutePath();
        this.sysFileInfoMapper.deleteByPrimaryKey(file.getId());
        System.out.println("===delete file====="+f.getPath());
        if(f.exists()){
            System.out.println("===delete exists====="+f.getPath());
            f.delete();
        }
    }

    @Override
    public List<SysFileInfo> selectByFileCode(String fileCode) {
        System.out.println("============code========="+fileCode);
        return this.sysFileInfoMapper.selectByFileCode(fileCode);
    }

    @Override
    public void updateFileCode(String oldCode,String nowCode) {
        Map<String, String> map = new HashMap<>();
        map.put("oldCode",oldCode);
        map.put("nowCode",nowCode);
        this.sysFileInfoMapper.updateFileCode(oldCode,nowCode);
    }
}
