package com.zhdtedu.system.controller;

import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.system.dao.entity.Department;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.dao.entity.UserDepartment;
import com.zhdtedu.system.service.DepartmentService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    int  currentPageNo=0;
    int  pageSize=10;
    int totalCount=0;
    /**
     * 获取用户列表
     *
     *params:deptId部门节点的id
     *
     *
     */

    @ApiOperation(value = "获取用户列表", notes = "根据部门deptId，索引页pageIndex获取数据列表")
    @GetMapping("/users")
    public RcsResult getUserList( @ApiParam( name="deptId", value="部门id") @RequestParam(value="deptId",required = false) int deptId,
                                      @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=false,defaultValue="1") String pageIndex) {
        List<User> userList =null;
        System.out.println("pageIndex"+pageIndex);
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        System.out.println(deptId);
        totalCount= userService.getTotalCount(deptId);
        PageModel pageModel=  new PageModel(currentPageNo,totalCount,pageSize);
        try {
            userList = userService.getUserList(deptId,currentPageNo,pageSize);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500, e.getMessage());
        }
        pageModel.setList(userList);
        return  RcsResult.ok(pageModel);
    }


/**
     * 新增用户部门数据
     * params：获取选中的parentId
     */

    @ApiOperation(value = "新增用户部门数据", notes = "新增用户部门数据")
    @ApiImplicitParam(name = "user", value = "User", required = true, dataType = "User")
    @PostMapping("/users")
    public RcsResult saveUser( @RequestBody User user,int []deptId){
        RcsResult result=userService.saveUser(user);
        System.out.println(user.getUserId());
        UserDepartment userDepartment=new UserDepartment();
        for (Integer rid : deptId) {
            userDepartment.setUserId(user.getUserId());
            userDepartment.setDeptId(rid);
            userService.userDepartmentAdd(userDepartment);
        }
        return  result;
    }


/**
     * 删除用户数据
     * params:id
     */

    @ApiOperation(value = "删除用户,部门用户数据", notes = "删除用户，部门用户数据")
    @DeleteMapping("/users/{id}")
    public RcsResult deleteUser(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") int id){
        userService.deleteUser(id);
        RcsResult result=userService.userDepartmentDelete(id);
        return  result;
    }
    /*
     * 修改用户保存的信息
     * 更新表单中的信息
     * @RequestBody将json数据转化为对应的实体
     */

    @ApiOperation(value = "修改用户后保存", notes = "根据节点id更新数据")
    @PutMapping("/users")
    public  RcsResult   modifyUser( @RequestBody User  user,Integer[] deptId){
        RcsResult result= userService.updateUser(user);
        List<Department> findDeptByUid = departmentService.findDeptByUid(user.getUserId());
        for (int i = 0; i <=findDeptByUid.size(); i++) {
            userService.userDepartmentDelete(user.getUserId());
        }
        UserDepartment userDepartment=new UserDepartment();
        for (Integer rid : deptId) {
            userDepartment.setUserId(user.getUserId());
            userDepartment.setDeptId(rid);
            userService.userDepartmentAdd(userDepartment);
        }
        return  result;
    }
    /**
     * 获取动态树节点
     */
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/users/nodes")
    public RcsResult getNodeList( ){
        RcsResult result= userService.getNodeList();
        return  result;
    }
}


