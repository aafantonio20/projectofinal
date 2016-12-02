
package pe.edu.ulima.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.model.GestionDAO;
import pe.edu.ulima.model.ObjetoDetalle;
import pe.edu.ulima.model.ObjetoSolo;
import pe.edu.ulima.model.Venta;


public class VerDetalleBoleta extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionDAO gestion = new GestionDAO();

        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        Venta ventita = gestion.obtenerVentaSegunID(idVenta);

        //int idventaNuevo=ventita.getId_venta();
        List<ObjetoDetalle> listaObjetos = null;
        try {
            listaObjetos = gestion.obtenerObjDet(idVenta);
        } catch (SQLException ex) {
            Logger.getLogger(VerDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<ObjetoSolo> listaObjetosSolo = null;
        try {
            listaObjetosSolo = gestion.obtenerMontoTotal(idVenta);
        } catch (SQLException ex) {
            Logger.getLogger(VerDetallePedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("gestionpedidos4.jsp");
        request.setAttribute("venta", ventita);
        request.setAttribute("listaObjetos", listaObjetos);
        request.setAttribute("listaObjetosSolo", listaObjetosSolo);
        rd.forward(request, response);
    }

   

}
