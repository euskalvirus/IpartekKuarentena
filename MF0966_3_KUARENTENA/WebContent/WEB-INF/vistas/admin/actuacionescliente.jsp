<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="objeto" class="table-responsive col my-3">

	<form
		class="offset-xl-2 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-8">
		<h2 class="d-flex justify-content-center">CLIENTE</h2>
		<fieldset>
			<div class="form-group row border border-dark mt-2 pb-2 justify-content-around">
				<div class="col-3">
					<label for="nombre">Nombre</label>
					<div>
						<input class="form-control" id="nombre"
							value="${cliente.nombre}" disabled>
					</div>
				</div>
				<div class="col-5>">
					<label for="apellidos">Apellidos</label>
					<div>
						<input class="form-control" id="apellidos"
							value="${cliente.apellidos}" disabled>
					</div>
				</div>
				<div class="col-3">
					<label for="dni">DNI</label>
					<div>
						<input class="form-control" id="dni"
							value="${cliente.dni}" disabled>
					</div>
				</div>
			</div>
		</fieldset>
	</form>

	<div class="border border-dark mt-2 ">
		<h2 class="d-flex justify-content-center">CITAS</h2>
		<table class="table table-striped table-bordered" id="actuaciones">
			<thead class="tableTitles">
				<tr>
					<th>Cliente</th>
					<th>Servicio</th>
					<th>Empleado</th>
					<th>Fecha y Hora</th>
					<th>Reseña</th>
					<th>Calificación</th>
					<th>Opciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${actuaciones}" var="actuacion">
					<tr>
						<td>${actuacion.cliente.nombre}${actuacion.cliente.apellidos}</td>
						<td>${actuacion.servicio.nombre}</td>
						<td>${actuacion.trabajador.nombre}
							${actuacion.trabajador.nombre}</td>
						<td><fmt:formatDate value="${actuacion.fecha}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td class="resena">${actuacion.resenya}</td>
						<td>${actuacion.calificacion}</td>
						<td><a class="btn btn-warning"
							href="admin/actuaciones?idcliente=${actuacion.cliente.id}&idservicio=${actuacion.servicio.id}&idtrabajador=${actuacion.trabajador.id}&fecha=<fmt:formatDate value="${actuacion.fecha}" pattern="yyyy-MM-dd HH:mm:ss" />&op=modificar">Modificar</a>
							<a class="btn btn-danger my-1" data-id="${objeto.id}"
							data-name="${objeto.nombre}" data-href="admin/actuaciones"
							data-op="borrar" data-idcliente="${actuacion.cliente.id}"
							data-idservicio="${actuacion.servicio.id}"
							data-idtrabajador="${actuacion.trabajador.id}"
							data-fecha="<fmt:formatDate value="${actuacion.fecha}" pattern="yyyy-MM-dd HH:mm:ss"/>"
							data-toggle="modal" data-target="#modal">Borrar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-12 table-sm mt-1">
		<a class="btn btn-primary" href="admin/actuaciones?op=agregar">Añadir</a>
		<a href="${pageContext.request.contextPath}/admin/clientes"
			role="button" class="btn btn-danger">Atras</a>
	</div>
</section>

<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Confirmación</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form class="formulario" method="post" action="">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label titulo"></label>
						<input class="idcliente" type="number" name="idcliente" hidden>
						<input class="idservicio" type="number" name="idservicio" hidden>
						<input class="idtrabajador" type="number" name="idtrabajador"
							hidden> <input class="fecha" type="text" name="fecha"
							hidden> <input class="op" type="text" name="op" hidden>
					</div>
					<div class="form-group">
						<label for="message-text" class="col-form-label">Introduzca
							su contraseña para confirmar:</label> <input type="password"
							class="form-control" id="password" name="password">
						</textarea>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Confirmar</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>

					</div>
				</form>
			</div>

		</div>
	</div>
</div>


<script>
	$('#modal').on(
			'show.bs.modal',
			function(event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var recipient = button.data('whatever') // Extract info from data-* attributes
				// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				var idcliente = button.data('idcliente')
				var idservicio = button.data('idservicio')
				var idtrabajador = button.data('idtrabajador')
				var fecha = button.data('fecha')
				var href = button.data('href');
				var op = button.data('op');
				var modal = $(this)
				modal.find('.titulo').text(
						'Desea eliminar el registro: ' + idcliente + " "
								+ idservicio + " " + idservicio + " " + fecha
								+ " opcion: " + op)
				modal.find('.idcliente').text(idcliente)
				$(".idcliente").attr("value", idcliente);
				modal.find('.idservicio').text(idservicio)
				$(".idservicio").attr("value", idservicio);
				modal.find('.idtrabajador').text(idtrabajador)
				$(".idtrabajador").attr("value", idtrabajador);
				modal.find('.fecha').text(fecha)
				$(".fecha").attr("value", fecha);
				modal.find('.op').text(op)
				$(".op").attr("value", op);
				$(".formulario").attr("action", href);

				//modal.find('.modal-body input').val(recipient)
			})
</script>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
