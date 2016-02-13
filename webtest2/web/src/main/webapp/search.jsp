
<%@ page import="com.levelup.core.dao.UserDAOManager" %>
<%@ page import="com.levelup.model.User" %>
<%@ page import="java.util.List" %>
<%
    String query = request.getParameter("query");
    List<User> users = null;
    if (query!=null){
        UserDAOManager userDAOManager = new UserDAOManager();
        users = userDAOManager.searchUser(query);
    }
%>
<table class="userSearchList" style="">
    <tbody>
    <tr>
        <td>Id</td> <td>Name</td><td>Role</td>
    </tr>
    <%
        for (User user : users) {
    %>
    <tr>
        <td id="id_<%= user.getId()%>"><%= user.getId()%></td>
        <td id="name_<%= user.getId()%>"><%= user.getName()%></td>
        <td id="role_<%= user.getId()%>"><%= user.getRole()%></td>

    </tr>
    <%
        }
    %>
    </tbody>

</table>