package com.syb.Dao;

import com.syb.Entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface BillDao {
    //查询某个用户的所有账目
    List<Bill> queryBillByUser(String username, String startDate, String endDate);
    //添加账目
    int addBill(String username, BigDecimal amount, String remark, String billType);

    void deleteBill(int billId);
    void updateBill(int billId, BigDecimal amount, String remark, String billType);
}
