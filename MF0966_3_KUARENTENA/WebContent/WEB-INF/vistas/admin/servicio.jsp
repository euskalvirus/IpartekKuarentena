<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/servicios" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<c:choose>
			<c:when test="${op=='modificar'}">
				<h2>MODIFICACIÓN SERVICIO</h2>
			</c:when>
			<c:otherwise>
				<h2>NUEVO SERVICIO</h2>
			</c:otherwise>
		</c:choose>

		<fieldset>
			<legend></legend>

			<input type="hidden" id="op" name="op" value="${op}">
			<c:choose>
				<c:when test="${op=='modificar'}">
					<div class="form-group row">
						<label for="id" class="col-sm-2 col-form-label">Id</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="id" name="id"
								value="${servicio.id}" required tabindex="-1" readonly>
						</div>
					</div>
				</c:when>
			</c:choose>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (servicio.errorNombre == null ? 'is-valid' : 'is-invalid') }"
						id="nombre" name="nombre" value="${servicio.nombre}" required
						autofocus>
					<div class="invalid-feedback">${servicio.errorNombre}</div>
				</div>
			</div>
			<c:choose>
				<c:when test="${op=='agregar'}">
					<div class="form-group row">
						<div class="col-sm-2">Niveles</div>
						<div class="col-sm-10">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="true"
									name="niveles" id="niveles"> <label
									class="form-check-label" for="gridCheck1"> Tiene mas de
									1 nivel. </label>
							</div>
						</div>
					</div>
					<div class="form-group row niveles justify-content-center"
						style="display: none;">

						<div class="col-3">
							<label for="nombre" class="col-sm-2 col-form-label">Inicio</label>
							<input type="number" min="1" value="1" class="form-control"
								id="nivelinicio" name="nivelinicio">
						</div>
						<div class="col-3">
							<label for="nombre" class="col-sm-2 col-form-label">Final</label>
							<input type="number" min="2" value="2" class="form-control"
								id="nivelfinal" name="nivelfinal">
						</div>
					</div>
				</c:when>
			</c:choose>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Precio</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (servicio.errorPrecio == null ? 'is-valid' : 'is-invalid') }"
						id="precio" name="precio" value="${servicio.precio}" required>
					<div class="invalid-feedback">${servicio.errorPrecio}</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a href="${pageContext.request.contextPath}/admin/servicios"
						role="button" class="btn btn-danger">Atras</a>
				</div>
			</div>
		</fieldset>
	</form>
</div>

<script>
	$(document).ready(function() {
		$('input[type="checkbox"]').click(function() {
			$(".niveles").toggle();
			if (document.getElementById("nivelinicio").required == "") {
				document.getElementById("nivelinicio").required = true;
				document.getElementById("nivelfinal").required = true;
			} else {
				document.getElementById("nivelinicio").required = false;
				document.getElementById("nivelfinal").required = false;
			}

		});
	});
</script>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
