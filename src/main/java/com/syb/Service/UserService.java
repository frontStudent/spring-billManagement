package com.syb.Service;

import com.syb.Dao.UserDao;
import com.syb.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> queryUserByName(String username){
        System.out.println(username);
        return userDao.queryUserByName(username);
    }

    public Integer addUser(String username,String password){
        return userDao.addUser(username,password);
    }

    public Integer deleteUser(String username){
        return userDao.deleteUser(username);
    }
}
