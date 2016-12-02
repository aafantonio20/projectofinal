
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

public class GuardarPromocion extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         GestionDAO gestion = new GestionDAO();
        
        String nombre = request.getParameter("nombre");
        float precio=Float.parseFloat(request.getParameter("precio"));
        String preparacion = request.getParameter("preparacion");
        String estado = request.getParameter("estado");
        int idCategoria = 3;
        int idProveedor=1;
        
 
        Categoria categoria1 = gestion.obtenerCategoriaSegunID(idCategoria);
        Proveedor proveedor1 = gestion.obtenerProveedorSegunID(idProveedor);
                
        //Producto producto = new Producto(id_producto, categoria1, proveedor1, nombre, precio, estado, preparacion);
        Producto productito = new Producto();
        
        productito.setId_categoria(categoria1);        
        productito.setId_proveedor(proveedor1);
        productito.setNombre(nombre);
        productito.setPrecio(precio);
        productito.setEstado(estado);
        productito.setPreparacion(preparacion);
        
        gestion.registrarProducto(productito);
        

        //Este servlet envía los datos a "cartelera.jsp"
        response.sendRedirect("obtenerproductos");
        
    }

}
