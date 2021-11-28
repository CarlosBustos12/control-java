<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-11">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Solicitudes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Cliente</th>
                                <th>Categoria</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de Solicitudes -->
                            <c:forEach var="cliente" items="${clientes}" varStatus="status" >
                                <tr>
                                    <td>${cliente.idsolicitud_cliente}</td>
                                    <td>${cliente.nombre_empresa} </td>
                                    <td>${cliente.categoria} </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idsolicitud_cliente=${cliente.idsolicitud_cliente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            
        </div>
    </div>
</section>
<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>





