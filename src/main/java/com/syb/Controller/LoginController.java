package com.syb.Controller;

import com.syb.DataObj.LoginRes;
import com.syb.Entity.User;
import com.syb.Service.UserService;
import com.syb.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public LoginRes login(HttpServletRequest request){
        LoginRes LoginRes = new LoginRes();
        JwtUtils jwtUtils = new JwtUtils();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(DigestUtils.md5DigestAsHex(password.getBytes()));
        String token = request.getHeader("token");

        //先查用户是否存在
        List<User> users = (!"null".equals(username) && username != null)
                ? userService.queryUserByName(username) : userService.queryUserByName("all");
        //用户存在则校验密码
        if(users.size() != 0) {
            System.out.println("用户存在");
            //密码不正确
            if(!users.get(0).getPassword().equals(password)){
                LoginRes.setMessage("密码不正确");
                LoginRes.setStatus(3);
                return LoginRes;
            }
            //密码正确，签发token
            else{
                String jwt = jwtUtils.createJwt(username,1500,"helloMyKey");
                LoginRes.setJwt(jwt);
                LoginRes.setMessage("登录成功");
                LoginRes.setStatus(2);
            }
        }
        //用户不存在则直接注册，签发token
        else{
            System.out.println("用户不存在");
            userService.addUser(username,password);
            String jwt = jwtUtils.createJwt(username,1500,"helloMyKey");
            LoginRes.setJwt(jwt);
            LoginRes.setMessage("注册成功");
            LoginRes.setStatus(2);
        }
        
        //如果携带token，解析token
//        if (!"null".equals(token) && token != null) {
//            System.out.println(token);
//            if(jwtUtils.parseJwt(token,"helloMyKey").equals(username)){
//                LoginRes.setJwt(token);
//                LoginRes.setMessage("token解析正确，登录成功");
//                LoginRes.setStatus(0);
//            }
//            else{
//                LoginRes.setJwt(token);
//                LoginRes.setMessage("无效的token");
//                LoginRes.setStatus(1);
//            }
//        }

        return LoginRes;
    }
}
