<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/view/product.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Product Management!!!!!
<form:form action="product.do" method="POST" commandName="product">

<table>
<tr>
<td>Pid</td>
<td><form:input path="pid"/></td>
</tr>
<tr>
<td>Pname</td>
<td><form:input path="pname"/></td>
</tr>
<tr>
<td>cost</td>
<td><form:input path="cost"/></td>
</tr>
<tr>
<td>Qty</td>
<td><form:input path="qty"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" name="action" value="add" >
<input type="submit" name="action" value="edit">
<input type="submit" name="action" value="delete">
<input type="submit" name="action" value="search">
</td>
</tr>
</table>
</form:form>
<br>
<table>
<th>ID</th>
<th>NAme</th>
<th>Cost</th>
<th>Qty</th>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.pid}</td>
<td>${product.pname}</td>
<td>${product.cost}</td>
<td>${product.qty}</td>
</tr>
</c:forEach>
</table>
</body>
</html>