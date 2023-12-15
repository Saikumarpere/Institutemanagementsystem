<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.techpalle.model.Student" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped">
        <thead>
        <th>SNO</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Mobile</th>
        <th>Actions</th>
        </thead>
        <tbody>
        <a:forEach items="${students}" var="s">
        <tr>
        <td><a:out value="${s.sno}"></a:out></td>
        <td><a:out value="${s.name}"></a:out></td>
        <td><a:out value="${s.email}"></a:out></td>
        <td><a:out value="${s.password}"></a:out></td>
         <td><a:out value="${s.mobile}"></a:out></td>
  
        <td><a href="editstudent/${student.sno}">Edit</a></td>  
   <td><a href="deletestudent/${student.sno}">Delete</a></td>  
        </td>
        </tr>
        </a:forEach>
        </tbody>
        </table>

</body>
</html>