<%-- 
    Document   : Inicio
    Created on : 19 sept 2024, 1:00:02 p.m.
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incio</title>
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <header>
            <%@ include file="/partials/menu.jsp" %>
            <div class="hero">
                <img src="imagen/img5.jpg" alt="fondo" class="imagenprincipal">
                <div class="overlay">
                    <h1>Una forma mas comoda y segura de <span>Viajar</span> por el <span>pais</span></h1>
                    <div class="hero-botones">
                        <a href="#"><i class="fa-brands fa-google-play"></i> <i class="fa-brands fa-app-store-ios"></i>
                            Descargar APP</a>
                        <a href="#"><i class="fa-solid fa-location-dot"></i> Viajar</a>
                    </div>
                </div>
            </div>
        </header>
        <main>
            <section class="card-servicios-container">
                <div class="title-cards-section">
                    <h2>Servicios que Ofrecemos</h2>
                </div>
                <div class="cards-section">
                    <div class="card">
                        <img src="imagen/img8.jpg" alt="ciudad" class="card-img">
                        <div class="card-content">
                            <h3>Ciudad</h3>
                            <p>Viaja a cualquier localizacion en la ciudad donde estes</p>
                            <p>Busque ofertas de transporte en una franja o alguna hora estipulada</p>
                            <div class="card-mini-item">
                                <p>Clientes</p>
                                <p>Conductores</p>
                                <p>Servicio</p>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <img src="imagen/img7.jpeg" alt="ciudad a ciudad" class="card-img">
                        <div class="card-content">
                            <h3>Ciudad a Ciudad</h3>
                            <p>Viaja a cualquier ciudad a nivel nacional del pais</p>
                            <p>Busque ofertas de transporte en una franja o alguna hora estipulada</p>
                            <div class="card-mini-item">
                                <p>Clientes</p>
                                <p>Conductores</p>
                                <p>Servicio</p>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <img src="imagen/img9.jpg" alt="empresas" class="card-img">
                        <div class="card-content">
                            <h3>Personas o Empresas</h3>
                            <p>El servicio puede ser realizado por usuarios o empresas calificados</p>
                            <p>El valor lo pone la entidad que presta el servicio</p>
                            <div class="card-mini-item">
                                <p>Conductores</p>
                                <p>Empresas</p>
                                <p>Negocio</p>
                                <p>Servicio</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="card-seguridad-container">
                <div class="title-card-seguridad">
                    <h2>Seguridad en el camino </h4>
                        <p>Sientete seguro y tranquilo tomando el servicio para donde quieras que vayas</p>
                </div>
                <div class="cards-seguridad">
                    <div class="card-seguridad">
                        <div class="card-seguridad-content">
                            <i class="fa-solid fa-shield"></i>
                            <h5>Diferentes metodos de seguridad</h5>
                            <p>Tus seres queridos pueden saber donde estas. Ayuda con presionar un boton. GPS especial.
                                Tecnologia avanzada en seguridad</p>
                        </div>
                    </div>
                    <div class="card-seguridad">
                        <div class="card-seguidad">
                            <div class="card-seguridad-content">
                                <i class="fa-solid fa-id-card"></i>
                                <h5>Diferentes metodos de seguridad</h5>
                                <p>Todo esta documentando y en constante revision de la informacion de quienes prestan el
                                    servicio antes personas o empresas</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-seguridad">
                        <div class="card-seguridad-content">
                            <i class="fa-solid fa-message"></i>
                            <h5>Si tienes problemas o necesitas ayuda</h5>
                            <p>Te puedes contactar con nuestra asistencia en emergencias, SITRAVI esta diselado para ti</p>
                        </div>
                    </div>
                </div>
            </section>
            <section class="visual-conductor-section">
                <div class="hero-visual-conductor">
                    <img src="imagen/mg2.webp" alt="fondo" class="imagen-hero-visual">
                    <div class="overlay-2">
                        <h2>Comienza en el lado del <span>conductor </span>para <span>prestar</span> nuestros servicios</h2>
                        <a href="#"><i class="fa-solid fa-car"></i> Modo conductor</a>
                    </div>

                </div>
            </section>
        </main>
        <%@ include file="/partials/footer.jsp" %>
    </body>
</html>

