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
import pe.edu.ulima.model.DetalleVenta;
import pe.edu.ulima.model.GestionDAO;
import pe.edu.ulima.model.Personal;
import pe.edu.ulima.model.Producto;
import pe.edu.ulima.model.Proveedor;
import pe.edu.ulima.model.Venta;

public class GuardarPedido extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestionDAO gestion = new GestionDAO();

        String mesa = request.getParameter("mesa");
        int idPersonal = Integer.parseInt(request.getParameter("idPersonal"));
        int pax = Integer.parseInt(request.getParameter("pax"));
        String [] productitoName = request.getParameterValues("productito");
        String[] cantidad = request.getParameterValues("cantidad");

        Personal personal1 = new Personal();
        personal1 = gestion.obtenerPersonalSegunID(idPersonal); //Objeto venta:
                // public Venta(int id_venta, Personal id_personal, int pax, Float montoPagar, String mesa) {
        Venta ventita = new Venta();
        ventita.setId_personal(personal1);
        ventita.setPax(pax);
        ventita.setMontoPagar(10.0f);
        ventita.setMesa(mesa);
        
        gestion.registrarVenta(ventita);
        
        System.out.println(ventita.getId_personal().getNombres() +  " " + ventita.getId_venta() +  " " + ventita.getMesa() +  " " + ventita.getMontoPagar() +  " " + ventita.getPax());

        for (int i = 0; i < cantidad.length; i++) {
            int idProducto=Integer.parseInt(productitoName[i]);
        //    System.out.println(idProducto);
            Producto productito = gestion.obtenerProducto(idProducto);
            String descripcion=productito.getNombre();
          //  System.out.println(descripcion);
            int cant = Integer.parseInt(cantidad[i]);
            //System.out.println(cant);
            
            DetalleVenta detalilito = new DetalleVenta();
            detalilito.setId_producto(productito);
            detalilito.setId_venta(ventita);
            detalilito.setDescripcion(descripcion);
            detalilito.setCantidad(cant);
            System.out.println(detalilito.getCantidad());
            System.out.println(detalilito.getDescripcion());
            System.out.println(detalilito.getId_producto().getId_producto());
            System.out.println(detalilito.getId_venta().getId_venta());
            
            //public DetalleVenta(int id_detalleventa, Producto id_producto, Venta id_venta, String descripcion, int cantidad) {
           
            gestion.insertarDetalleVenta(detalilito);
            
            //System.out.println(productitoName[i]);
            //System.out.println(cantidad[i]);
        }
        
        response.sendRedirect("obtenerpedidos");

      }

}
