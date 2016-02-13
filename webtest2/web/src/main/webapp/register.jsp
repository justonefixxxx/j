<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@ page import="com.levelup.core.dao.UserDAOManager" %>
<jsp:useBean id="user" class="com.levelup.model.User" scope="request"/>
<jsp:setProperty name="user" property="*"/>

<%

    UserDAOManager userDAOManager = new UserDAOManager();
    if (user.getName()!=null && user.getRole()!=null){
         userDAOManager.createUser(user);
         response.sendRedirect("index.jsp") ;
    }

%>