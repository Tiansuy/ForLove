package com.cn.controllor;

import com.cn.dao.UserDao;
import com.cn.dao.UserDaoImpl;
import com.cn.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); //姓名
        String pwd = request.getParameter("pwd");  //密码
        int id = Integer.parseInt(request.getParameter("id")); //主键学号
        String uid = request.getParameter("uid");      //用户名——昵称
        String info = request.getParameter("info");  //信息

        UserDao ud=new UserDaoImpl();
        UserModel user = new UserModel();
        user.setName(name);
        user.setPassword(pwd);
        user.setId(id);
        user.setUid(uid);
        user.setInfo(info);

        if (ud.register(user)){
            request.setAttribute("username", name);
            //request.setAttribute("xiaoxi", "注册成功");  //测试
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
                response.sendRedirect("error.jsp");//重定向到首页
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
