<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<header class="jumbotron align-items-center">
	<h2 class="display-6">MASAJES "EL CIELO"</h2>
</header>

<section id="objetos" class="row justify-content-around text-center">
<div id="botones" class="col-8 justify-content-between">
	<a href="admin/actuaciones" class="btn btn-secondary btn-lg btn-block"><i class="icon-ok">CITAS</i></a>
	<hr class="my-4">
	<a href="admin/clientes" class="btn btn-secondary btn-lg btn-block"><i class="icon-ok">CLIENTES</i></a>
	<hr class="my-4">
	<a href="admin/trabajadores" class="btn btn-secondary btn-lg btn-block"><i class="icon-ok">EMPLEADOS</i></a>
	<hr class="my-4">
	<a href="admin/servicios" class="btn btn-secondary btn-lg btn-block"><i class="icon-ok">SERVICIOS</i></a>
</div>
</section>

<a id="top" href="#" type="button"  class="btn btn-primary">TOP</a>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
