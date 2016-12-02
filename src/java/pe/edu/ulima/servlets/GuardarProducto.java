
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


public class GuardarProducto extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        GestionDAO gestion = new GestionDAO();
        
        String nombre = request.getParameter("nombre");
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        float precio=Float.parseFloat(request.getParameter("precio"));
        int idProveedor = Integer.parseInt(request.getParameter("proveedor"));
        String estado = request.getParameter("estado");
        String preparacion = request.getParameter("preparacion");
        
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
        
        List<Categoria> categorias = new GestionDAO().obtenerCategorias();   
        List<Proveedor> proveedores = new GestionDAO().obtenerProveedores();
        //Este servlet envía los datos a "cartelera.jsp"
        RequestDispatcher rd = request.getRequestDispatcher("nuevoproducto2.jsp");
        request.setAttribute("listaCategorias", categorias);       
        request.setAttribute("listaProveedores", proveedores);       
        rd.forward(request, response);   
    
        
    }

  
}
