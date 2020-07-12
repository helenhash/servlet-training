<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/productList.css" />
<title>List of Products</title>
</head>
<body>
	<div class="survey-page">
        <h1 id="title">Product Management</h1>
        <div id="form-container">
        <h2>
        	<a href="product?action=new">Add New Product</a>
        	
        </h2>
        <table cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.description}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td>
                    	<a href="product?action=edit&id=<c:out value='${product.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="product?action=delete&id=<c:out value='${product.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </div>	
</body>
</html>