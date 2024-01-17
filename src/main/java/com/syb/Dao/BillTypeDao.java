package com.syb.Dao;

import com.syb.Entity.BillType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BillTypeDao {
    //查询某个用户的所有账目类型
    List<BillType> queryTypeByUser(String username);
    //添加账目
    int addBillType(String username,String billType);
    void deleteBillType(String username,String billType);
    void updateBillType(String username,String oldBillType,String newBillType);
}
