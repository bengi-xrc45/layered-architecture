<%-- 
    Document   : FormCliente
    Created on : 17 sept 2024, 6:39:30 a.m.
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formularios</title>
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
                                <input type="hidden" id="formulario-cliente" name="formulario-cliente" value="registrar">
                                <p> Llenar los siguientes campos para el registro del cliente:</p>
                                <% String mensaje = (String) request.getAttribute("mensaje");
                                    if (mensaje != null) {
                                %> 
                                <p class="mensaje"><%=mensaje%></p>
                                <%
                                    }
                                %> 
                                <input type="text" name="nombre" placeholder="Ingrese su nombre completo " required> <br>
                                <input type="email" name="correo" placeholder="Ingrese correo electronico" required> <br>
                                <input type="text" name="telefono" placeholder="Ingrese telefono" required> <br>
                                <input type="submit" value="Enviar">
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <%@ include file="/partials/footer.jsp" %>
    </body>
</html>
