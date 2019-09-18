package com.zhdtedu.system.controller;


import com.zhdtedu.system.dao.entity.CustomerService;
import com.zhdtedu.system.service.CustomerServiceService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/customerService")
public class CustomerServiceController {
    /**
     * 获取任务数据
     */
    @Autowired
    CustomerServiceService customerServiceService;
    /**
     * 新增客服点数据信息
     */

    @ApiOperation(value = "新增客服数据信息", notes = "新增客服数据信息")
    @PostMapping("/insert")
    public RcsResult insert(@RequestBody CustomerService customerService) {
        RcsResult result = customerServiceService.insert(customerService);
        return result;
    }
    /**
     * 删除客服数据信息
     */
    @ApiOperation(value = "删除客服数据", notes = "根据客服id删除数据")
    @DeleteMapping("/delete/{id}")
    public  RcsResult delete(@ApiParam(required =true, name="id", value="客服ID") @PathVariable("id") int id){
        RcsResult result= customerServiceService.deleteById(id);
        return  result;
    }
    /**
     * 更新客服数据信息
     *
     */
    @ApiOperation(value = "更新客服数据信息", notes = "更新客服数据信息")
    @PutMapping("/update")
    public RcsResult update(@RequestBody CustomerService customerService){
        return      customerServiceService.update(customerService);
    }

    /**
     * 获取客服数据列表
     */
    @ApiOperation(value = "获取客服数据列表-客服后台分页查询", notes = "根据索引页pageIndex获取数据列表")
    @GetMapping("/customerServices")
    public RcsResult getLists(
            @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=true,defaultValue="0") String pageIndex,
            @ApiParam( name="pageSize", value="每页显示条数") @RequestParam(value="pageSize",required=true,defaultValue="4") String pageSize,
            @ApiParam( name="customerId", value="客服ID") @RequestParam(value="customerId",required=true,defaultValue="0") String customerId) {
        PageModel PageModel=customerServiceService.getPages(pageIndex,pageSize,customerId);
        return  RcsResult.ok(PageModel);
    }

}
