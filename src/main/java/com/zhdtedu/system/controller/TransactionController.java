package com.zhdtedu.system.controller;


import com.zhdtedu.system.dao.mapper.TransactionMapper;
import com.zhdtedu.system.service.TransactionService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/transaction")
public class TransactionController {
    @Autowired
    UserService userService;
    @Autowired
    TransactionService transactionService;
    @ApiOperation(value = "用户提现", notes = "用户提现")
    @PostMapping("/withdraw")
    public RcsResult withdraw(
            @ApiParam( name="userId", value="用户Id") @RequestParam(value="userId",required=true) int userId
            ,@ApiParam( name="amount", value="提现金额") @RequestParam(value="amount",required=true) int amount) {
        RcsResult result = userService.withdraw(userId,amount);
        return result;
    }
    @ApiOperation(value = "用户充值", notes = "用户充值")
    @PostMapping("/recharge")
    public RcsResult recharge(
            @ApiParam( name="userId", value="用户Id") @RequestParam(value="userId",required=true) int userId
            ,@ApiParam( name="amount", value="充值金额") @RequestParam(value="amount",required=true) int amount) {
        RcsResult result = userService.recharge(userId,amount);
        return result;
    }
    @ApiOperation(value = "用户充值审核", notes = "用户充值审核")
    @PostMapping("/rechargeReview")
    public RcsResult rechargeReview(
            @ApiParam( name="userId", value="用户Id") @RequestParam(value="userId",required=true) int userId
            ,@ApiParam( name="amounot", value="充值金额") @RequestParam(value="amounot",required=true) int amount
            ,@ApiParam( name="operatorId", value="操作员Id") @RequestParam(value="operatorId",required=true) int operatorId
            ,@ApiParam( name="transactionId", value="订单Id") @RequestParam(value="transactionId",required=true) int transactionId) {
        RcsResult result = userService.rechargeReview(userId,amount,operatorId,transactionId);
        return result;
    }
    @ApiOperation(value = "用户提现审核", notes = "用户提现审核")
    @PostMapping("/withdrawReview")
    public RcsResult withdrawReview(
            @ApiParam( name="userId", value="用户Id") @RequestParam(value="userId",required=true) int userId
            ,@ApiParam( name="amounot", value="提现金额") @RequestParam(value="amounot",required=true) int amount
            ,@ApiParam( name="operatorId", value="操作员Id") @RequestParam(value="operatorId",required=true) int operatorId
            ,@ApiParam( name="transactionId", value="订单Id") @RequestParam(value="transactionId",required=true) int transactionId) {
        RcsResult result = userService.withdrawReview(userId,amount,operatorId,transactionId);
        return result;
    }


    @ApiOperation(value = "获取交易数据列表", notes = "有页数显示第几页，没有显示所有，可以根据ID来查询 ")
    @GetMapping("/transactions")
    public RcsResult getLists(
            @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=true,defaultValue="0") String pageIndex,
            @ApiParam( name="pageSize", value="每页显示条数") @RequestParam(value="pageSize",required=true,defaultValue="4") String pageSize,
            @ApiParam( name="transactionId", value="交易ID") @RequestParam(value="transactionId",required=true,defaultValue="0") String transactionId) {

        PageModel PageModel=transactionService.getPages(pageIndex,pageSize,transactionId);
        return  RcsResult.ok(PageModel);
    }






}
