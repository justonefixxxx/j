<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 7/13/13
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="com.levelup.services.EntityManagementIf" %>
<%@ page import="com.levelup.model.entity.Product" %>
<%@ page import="com.levelup.model.entity.PriceType" %>
<%@ page import="com.levelup.model.entity.Price" %>
<%@ page import="com.levelup.view.helpers.ProductHelper" %>
<%@ page import="java.util.ArrayList" %><%
    boolean isError = false;
    InitialContext initialContext = new InitialContext();

    EntityManagementIf entityManagementBean = (EntityManagementIf) initialContext.lookup("java:app/services-1.0-SNAPSHOT/EntityManagementBean");

    Product product = new Product();
    ArrayList<Price> prices = new ArrayList<Price>();
    if (request.getParameter("pName")!=null && !request.getParameter("pName").isEmpty()){
        product.setName(request.getParameter("pName"));
    } else {
        isError = true;
    }
    if (request.getParameter("pCode")!=null && !request.getParameter("pCode").isEmpty()){
        product.setCode(request.getParameter("pCode"));
    }  else {
        isError = true;
    }
    if (request.getParameter("pDesc")!=null && !request.getParameter("pDesc").isEmpty()){
        product.setDescription(request.getParameter("pDesc"));
    }
    if (request.getParameter("pSale")!=null && !request.getParameter("pSale").isEmpty()){
        product.setOnSale(Boolean.parseBoolean(request.getParameter("pSale")));
    }
    if (request.getParameter("pPromo")!=null && !request.getParameter("pPromo").isEmpty()){
        product.setOnPromo(Boolean.parseBoolean(request.getParameter("pPromo")));
    }
    for (PriceType pt:PriceType.values()){
        if (request.getParameter(pt.getCode())!=null && !request.getParameter(pt.getCode()).isEmpty()){
            Price price = ProductHelper.createPrice(pt, request.getParameter(pt.getCode()));
            if (price != null){
                prices.add(price);
            }
        }
    }
    product.setPrices(prices);

    if (!isError) {
        Product persistentProduct = entityManagementBean.createProduct(product);
        if (persistentProduct.getId()==null){
            isError = true;
        }
    }
//    entityManagementBean.createProduct();
%>
<html>
<head>
    <title></title>
</head>
<body>
    <c:if test="{isError == true}">
        <h2>Product don't saved!</h2>
    </c:if>

    <c:if test="{isError == false}">
        <h2>Product successfully saved!</h2>
    </c:if>
</body>
</html>