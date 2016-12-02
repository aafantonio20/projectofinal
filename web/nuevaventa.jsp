<%-- 
    Document   : nuevoproducto
    Created on : 06/10/2016, 08:50:13 PM
    Author     : juancarlos
--%>

<%@page import="pe.edu.ulima.model.Personal"%>
<%@page import="java.util.List"%>
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
                                <li><a href="obtenerpedidos">Gestionar Pedidos</a></li>
                                <li><a href="vercartaactiva">Carta</a></li>                   
                            </ul>
                        </nav>
                    </header>
                </div>
                <div class="col-md-1 color-fondo-menu">

                </div>
            </div>

            <main>

                <div class="row">

                    <form method="POST" action="guardarproducto">


                        <div class="col-md-1">

                        </div>
                        <div class="col-md-10 color_fondo table-responsive">
                            <div class="row" style="margin-top: 30px;">
                                <div class="col-lg-12">

                                    <div class="row">
                                        <div class="col-lg-6">
                                            <p style="font-size: 16px; font-weight: 600; color: #e59201;">
                                                Nueva Venta:
                                            </p>
                                        </div>     
                                        <div class="col-lg-6" style="margin-top: 15px;">
                                            <a href="obtenersubproductos" style="color: #ffc831; font-size: 18px; ">AÑADIR PRODUCTO</a> <br>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6" style="margin-top: 20px;">
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Descripción:</label>
                                            <input type="text" class="form-control" id="usr" name="nombre" required="">
                                        </div>
                                        <div class="col-lg-6" style="margin-top: 20px;">
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Mozo:</label>
                                            <select class="form-control" id="sel1" name="categoria" required="">
                                                <% List<Personal> listaPersonal = (List<Personal>) request.getAttribute("listaPersonal"); %>

                                                <%
                                                    for (Personal listaPersona1 : listaPersonal) {
                                                %>
                                                <option value="<%=listaPersona1.getId_personal()%>"><%=listaPersona1.getNombres()%></option>   <% }
                                                %>                                       
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <table class="table table-condensed" style="color: white; margin-top: 40px;">
                                                <tr>
                                                    <td style="color: #e59201;"><strong>Descripción</strong></td>
                                                    <td style="color: #e59201;"><strong>Cantidad</strong></td>
                                                    <td style="color: #e59201;"><strong>P. Unit.</strong></td>
                                                    <td style="color: #e59201;"><strong>Total</strong></td>
                                                    <td><strong></strong></td>
                                                    <td><strong></strong></td>
                                                    <td><strong></strong></td>

                                                </tr>


                                                <%
                                                    for (Personal p1 : listaPersonal) {

                                                %>
                                                <tr>
                                                    <td><%=p1.getNombres()%></td>
                                                    <td><%=p1.getNombres()%></td>   
                                                    <td><%=p1.getNombres()%></td>          
                                                    <td><%=p1.getNombres()%></td> 
                                                    <td><a href="#" class="form-control" style="color: #ff3333; font-weight: bold; font-size: 13px; text-align: center">Modificar</a></td>
                                                    <td><a href="#" class="form-control" style="color: #ff3333; font-weight: bold; font-size: 13px; text-align: center">Eliminar</a></td>
                                                </tr>      <% }
                                                %>                             
                                            </table>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-lg-12">
                                            <input type="submit" class="btn btn-warning" value="Guardar producto"/>                                       
                                        </div>
                                        <div class="col-lg-12">
                                            <a href="obtenerproductos" style="color: #ffc831; font-size: 18px; ">REGRESAR</a> 
                                        </div>
                                    </div>
                                    <div class="row">
                                        <br>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1">

                        </div>
                    </form>
                </div>                
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
