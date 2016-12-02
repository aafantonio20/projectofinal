<%-- 
    Document   : reservas
    Created on : 04/11/2016, 02:15:52 AM
    Author     : juancarlos
--%>

<%@page import="pe.edu.ulima.model.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acantilado de Barranco</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-color: #551213;">

        <div class="container">

            <div class="row">
                <div class="col-md-1">

                </div>
                <div class="col-md-10">
                    <div class="row" style="background-color: #600a0b;">
                        <div class="col-md-12" >
                            <img style="width: 100%; height: auto; margin-left: auto; margin-right: auto;" src="img/banner-logo.jpg" alt=""/>
                        </div>
                    </div>


                </div>
                <div class="col-md-1">

                </div>
            </div>
            <div class="row">
                <div class="col-md-1 color-fondo-menu">

                </div>
                <div class="col-md-10 color-fondo-menu">
                    <header>
                        <input type="checkbox" id="btn-menu" checked>
                        <label for="btn-menu"><img src="img/menu_icon.png" alt=""/></label>
                        <nav class="menu">
                            <ul>
                                <li><a href="bienvenido_mozo.html">Inicio</a></li>
                                <li><a href="visualizarcarta">Carta</a></li>
                                <li><a href="visualizarreservas">Reservas</a></li>
                            </ul>
                        </nav>
                    </header>
                </div>
                <div class="col-md-1 color-fondo-menu">

                </div>
            </div>


            <main>
                <form method="POST" action="mailapp">
                    <div class="row">
                        <div class="col-md-1">

                        </div>
                        <div class="col-md-10 color_fondo">

                            <div class="row" style="margin-top: 20px;">
                                <div class="col-md-6">
                                    <% Reserva reserva = (Reserva) request.getAttribute("reserva");%>
                                    <div class="row">            
                                        <div class="col-md-10">
                                            <p style="color: #e59201; padding: 0 20px 0 0; font-size: 18px; font-weight:400;">
                                                DATOS PERSONALES:
                                            </p>
                                            <label style="color: #9c917a">Nombres:</label>
                                            <input id='nombres' name="nombres" value="<%=reserva.getId_cliente().getNombre()%>" disabled="" required class="form-control">
                                            <label style="color: #9c917a">Apellidos:</label>
                                            <input id='apellidos' name="apellidos" value="<%=reserva.getId_cliente().getApellido()%>"disabled="" required class="form-control">
                                            <label style="color: #9c917a">Teléfono:</label>
                                            <input id='telefono' name="telefono" required value="<%=reserva.getId_cliente().getTelefono()%>" disabled="" class="form-control">
                                            <label style="color: #9c917a">Email:</label>
                                            <input type="email" id='email' name="email" value="<%=reserva.getId_cliente().getCorreo()%>" disabled="" required class="form-control">   
                                        </div>
                                        <div class="col-md-2"></div>
                                    </div>
                                </div>


                                <div class="col-md-6">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p style="color: #e59201; font-size: 18px; font-weight:400;">
                                                DATOS DE LA RESERVA:
                                            </p>
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Pax:</label>

                                            <input style="width: 80px;" required id='nombres' disabled="" name="pax" value="<%=reserva.getPax()%>" class="form-control">
                                        </div>
                                        <div class="col-md-12">

                                            <div class="row">
                                                <div class="col-md-4"> 
                                                    <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Día:</label>
                                                    <input type="text" class="form-control" id="usr" name="proveedor" value="<%=reserva.getDia()%>" disabled="">
                                                </div>
                                                <div class="col-md-4">
                                                    <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Mes:</label>
                                                    <input type="text" class="form-control" id="usr" name="proveedor" value="<%=reserva.getMes()%>" disabled="">
                                                </div>
                                                <div class="col-md-4">
                                                    <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Año:</label>
                                                    <input type="text" class="form-control" id="usr" name="proveedor" value="<%=reserva.getAno()%>" disabled="">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Hora:</label>

                                            <input style="width: 80px;" required id='nombres' disabled="" name="pax" value="<%=reserva.getHora()%>" class="form-control">
                                        </div>
                                    </div>


                                </div>
                            </div>
                            <div class="row" style="margin-top: 20px;">
                                <div class="col-md-6">
                                    <div class="row">            
                                        <div class="col-md-10">
                                            <p style="color: #e59201; padding: 0 20px 0 0; font-size: 18px; font-weight:400;">
                                                INGRESE SU MENSAJE:
                                            </p>
                                            <textarea class="form-control" disabled="" name="comentario"  rows="6"><%=reserva.getComentario()%></textarea>


                                        </div>
                                        <div class="col-md-2"></div>
                                    </div>
                                    
                                    <div class="row"><br>
                                        <div class="col-lg-12">

                                        </div>
                                        <div class="col-lg-12"><br>
                                            <a href="bienvenido_anfitrion.html" style="color: #ffc831; font-size: 18px; ">REGRESAR</a> 
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p style="color: #e59201; padding: 0 20px 0 0; font-size: 16px; font-weight:400;">
                                                HORARIO DE VERANO:
                                            </p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p style="margin: 0; color: #fff;">Lunes a Jueves:5 pm a 1 am</p>
                                            <p style="margin: 0; color: #fff;">Viernes y sábado: 5 pm a 3 am</p>       
                                            <p style="margin: 0; color: #fff;">Domingo: 3 pm a 12 pm</p>  
                                            <p style="margin: 0; color: #fff;">Teléfono: 247 - 2145</p>  
                                            <p style="margin: 0; color: #fff;">RPC: 994 069 559</p>  
                                            <p style="margin: 0; color: #fff;">Email: reservas@acantiladodebarranco.pe</p>  
                                            <p style="margin: 0; color: #e59201;">* Las reservas por este medio se realizan como mínimo con 24 horas de anticipación.</p>  
                                            <p style="margin: 0; color: #e59201;">* No hay reservaciones en feriados.</p>  
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">

                                <div class="col-md-12" style="margin-top: 20px;">
                                    <p style="color: #e59201; padding: 0 20px 0 0; text-align: justify;">
                                        Visítenos y relájese en el rincón más romántico de Barranco.
                                    </p>

                                </div>

                            </div>

                        </div>
                        <div class="col-md-1">

                        </div>
                    </div>
                </form>
            </main>
           <div class="row">
                <div class="col-md-1 col-sm-1 col-xs-1"></div>
                <div class="col-md-4 col-sm-5 col-xs-5">
                    <a href="inicio_sesion.jsp" style="color: #e59201; font-size: 16px; padding: 0 20px 0 20px; text-align: justify;">Cerrar Sesión</a> <br>
                </div>

                <div class="col-md-2 col-sm-1 col-xs-1"></div>
            </div>
        </div>


        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>

