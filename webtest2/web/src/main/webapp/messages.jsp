<%@ page import="com.levelup.core.dao.MessageDAOManager" %>
<%@ page import="com.levelup.model.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="com.levelup.core.dao.MessageHibernateManager" %><%
    List<Message> messages = null;
    if (request.getParameter("topicId")!=null && !request.getParameter("topicId").isEmpty()){
        Long topicId = Long.parseLong(request.getParameter("topicId"));
        InitialContext initialContext = new InitialContext();
        MessageHibernateManager messageDAOManager = (MessageHibernateManager) initialContext.lookup("java:app/core-1.0-SNAPSHOT/MessageHibernateManager");
        messages = messageDAOManager.getAllMessages(topicId);
    }

%>

<table class="messageList" style="">
    <tbody>
    <tr>
        <td>Id</td> <td>User Name</td><td>Message Content</td>
    </tr>
    <%
        for (Message message : messages) {
    %>
    <tr>

        <td id="id_<%= message.getId()%>"><%= message.getId()%></td>
        <%--<td id="name_<%= message.getUser().getId()%>"><%=  message.getUser().getName()%></td>--%>
        <td id="content_<%= message.getId()%>"><%= message.getContent()%></td>

    </tr>
    <%
        }
    %>
    </tbody>

</table>