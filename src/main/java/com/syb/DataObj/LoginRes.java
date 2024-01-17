package com.syb.DataObj;

public class LoginRes {
    private String jwt;
    private String message;
    //status
    // 0 有效token自动登录成功
    // 1 无效token跳转登录页
    // 2 登录/注册成功签发新token
    // 3 登录失败密码不正确
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
