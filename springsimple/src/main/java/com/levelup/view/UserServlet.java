package com.levelup.view;

import com.levelup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/8/13
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */

public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = (UserService) ctx.getBean("userService");
        userService.getUserById(12L);
        resp.getWriter().append("<h1>Hello World!!!</h1>");
        resp.getWriter().flush();
        resp.getWriter().close();
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
