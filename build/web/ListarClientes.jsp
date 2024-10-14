<%-- 
    Document   : ListarClientes
    Created on : 25 sept 2024, 1:36:20 p.m.
    Author     : user
--%>

<%@page import="sistematransporte.persistencia.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <header>
            <%@ include file="/partials/menu.jsp" %>
        </header>
        <main>
            <section class="crud">
                <%@ include file="/partials/menuCliente.jsp" %>
            </section>
            <section>
                <div class="hero-cliente">
                    <img src="imagen/img6.jpg" alt="fondo" class="imagenprincipal">
                    <div class="overlay-title-cliente">
                        <h1>Conviertete en <span>Cliente</span> para que <span>puedas</span> disfrutar de los <span>servicios</span></h1>
                    </div>
                    <div class="overlay-cliente">
                        <div class="formcliente">
                            <form action="Control" method="POST">
                                <input type="hidden" value="listar" id="formulario-cliente" name="formulario-cliente">
                                <p> Listar todos los clientes:</p>
                                <input type="submit" value="listar">
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            <%
                List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
                if (listaClientes != null && !listaClientes.isEmpty()) {
            %>
            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                </tr>
                <% for (Cliente cliente : listaClientes) {%>
                <tr>
                    <td><%= cliente.getNombre()%></td>
                    <td><%= cliente.getCorreo()%></td>
                    <td><%= cliente.getTelefono()%></td>
                </tr>
                <% } %>
            </table>
            <%
            } else {
            %>
            <p>No hay clientes registrados.</p>
            <%
                }
            %>
        </main>
        <%@ include file="/partials/footer.jsp" %>        
    </body>

</html>
