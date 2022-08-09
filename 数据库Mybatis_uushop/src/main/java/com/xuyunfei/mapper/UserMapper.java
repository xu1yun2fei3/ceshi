package com.xuyunfei.mapper;

import com.xuyunfei.entity.User;

import java.util.List;

//自定义接口
public interface UserMapper {
    public User findById(Integer id);
    public List<User> findAll();
    public int save(User user);
    public int deleteById(Integer id);
    public int update(User user);
}
