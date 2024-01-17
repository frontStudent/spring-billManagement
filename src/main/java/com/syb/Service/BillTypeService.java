package com.syb.Service;

import com.syb.Dao.BillTypeDao;
import com.syb.Entity.BillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("BillTypeService")
public class BillTypeService {
    @Autowired
    private BillTypeDao billTypeDao;

    public List<BillType> queryTypeByUser(String username){
        return billTypeDao.queryTypeByUser(username);
    }
    public int addBillType(String username, String billType){
        return billTypeDao.addBillType(username,billType);
    }
    public void deleteBillType(String username, String billType){
        billTypeDao.deleteBillType(username, billType);
    }
    public void updateBillType(String username,String oldBillType,String newBillType){
        billTypeDao.updateBillType(username, oldBillType, newBillType);
    }
}
