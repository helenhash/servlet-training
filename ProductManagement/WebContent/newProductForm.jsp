<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/newProduct.css" />
<title>Add new Product</title>
</head>
<body>
	<div class="survey-page">
        <h1 id="title">Product Management</h1>
        <div id="form-container">
           <p id="description">
              Input product information to add or edit a product
           </p>
           <h2>
        	<a href="product">List All Products</a> &nbsp;&nbsp;&nbsp;
        	<a href="product?action=new">Add New Product</a>
	       </h2>
           <c:if test="${product != null}">
				<form action="product?action=update" method="post">
	        </c:if>
	        <c:if test="${product == null}">
				<form action="product?action=insert" method="post">
	        </c:if>
	        <c:if test="${product != null}">
       			<input type="hidden" name="id" class="input-field" value="<c:out value='${product.id}'/>"/> 
        	</c:if>
              <div class="formRow">
                 <label id="name-label" class="label-cls" for="name">* Name: </label>
                 <div class="input-col">
                    <input autofocus type="text" name="name" id="name" class="input-field" value="<c:out value='${product.name}'/>"
                    placeholder="Enter product name" required >  
                 </div>
              </div>
              <div class="formRow">
                 <label id="email-label" class="label-cls" for="email">* Description: </label>
                 <div class="input-col">
                    <input type="text" name="description" id="email" class="input-field" value="<c:out value='${product.description}'/>"
                    required placeholder="Enter description" >
                 </div>
              </div>
              <div class="formRow">
                 <label id="number-label" class="label-cls" for="age">* Price: </label>
                 <div class="input-col">
                    <input type="number" name="price" id="number"  class="input-field" value="<c:out value='${product.price}'/>"
                    placeholder="Enter product price" > 
                 </div>
              </div>
              
              <button id="submit" type="submit">Submit</button>
           </form>
        </div>
      </div>
     </div>
      
</body>
</html>