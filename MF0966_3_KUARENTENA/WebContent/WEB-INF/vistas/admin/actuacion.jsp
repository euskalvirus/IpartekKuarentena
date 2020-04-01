<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/actuaciones" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<h2> MODIFICACIÓN CITA</h2>
		<fieldset>
			<legend></legend>

			<input type="hidden" id="op" name="op" value="${op}">
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Cliente</label>
				<div class="col-sm-10">
					<select class="form-control" name="idcliente" id="idcliente"
						required>
						<c:choose>
							<c:when test="${op=='modificar'}">
								<option value="${actuacion.cliente.id}">${actuacion.cliente.nombre}
									${actuacion.cliente.apellidos}</option>
							</c:when>
							<c:otherwise>
								<option value="" disabled selected> -- Elige una opción --</option>
							</c:otherwise>
						</c:choose>
						<c:forEach items="${clientes}" var="cliente">
							<c:if test="${cliente.id != actuacion.cliente.id }">
								<option value="${cliente.id}">${cliente.nombre}
									${cliente.apellidos}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Servicio</label>
				<div class="col-sm-10">
					<select class="form-control" name="idservicio" id="idservicio"
						required>
						<c:choose>
							<c:when test="${op=='modificar'}">
								<option value="${actuacion.servicio.id}">${actuacion.servicio.nombre}</option>
							</c:when>
							<c:otherwise>
								<option value="" disabled selected> -- Elige una opción --</option>
							</c:otherwise>
						</c:choose>
						<c:forEach items="${servicios}" var="servicio">
							<c:if test="${servicio.id != actuacion.servicio.id }">
								<option value="${servicio.id}">${servicio.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Trabajador</label>
				<div class="col-sm-10">
					<select class="form-control" name="idtrabajador" id="idtrabajador"
						required>
						<c:choose>
							<c:when test="${op=='modificar'}">
								<option value="${actuacion.trabajador.id}">${actuacion.trabajador.nombre}</option>
							</c:when>
							<c:otherwise>
								<option value="" disabled selected> -- Elige una opción --</option>
							</c:otherwise>
						</c:choose>
						<c:forEach items="${trabajadores}" var="trabajador">
							<c:if test="${trabajador.id != actuacion.trabajador.id }">
								<option value="${trabajador.id}">${trabajador.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Fecha</label>
				<div class="col-sm-10">
					<input type="datetime-local" class="form-control" id="fecha"
						name="fecha"
						value="<fmt:formatDate value="${actuacion.fecha}" pattern="yyyy-MM-dd'T'HH:mm" />"
						hidden="hidden"> 
					<input type="datetime-local" class="form-control"
						id="fechanueva" name="fechanueva"
						value="<fmt:formatDate value="${actuacion.fecha}" pattern="yyyy-MM-dd'T'HH:mm:ss" />"
						required>
				</div>
			</div>
			<div class="form-group row">
				<label for="url" class="col-sm-2 col-form-label">Reseña</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="resenya" name="resenya">${actuacion.resenya}</textarea>
				</div>
			</div>
			<div class="form-group row">
				<label for="calificacion" class="col-sm-2 col-form-label">Calificación</label>
				<div class="col-sm-10">
				<select class="form-control" name="calificacion" id="calificacion">
					<option value="" selected></option>
					<option value="Aceptable">Aceptable</option>
					<option value="Para repetir">Para repetir</option>
					<option value="No recomendable">No recomendable</option>
				</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a href="${pageContext.request.contextPath}/admin/actuaciones"
						role="button" class="btn btn-danger">Atras</a>
				</div>
			</div>

		</fieldset>
	</form>
</div>

<script>
	var opCal = "${actuacion.calificacion}";
	switch (opCal) {
	case "Aceptable":
		$("#calificacion option[value='Aceptable']").attr("selected", true);
		break;
	case "Para repetir":
		$("#calificacion option[value='Para repetir']").attr("selected", true);
		break;
	case "No recomendable":
		$("#calificacion option[value='No recomendable']").attr("selected", true);
		break;
	default:
		$("#calificacion option[value='']").attr("selected", true);
		break;
	}
</script>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
