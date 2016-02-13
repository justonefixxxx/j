package com.levelup.main;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 6/4/13
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Enumeration headerNames =  req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String header = (String) headerNames.nextElement();
            String value = req.getHeader(header);
        }
        String userName = req.getParameter("userName");
        Map paramMap = req.getParameterMap();
        Set keys = paramMap.keySet();
        for (Object key : keys){
            String paramValue = (String) paramMap.get(key);
        }

        HttpSession session = req.getSession();

        if (session.getAttribute("user")!=null){
            String user = (String) session.getAttribute("user");
        } else {
            session.setAttribute("user","User");
        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<head></head>");
        writer.println("<body>");
        writer.println("<h1>Hello</h1>");
        writer.println("</body>");
        resp.setStatus(HttpServletResponse.SC_OK);


    }
}
