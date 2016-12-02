package pe.edu.ulima.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.model.Categoria;
import pe.edu.ulima.model.Cliente;
import pe.edu.ulima.model.GestionDAO;
import pe.edu.ulima.model.Producto;
import pe.edu.ulima.model.Proveedor;
import pe.edu.ulima.model.Reserva;

public class GrabarReservaModificada extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        GestionDAO gestion = new GestionDAO();
        int id_producto=Integer.parseInt(request.getParameter("id_producto"));
        String nombre = request.getParameter("nombre");
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        float precio=Float.parseFloat(request.getParameter("precio"));
        int idProveedor = Integer.parseInt(request.getParameter("proveedor"));
        String estado = request.getParameter("estado");
        String preparacion = request.getParameter("preparacion");
        
        Categoria categoria1 = gestion.obtenerCategoriaSegunID(idCategoria);
        Proveedor proveedor1 = gestion.obtenerProveedorSegunID(idProveedor);
                
        Producto producto = new Producto(id_producto, categoria1, proveedor1, nombre, precio, estado, preparacion);
        gestion.modificarProducto(producto);
         */
        GestionDAO gestion = new GestionDAO();
        int idReserva = Integer.parseInt(request.getParameter("idReserva"));
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        int telefono = Integer.parseInt(request.getParameter("telefono"));

        Cliente cliente = new Cliente(idCliente, nombre, apellido, telefono, correo);
        //Falta poner el idcliente-->Merge
        gestion.modificarCliente(cliente);

        String comentario = request.getParameter("comentario");
        int pax = Integer.parseInt(request.getParameter("pax"));
        int dia = Integer.parseInt(request.getParameter("dia"));
        String mes = request.getParameter("mes");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String hora = request.getParameter("hora");

        Reserva serv = new Reserva(idReserva, cliente, comentario, pax, dia, mes, ano, hora);
        gestion.modificarReserva(serv);
        List<Reserva> listaReservas = new GestionDAO().obtenerReservas();
        RequestDispatcher rd = request.getRequestDispatcher("reservamodificada.jsp");
        request.setAttribute("listaReservas", listaReservas);
        rd.forward(request, response);

    }

}
