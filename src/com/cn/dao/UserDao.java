package com.cn.dao;

import com.cn.model.UserModel;

import java.util.List;

public interface UserDao {
    public boolean login(int id,String pwd);//登录
    public boolean register(UserModel user);//注册
    public List<UserModel> getUserAll();//返回用户信息集合
    public boolean delete(int id) ;//根据id删除用户
    public boolean update(int id, String name) ;//更新用户信息
}
