package com.syb.Controller;

import com.syb.Entity.User;
import com.syb.Service.UserService;
import com.syb.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {
    @Autowired
    private UserService userService;
    String message;
    @RequestMapping("/query")
    public List<User> query(HttpServletRequest request){
        String username = request.getParameter("username");
        System.out.println(username);
        List<User> users = (!"null".equals(username) && username != null)
                ? userService.queryUserByName(username) : userService.queryUserByName("all");
        System.out.println(users);
        return users;
    }
    @RequestMapping("/add")
    public String addUser(@RequestParam("username") String username,@RequestParam("password") String password){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try {
            userService.addUser(username,password);
            message = "增加用户成功";
        }catch (Exception exception){
            message = "增加用户异常";
        }
        return message;
    }
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("username") String username){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try {
            userService.deleteUser(username);
            message = "删除用户成功";
        }catch (Exception exception){
            message = "删除用户异常";
        }
        return username;
    }


}
