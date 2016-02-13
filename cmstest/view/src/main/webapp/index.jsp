<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="com.levelup.services.EntityManagementIf" %>
<%@ page import="com.levelup.model.entity.Product" %>
<%@ page import="java.util.List" %><%
    InitialContext initialContext = new InitialContext();

    EntityManagementIf entityManagementBean = (EntityManagementIf) initialContext.lookup("java:app/services-1.0-SNAPSHOT/EntityManagementBean");
    List<Product> productList = entityManagementBean.getAllProducts();
%>
<html>
<body>
<form name="createProduct" action="product.jsp">
    <div>Create Product:</div>
<table class="productInfo" style="">
    <tbody>
    <tr>
        <td>Name</td><td><input id="pName" type="text" name="pName"></td>
    </tr>
    <tr>
        <td>Code</td><td><input id="pCode" type="text" name="pCode"></td>
    </tr>
    <tr>
        <td>Description</td><td><input id="pDesc" type="text" name="pDesc"></td>
    </tr>
    <tr>
        <td>On Sale</td><td><input id="pSale" type="checkbox" name="pSale"></td>
    </tr>
    <tr>
        <td>On Promo</td><td><input id="pPromo" type="checkbox" name="pPromo"></td>
    </tr>
    <tr>
        <td colspan="2">
            <table id="priceInfo">
                <tbody>
                    <tr>
                     <td>Price</td><td>Regular price</td><td>Promo price</td><td>Sale price</td><td>Net price</td>
                    </tr>
                    <tr>
                        <td>Value</td>
                        <td><input type="text" id="rPrice" name="RP"></td>
                        <td><input type="text" id="pPrice" name="PP"></td>
                        <td><input type="text" id="sPrice" name="SP"></td>
                        <td><input type="text" id="nPrice" name="NP"></td>
                    </tr>
                </tbody>
            </table>
        </td>

    </tr>

    </tbody>

</table>
    <input type="submit">
</form>

<table class="productList" style="">
    <tbody>
    <tr>
        <td>Id</td> <td>Code</td><td>Name</td><td>On Sale</td><td>On Promo</td><td>Current Price</td><td>Regular Price</td>
    </tr>
    <%
        for (Product p : productList) {
    %>
    <tr>
        <td><%= p.getId()%></td>
        <td><%= p.getCode()%></td>
        <td><%= p.getName()%></td>
        <td><%= p.getOnSale()%></td>
        <td><%= p.getOnPromo()%></td>
        <td><%= p.getCurrentPrice()%></td>
        <td><%= p.getRegularPrice()%></td>

    </tr>
    <%
        }
    %>
    </tbody>

</table>

</body>
</html>
