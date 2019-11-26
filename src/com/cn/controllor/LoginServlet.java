package com.cn.controllor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.cn.dao.UserDao;
import com.cn.dao.UserDaoImpl;
import com.cn.model.UserModel;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收客户端传输过来的数据,并存储
        PrintWriter out =response.getWriter(); //out对象
        int id;
        String pwd;
        UserDaoImpl ud=new UserDaoImpl();
        id = Integer.parseInt(request.getParameter("id"));
        pwd = request.getParameter("userpwd");
        if (ud.login(id,pwd)){
            request.setAttribute("id",id); //向request域中放置信息
            request.getRequestDispatcher("welcome.jsp").forward(request, response);//转发到成功页面
        }else{
            out.print("<script language='javascript'>alert('用户名或密码错误！！');window.location.href='login.jsp';</script>");
        }
    }
}
