<%-- 
    Document   : prueba
    Created on : 20/11/2016, 08:21:20 PM
    Author     : juancarlos
--%>

<%@page import="pe.edu.ulima.model.ObjetoDetalle"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.ulima.model.DetalleVenta"%>
<%@page import="pe.edu.ulima.model.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% Venta ventita = (Venta) request.getAttribute("venta"); %>
        <p>Mesa: <%=ventita.getMesa()%></p>
        <p>Mozo <%=ventita.getId_personal().getNombres()%></p>
        <p>Pax <%=ventita.getPax()%></p>
        <p>Monto: <%=ventita.getMontoPagar()%></p>
        
        
        <br>
        
        <% List<ObjetoDetalle> listaObjetos = (List<ObjetoDetalle>) request.getAttribute("listaObjetos"); %>

                                    <%
                                        for (ObjetoDetalle listita : listaObjetos) {

                                    %>
                                    <tr>
                                        <td><%=listita.getNombre()%></td>
                                        <td><%=listita.getCantidad() %></td>
                                        <td><%=listita.getPrecio()%></td>
                                        <td><%=listita.getPrecioT()%></td>
                                    </tr>      <% }
                                    %>          
    </body>
</html>
