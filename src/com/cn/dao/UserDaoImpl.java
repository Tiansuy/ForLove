package com.cn.dao;

import com.cn.model.UserModel;
import com.cn.util.DBconn;

import java.lang.invoke.MutableCallSite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //注册方法
    public boolean register(UserModel user) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into person(name,password,id,uid,info) " +
                "values('" + user.getName() + "','" + user.getPassword() + "','" + user.getId() + "','" + user.getUid() +"','"+user.getInfo()+ "')");
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    //登陆验证方法
    public boolean login(int id, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from person where id='" + id + "' and password='" + pwd + "'");
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("id")) == id && rs.getString("password").equals(pwd)) {
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //返回全部用户信息集合
    public List<UserModel> getUserAll() {
        List<UserModel> list = new ArrayList<>();
        try {
            try {
                DBconn.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ResultSet rs = DBconn.selectSql("select * from person");
            while (rs.next()) {
                String nameone = rs.getString("name");
                String passwordone = rs.getString("password");
                int idone = rs.getInt("id");
                String uidone = rs.getString("uid");
                String infoone =rs.getString("info");
                UserModel user = new UserModel(nameone, passwordone, idone, uidone,infoone);
                list.add(user);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据ID删除用户
    public boolean delete(int id) {
        boolean flag = false;
        try {
            DBconn.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "delete from person where id='" + id + "'";
        int i = DBconn.addUpdDel(sql);//判断sql语句是否成功
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    //修改姓名
    public boolean update(int id, String name) {
        boolean flag = false;
        try {
            DBconn.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update person set name ='" + name

                + "'" + "where id = '" + id + "'";

        int i = DBconn.addUpdDel(sql);
        System.out.println("1" + " " + i);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}
