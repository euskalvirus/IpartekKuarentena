<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="objeto" class="table-responsive col my-3">
	<h2>CURSOS</h2>
	<table width="100%" class="table table-striped table-bordered" id="dataTable">
		<thead class="tableTitles">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Número de horas</th>
				<th>Profesor</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="curso">
				<tr>
					<td>${curso.id}</td>
					<td>${curso.nombre}</td>
					<td>${curso.nHoras}</td>
					<td>${curso.profesor.nombre} ${curso.profesor.apellidos}</td>
					<td>
						<a class="btn btn-primary"
						href="admin/cursos?id=${curso.id}&op=vercitas">Ver Curso</a> 
						<a class="btn btn-warning"
						href="admin/cursos?id=${curso.id}&op=modificar">Modificar</a> 
						<a class="btn btn-danger my-1" data-id="${cliente.id}"
						data-href="admin/cursos" data-op="borrar"  data-toggle="modal" data-target="#modal">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-12 table-sm">
		<a class="btn btn-primary" href="admin/cursos?op=agregar">Añadir</a>
		<a href="${pageContext.request.contextPath}/"
						role="button" class="btn btn-danger">Atras</a>
	</div>
</section>

<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmación</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form class="formulario" method="post" action="">
          <div class="form-group">
            <label for="recipient-name" class="col-form-label titulo"></label>
            <input class="id" type="number" name="id" hidden>
            <input class="op" name="op" hidden>
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Introduzca su contraseña para confirmar:</label>
            <input type="password" class="form-control" id="password" name="password"></textarea>
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


<script> $('#modal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var recipient = button.data('whatever') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var id=button.data('id');
  var name=button.data('name');
  var op=button.data('op');
  var href = button.data('href');
  var modal = $(this)
  modal.find('.titulo').text('Desea eliminar el registro: ' + id + " " + name )
  modal.find('.id').text(id)
  $(".id").attr("value", id);
  modal.find('.op').text(op);
  $(".op").attr("value", op);
  $(".formulario").attr("action", href);
  //modal.find('.modal-body input').val(recipient)
}) </script>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
