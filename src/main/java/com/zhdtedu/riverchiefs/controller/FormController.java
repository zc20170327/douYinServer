package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.bean.Archives;
import com.zhdtedu.riverchiefs.vo.BaseVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author: create by songhongzhe
 * @version: v1.0
 * @description: cn.cncommdata.metadata.controller
 * @date:2019-03-28
 **/

@RestController
@Slf4j
public class FormController {

    /**
     * 根据表单Id获取表单详情信息
     *
     * @param tenantId 租户Id
     * @param grantId  grantId
     * @param formId   表单Id
     * @return FormVO
     */
    @ApiOperation("根据表单Id获取表单详情信息")
    @GetMapping("/form")
    public BaseVO<Archives> getForm(@ApiParam("租户ID") @RequestHeader("tenant_id") Long tenantId,
                                    @ApiParam("GrantID") @RequestHeader("grant_id") Long grantId,
                                    @ApiParam("表单ID") @RequestParam("form_id") Long formId) {
        return null;
    }

    /**
     * 根据表单Id获取表单详情信息
     *
     * @param tenantId 租户Id
     * @param grantId  grantId
     * @param formId   表单Id
     * @return FormVO
     */
    @ApiOperation("根据表单Id获取表单详情信息")
    @GetMapping("/form/{form_id}")
    public BaseVO<Archives> getFormByUser(@ApiParam("租户ID") @RequestHeader("tenant_id") Long tenantId,
                                        @ApiParam("GrantID") @RequestHeader("grant_id") Long grantId,
                                        @ApiParam("表单ID") @PathVariable("form_id") Long formId) {
        return getForm(tenantId, grantId, formId);
    }

    /**
     * 根据搜索条件，分页获取表单列表
     *
     * @param tenantId 租户Id
     * @param formGroupId 表单分组Id，不传获取全部，传0获取所有未分组表单
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return FormVOs
     */
    @ApiOperation("获取表单列表")
    @GetMapping("/form/list")
    public BaseVO<List<Archives>> getFormList(@ApiParam("租户ID") @RequestHeader("tenant_id") Long tenantId,
                                                 @ApiParam("表单分组Id") @RequestParam(value = "form_group_id", required = false) Long formGroupId,
                                                 @ApiParam("当前页") Integer pageNum,
                                                 @ApiParam("页面大小") Integer pageSize) {
        return null;
    }

    /**
     * 根据Label获取form的ID，type，name，parent
     *
     * @param tenantId 租户Id
     * @param label    标签名
     * @return FormVOs
     */
    @ApiOperation("根据Label获取form的ID，type，name，parent")
    @GetMapping("/form/list/label")
    public BaseVO<List<Archives>> getFormListByLabel(@ApiParam("租户ID") @RequestHeader("tenant_id") Long tenantId,
                                                   @ApiParam("标签名称") @RequestParam String label) {
        return null;
    }

    /**
     * 发布表单信息，将表单置为enable
     *
     * @param grantId grantId
     * @param formId  表单Id
     * @return baseVO
     */
    @ApiOperation("发布表单")
    @PutMapping("/form/deploy")
    public BaseVO deployForm(@ApiParam(value = "grantId", required = true) @RequestHeader("grant_id") Long grantId,
                             @ApiParam(value = "表单Id", required = true) @RequestParam("form_id") Long formId) {
        //解析form和对应的tree，确定所有需要权限，将form注入菜单并注入authorization_group, 所有权限直接注入权限authorization
        //同时需要解析所有字段，初始化自增字段，注入变量管理模块
        //注入ES索引，tenant_id和form_id
        //向模版系统中注入生成模版请求
        return null;
    }

    /**
     * 添加表单
     *
     * @param tenantId 租户ID
     * @param grantId  grantId
     * @param formJson 表单
     * @return BaseVO
     */
    @ApiOperation("添加表单")
    @PostMapping("/form")
    public BaseVO createForm(@ApiParam("租户ID") @RequestHeader("tenant_id") Long tenantId,
                             @ApiParam("GrantID") @RequestHeader("grant_id") Long grantId,
                             @ApiParam("form表单,格式详见设计文档") @RequestParam("form") String formJson) {

        return null;
    }

    /**
     * 绑定、解绑分类树
     *
     * @param grantId grantId
     * @param formId  表单Id
     * @param treeId  分类树Id
     * @return baseVO
     */
    @ApiOperation("绑定，解绑（treeId为空时）分类树")
    @PutMapping("/form/tree")
    public BaseVO bindTree(@ApiParam("grantId") @RequestParam("grant_id") Long grantId,
                           @ApiParam("表单Id") @RequestParam("form_id") Long formId,
                           @ApiParam("分类树Id") @RequestParam("tree_id") Long treeId) {
        //treeId为空时
        ////解除formId与treeId的绑定，并调用分类树方法，将form中原分类树Id传入
        //检查treeId是否绑定有其他form
        ////提示无法绑定
        //绑定form表单与分类树，并调用分类树方法将表单信息与分类树双向绑定

        return null;
    }

    /**
     * 编辑表单
     *
     * @param grantId  grantId
     * @param formJson 表单
     * @return BaseVO
     */
    @ApiOperation("表单编辑")
    @PutMapping("/form")
    public BaseVO editForm(@ApiParam("GrantID") @RequestHeader("grant_id") Long grantId,
                           @ApiParam("form表单,格式详见设计文档") @RequestParam("form") String formJson) {

        return null;
    }

    /**
     * 删除表单（无数据）
     *
     * @param grantId grantId
     * @param formId  formId
     * @return BaseVO
     */
    @ApiOperation("表单删除")
    @DeleteMapping("/form")
    public BaseVO deleteForm(@ApiParam("GrantID") @RequestHeader("grant_id") Long grantId,
                             @ApiParam("表单ID") @RequestParam("form_id") Long formId) {
        //在权限管理模块删除所有相关权限
        //删除变量管理中相应自增变量
        //ES中删除相关索引信息
        return null;
    }

}
