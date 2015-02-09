package com.alibaba.dubbo.user.nospring.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.user.api.UserService;

/**
 *
 * @author Shunli
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = -4816526546207125738L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = DubboServicesFactory.getService(UserService.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(userService.getUser(i + ""));
        }
    }
}
