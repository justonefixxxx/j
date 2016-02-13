
<%@ page import="java.util.List" %>

<%@ page import="com.levelup.model.Topic" %>
<%@ page import="com.levelup.core.dao.MessageHibernateManager" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>

        function onSearchClick(event){
            var td = $(event.target);
            var topicId = td.attr("id");
            $.ajax({
                url: "messages.jsp",
                type: "GET",
                data: { topicId: topicId },
                dataType: "html",
                success: function(data){
                    $("#messages").html(data);
                }
            });
        }

        $(document).ready(
                function (){

                    $(".topicRow").click(onSearchClick);
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
<h2>Topics List:</h2>

<%
    WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
    MessageHibernateManager messageHibernateManager = (MessageHibernateManager) ctx.getBean("messageDAO");
    List<Topic> topics = messageHibernateManager.getAllTopics();
%>

<table class="topicList" style="">
    <tbody>
    <tr>
        <td>Name</td>
    </tr>
    <%
        for (Topic topic:topics) {
    %>
    <tr>
        <td class="topicRow" id="<%= topic.getId()%>"><%= topic.getName()%></td>

    </tr>
    <%
        }
    %>
    </tbody>

</table>

<div id="messages">

</div>
</body>
</html>
