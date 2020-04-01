<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<div class="row">
	<form action="admin/perfil" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>Perfil Admin</legend>

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${usuario.id}" required tabindex="-1" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="text"
						class="form-control ${primeravez ? '' : (usuario.errorEmail == null ? 'is-valid' : 'is-invalid') }"
						id="email" name="email" value="${usuario.email}" required autofocus>
					<div class="invalid-feedback">${usuario.errorEmail}</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Antigua Contraseña</label>
				<div class="col-sm-10">
					<input type="password"
						class="form-control ${primeravez ? '' : (errorPassword == null ? 'is-valid' : 'is-invalid') }"
						id="password" name="password" required>
					<div class="invalid-feedback">${errorPassword}</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="newPass1" class="col-sm-2 col-form-label">Nueva Contraseña</label>
				<div class="col-sm-10">
					<input type="password"
						class="form-control ${(primeravez && errorNuevasPassword ==null) || errorNuevasPassword ==null ? '' : (errorNuevaPassword == null ? 'is-valid' : 'is-invalid') }"
						id="newPass1" name="newPass1">
					<div class="invalid-feedback">${errorNuevaPassword}</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="newPass2" class="col-sm-2 col-form-label">Repetir Nueva Contraseña</label>
				<div class="col-sm-10">
					<input type="password"
						class="form-control ${((primeravez && errorNuevasPassword ==null) || errorNuevasPassword ==null ) ? '' : (errorNuevaPassword   == null ? 'is-valid' : 'is-invalid') }"
						id="newPass2" name="newPass2">
					<div class="invalid-feedback">${errorNuevaPassword }</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="fechaAlta" class="col-sm-2 col-form-label">Fecha Alta</label>
				<div class="col-sm-10">
					<input type="date"
						class="form-control ${primeravez ? '' : (errorFechaAlta == null ? 'is-valid' : 'is-invalid') }"
						id="fechaAlta" name="fechaAlta"
						required value='<fmt:formatDate pattern="yyyy-MM-dd"
							value="${usuario.fechaAlta}" />' />
					<div class="invalid-feedback">${errorFechaAlta}</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a href="${pageContext.request.contextPath}/admin/index"
						role="button" class="btn btn-danger" required>Atras</a>
				</div>
			</div>
		</fieldset>
	</form>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
