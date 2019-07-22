package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;

import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.util.BusinessRuntimeException;
import com.zhdtedu.util.SearchCondition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/*
@Service
@Transactional(readOnly =true)
public class RcsArchiveInfoServiceImpl implements  RcsArchiveInfoService{

    @Resource
    private RcsArchiveInfoMapper rcsArchiveInfoMapper;

    @Resource
    private SysFileInfoService sysFileInfoService;



    @Override
    public List<RcsArchiveInfo> pageQuery(SearchCondition sc){
        Map<String,Object> param = sc.getParameter();
        param.put("startNo",sc.getStartNo());
        param.put("pageSize",sc.getPageSize());
        sc.setPageTotal(2);
        List<RcsArchiveInfo> list  = this.rcsArchiveInfoMapper.pageQuery(param);
        return list;
    }

    @Override
    public RcsArchiveInfo getRcsArchiveInfo(Integer id) {
        return rcsArchiveInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void addRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo,SearchCondition sc) {
        if(rcsArchiveInfo!=null && (rcsArchiveInfo.getId()==null || rcsArchiveInfo.getId()==0)) {
            rcsArchiveInfo.setArchNum(getArchNumCode());
        }
        rcsArchiveInfoMapper.insert(rcsArchiveInfo);
        if(sc.getValue("tempCode")!=null && sc.getValue("tempCode").equals("")){
            sysFileInfoService.updateFileCode(sc.getValue("tempCode"),"rcsArchiveInfo-"+rcsArchiveInfo.getId());
        }
        }


    @Override
    @Transactional(readOnly = false)
    public void modifyRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo,SearchCondition sc) {
        this.rcsArchiveInfoMapper.updateByPrimaryKey(rcsArchiveInfo);
        if(sc.getValue("tempCode")!=null && sc.getValue("tempCode").equals("")){
            sysFileInfoService.updateFileCode(sc.getValue("tempCode"),"rcsArchiveInfo-"+rcsArchiveInfo.getId());
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteRcsArchiveInfo(Integer id){
        this.deleteRcsArchiveInfo(id);
    }

    */
/**
     * 从数据库获取当天的最大编号
     * @return
     *//*

    private String getArchNumCode(){
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
        String code = sfm.format(new Date()).replace("-","");
        Long nowCode = this.rcsArchiveInfoMapper.selectArchNumMaxCode(code);
        System.out.println(nowCode);
        if(nowCode==null||nowCode.equals("")){
            return  code+"0001";
        }
        return nowCode.toString();
    }

    public static void main(String[] args) {
        RcsArchiveInfoServiceImpl a = new RcsArchiveInfoServiceImpl();
        System.out.println(a.getArchNumCode());
    }
}
*/
