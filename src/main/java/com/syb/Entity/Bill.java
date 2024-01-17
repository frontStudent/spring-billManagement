package com.syb.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Bill {
    private int BillId;
    private String username;
    private String remark;
    private String billType;
    private BigDecimal amount;
    private Timestamp createdTime;
    
    public int getBillId() {
        return BillId;
    }

    public void setBillId(int billId) {
        BillId = billId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
}
