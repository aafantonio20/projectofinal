
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
import pe.edu.ulima.model.Personal;
import pe.edu.ulima.model.Producto;

public class NuevoPedido extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Producto> productos = new GestionDAO().obtenerProductos();
        List<Personal> personales = new GestionDAO().obtenerPersonal();
        

        RequestDispatcher rd = request.getRequestDispatcher("nuevopedido.jsp");
        
        request.setAttribute("listaProductos", productos);
        request.setAttribute("personales", personales);
        rd.forward(request, response);
        
    }

}
