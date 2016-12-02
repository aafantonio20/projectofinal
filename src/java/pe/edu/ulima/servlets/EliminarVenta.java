
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
import pe.edu.ulima.model.GestionDAO;
import pe.edu.ulima.model.Producto;

public class EliminarVenta extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestionDAO gestion = new GestionDAO();
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));

        gestion.eliminarProductoSegunID(idVenta);
        
        List<Producto> productos = new GestionDAO().obtenerProductos();
        List<Categoria> categorias = new GestionDAO().obtenerCategorias();
        
        RequestDispatcher rd = request.getRequestDispatcher("binvenido.html");       
        request.setAttribute("listaProductos", productos);
        request.setAttribute("listaCategorias", categorias);
        rd.forward(request, response);
        
    }

    
}
