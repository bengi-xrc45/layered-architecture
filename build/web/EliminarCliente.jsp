<%-- 
    Document   : EliminarCliente
    Created on : 26 sept 2024, 7:22:17 a.m.
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar cliente</title>
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
                            <form action="Control" method="post">
                                <input type="hidden" name="formulario-cliente" value="eliminar">
                                <label for="telefono">Eliminar cliente por telefono:</label>
                                <input type="text" id="telefono" name="telefono" required placeholder="Ingrese Teléfono " >
                                <input type="submit" value="Eliminar">
                                <%
                                    String mensaje = (String) request.getAttribute("mensaje");
                                    if (mensaje != null) {
                                %>
                                <p class="mensaje"><%= mensaje%></p>
                                <%
                                } 
                                %>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <%@ include file="/partials/footer.jsp" %>
    </body>
</html>
