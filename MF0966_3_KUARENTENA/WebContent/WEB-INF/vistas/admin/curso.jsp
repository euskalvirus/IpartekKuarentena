<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/cursos" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<h2> MODIFICACIÓN CLIENTE</h2>
		<fieldset>
			<legend></legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${curso.id}" required tabindex="-1" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input
						class="form-control"
						id="nombre" name="nombre" value="${curso.nombre}" required autofocus>
				</div>

			</div>
			<div class="form-group row">
				<label for="nHoras" class="col-sm-2 col-form-label">Numero de horas</label>
				<div class="col-sm-10">
					<input
						class="form-control"
						id="nHoras" name="nHoras" value="${curso.nHoras}" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="profesor" class="col-sm-2 col-form-label">Profesor</label>
				<div class="col-sm-10">
					<input
						class="form-control"
						id="profesor" name="profesor" value="${curso.profesor.nombre} ${curso.profesor.apellidos}" required>
				</div>
			</div>
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a href="${pageContext.request.contextPath}/admin/cursos"
						role="button" class="btn btn-danger">Atras</a>
				</div>
			</div>
		</fieldset>
	</form>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
