<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<div class="row">
	<form action="signin" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>Registro</legend>

			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control ${primeravez ? '' : (user.errorEmail == null ? 'is-valid' : 'is-invalid') }" id="email" name="email"
						value="${email}" autofocus required>
					<div class="invalid-feedback">${user.errorEmail}</div>
				</div>

			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
				<div class="col-sm-10">
					<input type="password" class="form-control ${primeravez ? '' : (user.errorPassword == null ? '' : 'is-invalid') }" id="password" name="password" required>
					<div class="invalid-feedback">${user.errorPassword}</div>
				</div>
				

			</div>
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
				</div>
			</div>
		</fieldset>
	</form>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>