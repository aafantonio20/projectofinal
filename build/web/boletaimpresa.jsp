<%-- 
    Document   : boletaimpresa
    Created on : 02/12/2016, 04:44:32 AM
    Author     : juancarlos
--%>

<%@page import="pe.edu.ulima.model.ObjetoSolo"%>
<%@page import="pe.edu.ulima.model.ObjetoDetalle"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.ulima.model.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>.:Acantilado de Barranco</title>
    </head>
    <body>
        <div class="container">
            <div class="row" style="margin-top: 30px;">
                <div class="col-lg-4">

                </div>
                <div class="col-lg-4">
                    <img class="img-responsive" style="margin-left: auto;margin-right: auto;" src="img/logo-acantiado.png" alt=""/>
                </div>
                <div class="col-lg-4">

                </div>
            </div>
            <div class="row" style="margin-top: 24px;">
                <div class="col-lg-4">

                </div>
                <div class="col-lg-4">
                    <% Venta ventita = (Venta) request.getAttribute("venta");%> 
                    <div class="col-lg-3" style="margin-top: 15px;">

                    </div>
                    <p style="font-size: 25px; font-weight: 600; text-align: justify;">
                        BOLETA DE VENTA
                    </p>
                </div>
                <div class="col-lg-4">

                </div>
            </div><br>
            <div class="row">
                <div class="col-lg-12">
                    <p style="font-weight: bold;">
                        RAZON SOCIAL: ACANTILADO DE BARRANCO SAC
                    </p>
                    <p style="font-weight: bold;"> 
                        RUC: 20509060941
                    </p>
                    <p style="font-weight: bold;">
                        DIRECCIÓN: CALLE LA ERMITA 102, BARRANCO.
                    </p><br>    
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <table class="table table-condensed" style="color: white; margin-top: 40px;">
                        <tr>
                            <td style="color: #e59201;"><strong>Descripción</strong></td>
                            <td style="color: #e59201;"><strong>Cantidad</strong></td>
                            <td style="color: #e59201;"><strong>Cst. Unit</strong></td>
                            <td style="color: #e59201;"><strong>PrecioTotal</strong></td>
                            <td><strong></strong></td>

                        </tr>
                        <% List<ObjetoDetalle> listaObjetos = (List<ObjetoDetalle>) request.getAttribute("listaObjetos"); %>

                        <%
                            for (ObjetoDetalle listita : listaObjetos) {

                        %>
                        <tr>
                            <td style="color: black;"><%=listita.getNombre()%></td>
                            <td style="color: black;"><%=listita.getCantidad()%></td>
                            <td style="color: black;"><%=listita.getPrecio()%></td>
                            <td style="color: black;"><%=listita.getPrecioT()%></td> 

                        </tr>      <% }
                        %>   
                        <% List<ObjetoSolo> listaObjetos2 = (List<ObjetoSolo>) request.getAttribute("listaObjetosSolo"); %>

                        <%
                            for (ObjetoSolo listita : listaObjetos2) {

                        %>
                        <tr>

                            <td> <p style="font-size: 16px; font-weight: 600; color: #e59201; margin-top: 20px;">
                                    MONTO: <p style="color: black; font-size: 16px;"><%=listita.getMonto()%></p>
                                </p></td>

                        </tr>      <% }
                        %>       
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
