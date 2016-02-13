<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@ page import="com.levelup.core.dao.UserDAOManager" %>
<%@ page import="com.levelup.model.User" %>
<%@ page import="java.util.*" %>


<%

    UserDAOManager userDAOManager = new UserDAOManager();

    List<User> users = new ArrayList<User>();
    List<Long> userIds = new ArrayList<Long>();
    Map parameters = request.getParameterMap();
    Set keys = parameters.keySet();
    Iterator iter = keys.iterator();
    while (iter.hasNext()){
        String key = (String) iter.next();
        String userId = null;
        if (key.contains("id_")){
            userId = request.getParameter(key);
            userIds.add(Long.parseLong(userId));
        }

    }

    for (Long id : userIds){
        String isEdit = request.getParameter("isEdit_"+id);
        if (isEdit.equals("true")){
            User user = new User();
            user.setId(id);
            user.setName(request.getParameter("name_"+id));
            user.setRole(request.getParameter("role_"+id));
            users.add(user);
        }
    }

    for (User u: users){
        int result = userDAOManager.updateUser(u);
    }

    response.sendRedirect("index.jsp") ;

%>