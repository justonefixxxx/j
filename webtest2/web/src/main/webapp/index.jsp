<%@ page import="com.levelup.core.dao.UserDAOManager" %>
<%@ page import="com.levelup.model.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>
        function onEditClick(event){
            var checkbox = $(event.target);
            var checkboxId = checkbox.attr("id");
            var userId = checkboxId.replace("edit_","");
//            var userName = $("#name_"+userId).text();
//            var userRole = $("#role_"+userId).text();
//
//            var inputName = $("#editFormDiv").find("input[name='name']");
//            var inputRole = $("#editFormDiv").find("input[name='role']");
//            var inputId = $("#editFormDiv").find("input[name='id']");
//
//            inputId.val(userId);
//            inputName.val(userName);
//            inputRole.val(userRole);
            if (checkbox.prop("checked")){
                $("#userDiv_"+userId).show();
                $("#isEdit_"+userId).val("true");
            } else {
                $("#userDiv_"+userId).hide();
                $("#isEdit_"+userId).val("false");
            }
        }

        function onSearchClick(event){
            var query = $("#query").val();
            $.ajax({
                    url: "search.jsp",
                    type: "GET",
                    data: { query: query },
                    dataType: "html",
                    success: function(data){
                       $("#searchContent").html(data);
                    }
                });
        }

        $(document).ready(
                function (){
                    $(".editButton").click(onEditClick);
                    $("#searchButton").click(onSearchClick);
                }
        );

    </script>
    <style>
        table {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h2>Users List:</h2>

<%
    UserDAOManager userDAOManager = new UserDAOManager();
    List<User> users = userDAOManager.getAllUsers();
%>

<table class="userList" style="">
    <tbody>
        <tr>
            <td>Id</td> <td>Name</td><td>Role</td><td>Edit</td>
        </tr>
        <%
          for (User user : users) {
        %>
          <tr>
              <td><input type="checkbox" id="edit_<%= user.getId()%>" class="editButton" name="editCheckbox"/></td>
              <td id="id_<%= user.getId()%>"><%= user.getId()%></td>
              <td id="name_<%= user.getId()%>"><%= user.getName()%></td>
              <td id="role_<%= user.getId()%>"><%= user.getRole()%></td>

          </tr>
    <%
        }
    %>
    </tbody>

</table>

<div id="editFormDiv" >
    <h5>Edit User:</h5>
    <form action="edit.jsp" method="POST" id="editForm" name="editForm">
        <%
            for (User user : users) {
        %>
        <div id="userDiv_<%= user.getId()%>" style="display: none;">
            <input id="isEdit_<%= user.getId()%>" name="isEdit_<%= user.getId()%>" type="hidden" value="false"/>
            <input name="id_<%= user.getId()%>" type="hidden" value="<%= user.getId()%>"/>
            <table>
                <tbody>
                <tr>
                    <td width="30%">Name:</td> <td><input type="text" name="name_<%= user.getId()%>" value="<%= user.getName()%>"/></td>
                </tr>
                <tr>
                    <td width="30%">Role</td> <td><input type="text" name="role_<%= user.getId()%>" value="<%= user.getRole()%>"/></td>
                </tr>
                </tbody>

            </table>
        </div>
        <%
            }
        %>
         <input type="submit">

    </form>

</div>

<div id="searchDiv">
    <form id="searchForm">
        Name: <input id="query" name="query" type="text"/>
        <input id="searchButton"  type="button" value="Search"/>
    </form>
    <div id="searchContent">

    </div>
</div>
</body>
</html>
