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
import pe.edu.ulima.model.Proveedor;

public class ModificarProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestionDAO gestion = new GestionDAO();
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto productito = gestion.obtenerProductoSegunID(idProducto);
        Categoria cat = productito.getId_categoria();

        List<Categoria> categorias = gestion.obtenerCategorias();
        List<Proveedor> proveedores = gestion.obtenerProveedores();
        if (cat.getId_categoria() == 3) {
            RequestDispatcher rd = request.getRequestDispatcher("modificarpromocion.jsp");
            request.setAttribute("producto", productito);
            rd.forward(request, response);
        } else{
            RequestDispatcher rd = request.getRequestDispatcher("modificarproducto.jsp");
            request.setAttribute("producto", productito);
            request.setAttribute("categorias", categorias);
            request.setAttribute("proveedores", proveedores);
            rd.forward(request, response);
        }

    }

}
