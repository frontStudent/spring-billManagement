package com.syb.Dao;

import com.syb.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> queryUserById(String userId);
    List<User> queryUserByName(String username);
    Integer addUser(String username,String password);
    Integer deleteUser(String userId);
}
