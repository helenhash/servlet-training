<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add new Product</h1>
    <div align="center">
		<c:if test="${product != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${product == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${product != null}">
            			Edit product
            		</c:if>
            		<c:if test="${product == null}">
            			Add New product
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${product != null}">
        			<input type="hidden" name="id" value="<c:out value='${product.id}' />" />
        		</c:if>            
            <tr>
                <th>Title: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${product.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Author: </th>
                <td>
                	<input type="text" name="description" size="45"
                			value="<c:out value='${product.description}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${product.price}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>