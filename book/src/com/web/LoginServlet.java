package com.web;

import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用userService.login()登录处理业务
        User loginUser = userService.login(new User(null,username,password,null));
        //如果等于null，说明登录失败
        if(loginUser == null){
            //跳回登录页面
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }else {
            //登录成功
            //跳到登录成功页面
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }
    }
}
