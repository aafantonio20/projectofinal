<%-- 
    Document   : nuevoproducto
    Created on : 06/10/2016, 08:50:13 PM
    Author     : juancarlos
--%>

<%@page import="pe.edu.ulima.model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.ulima.model.Proveedor"%>
<%@page import="pe.edu.ulima.model.Categoria"%>
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
                                <li><a href="bienvenido.html">Inicio</a></li>
                                <li><a href="obtenerproductos">Gestionar Productos</a></li>
                                 
                            </ul>
                        </nav>
                    </header>
                </div>
                <div class="col-md-1 color-fondo-menu">

                </div>
            </div>

            <main>

                <div class="row">

                    <form method="POST" action="guardarpromocion">


                        <div class="col-md-1">

                        </div>
                        <div class="col-md-10 color_fondo table-responsive">
                            <div class="row" style="margin-top: 30px;">
                                <div class="col-lg-12">
                                    <% Producto producto = (Producto) request.getAttribute("producto");%>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <p style="font-size: 16px; font-weight: 600; color: #e59201;">
                                                Nueva promoción:
                                            </p>
                                        </div>        
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6" style="margin-top: 20px;">
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Nombre:</label>
                                            <input type="text" class="form-control" value="<%=producto.getNombre()%>" id="usr" name="nombre" disabled required="">
                                        </div>
                                        <div class="col-lg-6" style="margin-top: 20px;">
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Precio:</label>
                                            <input type="text" class="form-control" value="<%=producto.getPrecio()%>" id="usr" name="precio" disabled required="">
                                        </div>
                                    </div>
                                    
                                    <div class="row" style="margin-top: 20px;">
                                        
                                        <div class="col-lg-6">
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Incluye:</label>
                                            <textarea class="form-control" rows="5" id="comment" name="preparacion" disabled required><%=producto.getPreparacion()%></textarea>
                                        </div>    
                                        <div class="col-lg-6">
                                            <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Estado:</label>
                                            <input type="text" class="form-control" value="<%=producto.getEstado()%>" id="usr" name="precio" disabled required="">
                                        </div>
                                    </div><br>
                                                                       
                                    <div class="row">
                                        
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
