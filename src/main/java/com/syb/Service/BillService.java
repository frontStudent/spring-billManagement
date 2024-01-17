package com.syb.Service;

import com.syb.Dao.BillDao;
import com.syb.Entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("BillService")
public class BillService {
    @Autowired
    private BillDao billDao;

    public List<Bill> queryBillByUser(String username, String startDate, String endDate){
        return billDao.queryBillByUser(username, startDate, endDate);
    }
    public int addBill(String username, BigDecimal amount, String remark, String billType){
        return billDao.addBill(username, amount, remark, billType);
    }
    public void deleteBill(int billId){
        billDao.deleteBill(billId);
    }
    public void updateBill(int billId, BigDecimal amount, String remark, String billType){
        billDao.updateBill(billId, amount, remark, billType);
    }
}
