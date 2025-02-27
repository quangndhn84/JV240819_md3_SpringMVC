<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 23/12/2024
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/bookController/update" method="post">
    <label for="bookId">Book Id</label>
    <input type="text" id="bookId" name="bookId" value="${book.bookId}" readonly/><br>
    <label for="bookName">Book Name</label>
    <input type="text" id="bookName" name="bookName" value="${book.bookName}"/><br>
    <label for="price">Price</label>
    <input type="number" id="price" name="price" value="${book.price}"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" ${book.status?'checked':''}/><label
        for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false" ${book.status?'':'checked'}/><label for="inActive">Inactive</label><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
