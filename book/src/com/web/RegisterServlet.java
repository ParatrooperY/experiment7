package com.web;

import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //检查验证码是否正确
        if ("abcde".equalsIgnoreCase(code)) {
            //检查用户名是否可用
            if (userService.existsUsername(username)) {
                //不可用
                System.out.println("用户名[" + username + "]已存在");
                //跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
            } else {
                //可用
                //调用Service保存到数据库
                userService.registerUser((new User(null, username, password, email)));
                //跳回注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }
    }

}
