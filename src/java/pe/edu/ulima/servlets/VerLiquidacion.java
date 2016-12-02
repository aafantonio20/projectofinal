
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
import pe.edu.ulima.model.Liquidacion;
import pe.edu.ulima.model.ObjetoDetalle;
import pe.edu.ulima.model.ObjetoSolo;
import pe.edu.ulima.model.Venta;


public class VerLiquidacion extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         GestionDAO gestion = new GestionDAO();

               //int idventaNuevo=ventita.getId_venta();
        List<Liquidacion> listaLiquidaciones = null;
        try {
            listaLiquidaciones = gestion.obtenerLiquidacion();
        } catch (SQLException ex) {
            Logger.getLogger(VerLiquidacion.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        RequestDispatcher rd = request.getRequestDispatcher("liquidacion.jsp");
        
        request.setAttribute("listaLiquidaciones", listaLiquidaciones);
        
        rd.forward(request, response);
        
    }

   

}
