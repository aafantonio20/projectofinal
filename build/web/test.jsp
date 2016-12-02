<%-- 
    Document   : test
    Created on : 01/12/2016, 10:21:17 PM
    Author     : juancarlos
--%>

<%@page import="java.util.List"%>
<%@page import="pe.edu.ulima.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select class="form-control" id="sel1" name="categoria" required="">
            <option></option>
            <% List<Producto> listaProductos = (List<Producto>) request.getAttribute("listaProductos"); %>

            <%
                for (Producto producto : listaProductos) {
            %>
            <option value="<%=producto.getId_producto()%>"><%=producto.getNombre()%></option>   <% }
            %>                                       
        </select>
        
    </body>
</html>
