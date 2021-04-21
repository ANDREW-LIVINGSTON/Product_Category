<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.rtl.min.css" integrity="sha384-trxYGD5BY4TyBTvU5H23FalSCYwpLA0vWEvXXGm5eytyztxb+97WzzY+IWDOSbav" crossorigin="anonymous">
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<br>
	<br>
	<h2>Categories:</h2>
	<c:forEach items="${product.categories}" var="category">
		<p><c:out value="${category.name}"/></p>
	</c:forEach>
	
	<form action="/products/addCategory" method="post">
		<input type="hidden" value="${product.id}" name="product_id">
		
		<select name="category_id">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">
				<c:out value="${category.name}"></c:out>
			
			</c:forEach>
		</select>
		<input type="submit" value="Add Category">
		</form>
	

</body>
</html>