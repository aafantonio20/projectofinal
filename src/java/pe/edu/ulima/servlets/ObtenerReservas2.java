/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.model.GestionDAO;
import pe.edu.ulima.model.Reserva;

/**
 *
 * @author juancarlos
 */
public class ObtenerReservas2 extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Reserva> listaReservas = new GestionDAO().obtenerReservas();
        
        RequestDispatcher rd = request.getRequestDispatcher("gestionreservas3.jsp");
        request.setAttribute("listaReservas", listaReservas);
        
        rd.forward(request, response);
        
        
    }

   
}
