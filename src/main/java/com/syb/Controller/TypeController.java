package com.syb.Controller;

import com.syb.Entity.BillType;
import com.syb.Service.BillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//用户登录后的跳转页面
public class TypeController {
    @Autowired
    private BillTypeService BillTypeService;

    @RequestMapping("/queryTypeByUser")
    public List<BillType> queryTypeByUser(HttpServletRequest request){
        String username = request.getParameter("username");
        List<BillType> billTypes = BillTypeService.queryTypeByUser(username);
        return billTypes;
    }

    @RequestMapping("/addBillType")
    public void addBill(HttpServletRequest request){
        String username = request.getParameter("username");
        String billType = request.getParameter("billType");
        BillTypeService.addBillType(username,billType);
    }

    @RequestMapping("/deleteBillType")
    public void deleteBill(HttpServletRequest request){
        String username = request.getParameter("username");
        String billType = request.getParameter("billType");
        BillTypeService.deleteBillType(username,billType);
    }

    @RequestMapping("/updateBillType")
    public void updateBill(HttpServletRequest request){
        String username = request.getParameter("username");
        String oldBillType = request.getParameter("oldBillType");
        String newBillType = request.getParameter("newBillType");
        BillTypeService.updateBillType(username,oldBillType,newBillType);
    }
}
