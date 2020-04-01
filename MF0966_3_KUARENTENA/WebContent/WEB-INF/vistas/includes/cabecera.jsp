<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Mf0966_3</title>

<base href="${pageContext.request.contextPath}/" />

<!-- Bootstrap 4 -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- DataTables con aspecto Bootstrap 4 -->
<link rel="stylesheet" href="css/dataTables.bootstrap4.min.css" />
<!-- Font Awesome -->
<link rel="stylesheet" href="css/all.min.css" />
<link href="css/dataTables.responsive.css" rel="stylesheet" />

<link rel="stylesheet" href="css/mf0966_3.css" />

<!-- jQuery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>
  <script src="js/dataTables.responsive.js"></script>

<script>
$(document).ready(function() {
    $('#dataTable').DataTable({
    	responsive: true
    });
    
    $('#actuaciones').DataTable({
    	responsive: true,
    	 order: [[ 3, "asc" ]]
    });
});
</script>

</head>
<body>
	<header>
		<h1>MF0966_3 Cuarentena</h1>
	</header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<a class="navbar-brand" href="">Menu Principal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto"><!-- ${sessionScope.email!=null ?
			'<li class="nav-item"><a class="nav-link" href="admin/index">Administración</a></li>
			' : "" }-->
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>

			<c:choose>
				<c:when test="${sessionScope.email != null}">
				 <ul class="navbar-nav navbar-dark bg-dark">
				 <li class="nav-item dropdown navbar-dark bg-dark">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">${sessionScope.email} </a>
					<div class="dropdown-menu  nav-item navbar-dark bg-dark" aria-labelledby="navbarDropdown">
						<a class="dropdown-item nav-link navbar-dark bg-dark" href="admin/perfil">Editar Perfil</a> <a
							class="dropdown-item nav-link disabled" href="#">Another action</a>
						<div class="dropdown-divider k"></div>
						<a class="dropdown-item nav-link navbar-dark bg-dark " href="logout">Logout</a>
					</div>
					</li>
					</ul>
					
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="signin">Sign
								in</a></li>
						<li class="nav-item"><a class="nav-link" href="login">Login</a>
						</li>
					</ul>
				</c:otherwise>
			</c:choose>

		</div>
	</nav>
	<c:if test="${alertatexto != null}">
		<div class="alert alert-${alertanivel} alert-dismissible fade show"
			role="alert">
			${alertatexto}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<%
			session.removeAttribute("alertatexto");
				session.removeAttribute("alertanivel");
		%>
	</c:if>
	<main class="container-fluid">