package com.syb.Controller;
import com.syb.Entity.Bill;
import com.syb.Service.BillService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.sql.Timestamp;

@RestController
@CrossOrigin(origins = "*")
//用户登录后的跳转页面
public class InitController {
    @Autowired
    private BillService billService;

    @RequestMapping("/queryBillByUser")
    public List<Bill> queryBillByUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        System.out.println(startDate);
        System.out.println(endDate);
        List<Bill> bills = billService.queryBillByUser(username, startDate, endDate);
        return bills;
    }

    @RequestMapping("/addBill")
    public void addBill(HttpServletRequest request){
        String username = request.getParameter("username");
        String remark = request.getParameter("remark");
        String billType = request.getParameter("billType");
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        System.out.println(amount);
        System.out.println(billType);

        billService.addBill(username,amount,remark,billType);
    }

    @RequestMapping("/deleteBill")
    public void deleteBill(HttpServletRequest request){
        int billId = Integer.parseInt(request.getParameter("billId"));
        billService.deleteBill(billId);
    }

    @RequestMapping("/updateBill")
    public void updateBill(HttpServletRequest request){
        String remark = request.getParameter("remark");
        String billType = request.getParameter("billType");
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        int billId = Integer.parseInt(request.getParameter("billId"));
        billService.updateBill(billId,amount,remark,billType);
    }
}
