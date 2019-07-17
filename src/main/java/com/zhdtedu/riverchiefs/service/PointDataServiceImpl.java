package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.dao.mapper.PointDataMapper;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointDataServiceImpl implements  PointDataService{
    @Autowired
    PointDataMapper pointDataMapper;

    /**
     * 获取检测点信息
     * @return
     */
    @Override
    public  PointData get(){
       PointData PointData=pointDataMapper.getPointData();
        return  PointData;
    }

    @Override
    public RcsResult insert(PointData pointData) {
        try{
            pointDataMapper.insert(pointData);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult deleteById(int id) {
        try{
            pointDataMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }

    @Override
    public RcsResult updatePointData(PointData pointData) {
            try{
                pointDataMapper.updateById(pointData);
            }catch (Exception e){
                e.printStackTrace();
                return  RcsResult.build(500,e.getMessage());

            }
            return RcsResult.ok();

    }

    @Override
    public PageModel getPointDataPages(String name, String start_time, String end_time, String  pageIndex, int pageSize) {
        int counts=0;
        List<PointData> pointDataLists=null;
        int  currentPageNo=0;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        //获取当前条件下的总条数
        try {
            counts=pointDataMapper.getTotalCount(name,start_time,end_time);
        }catch (Exception e){
            e.printStackTrace();
            }
        //计算当前页，结束页
        PageModel pageModel=  new PageModel(currentPageNo,counts,pageSize);
        //获取当前页的数据
        try {
            pointDataLists= pointDataMapper.getLists(name,start_time,end_time,currentPageNo,pageSize);

        }catch (Exception e){
            e.printStackTrace();
        }
        pageModel.setList(pointDataLists);
        return  pageModel;
    }


}
