<%-- 
    Document   : gestionproductos
    Created on : 07/10/2016, 12:02:11 AM
    Author     : juancarlos
--%>

<%@page import="pe.edu.ulima.model.Personal"%>
<%@page import="pe.edu.ulima.model.Producto"%>
<%@page import="pe.edu.ulima.model.Venta"%>
<%@page import="java.util.List"%>
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
        <script src="table.js" type="text/javascript"></script>
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
                    <form method="POST" action="guardarpedido">
                        <div class="col-md-1">

                        </div>
                        <div class="col-md-10 color_fondo table-responsive">

                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <p style="font-size: 16px; font-weight: 600;margin-top: 20px; color: #e59201;">
                                        Nuevo pedido:
                                    </p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-4" style="margin-top: 20px;">
                                    <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Mesa:</label>
                                    <input type="text" class="form-control" id="usr" name="mesa" required="">
                                </div>
                                <div class="col-lg-4" style="margin-top: 20px;">
                                    <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Mozo:</label>
                                    <select class="form-control" id="sel1" name="idPersonal" required="">
                                                <option></option>
                                                <% List<Personal> listaPersonales = (List<Personal>) request.getAttribute("personales"); %>

                                                <%
                                                    for (Personal personal : listaPersonales) {
                                                %>
                                                <option value="<%=personal.getId_personal()%>"><%=personal.getNombres()%></option>   <% }
                                                %>                                       
                                            </select>
                                </div>
                                <div class="col-lg-4" style="margin-top: 20px;">
                                    <label for="usr" style="font-size: 14px; font-weight: 600; color: #e59201;">Pax:</label>
                                    <input type="number" class="form-control" id="usr" name="pax" required="">
                                </div>
                            </div>
                            <div class="row"><br>                                

                                <div class="col-lg-12">
                                    <p style="color: #e59201; padding: 0 20px 0 0; font-size: 18px; font-weight:400;">
                                        AÑADIR PRODUCTO:
                                    </p>

                                    <button class='btn btn-danger' onclick="myCreateFunction()">Agregar</button>
                                    <!--<input type="submit" class="btn btn-danger" value="Agregar"/><br><br>-->
                                </div>

                            </div>
                            <div class="row">
                                <% List<Producto> listaProductos = (List<Producto>) request.getAttribute("listaProductos"); %>
                                <div class="col-lg-12">
                                    <table class="table table-condensed" id="myTable" style="color: white; margin-top: 40px;">
                                        <tr>
                                            <td>
                                                <select class='form-control' required='' name='productito'> <option></option> <% for (Producto producto : listaProductos) {%> <option value='<%=producto.getId_producto()%>'><%=producto.getNombre()%></option>   <% }%> </select>
                                            </td>
                                            <td>
                                                <input type='number' class='form-control' name='cantidad' required=''>
                                            </td>
                                            
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <input type="submit" class="btn btn-warning" value="Guardar pedido"/>                                       
                                </div>

                            </div><br>
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

        <script>
            function myCreateFunction() {
                var table = document.getElementById("myTable");
                var row = table.insertRow(0);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                cell1.innerHTML = "<select class='form-control' required='' name='productito'> <option></option> <% for (Producto producto : listaProductos) {%> <option value='<%=producto.getId_producto()%>'><%=producto.getNombre()%></option>   <% }%> </select>";
                cell2.innerHTML = "<input type='text' class='form-control' name='cantidad' required=''>";
            }

            function myDeleteFunction() {
                document.getElementById("myTable").deleteRow(0);
            }
        </script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
