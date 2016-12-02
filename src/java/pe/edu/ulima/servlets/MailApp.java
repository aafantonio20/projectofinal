
package pe.edu.ulima.servlets;

import pe.edu.ulima.model.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MailApp extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        int dia=Integer.parseInt(request.getParameter("dia"));
        String mes=request.getParameter("mes");
        String hora=request.getParameter("hora");
       
        String to=request.getParameter("email");
        String nombres=request.getParameter("nombres");
        String apellidos=request.getParameter("apellidos");
        String subject="::: Acantilado de Barranco - Confirmación de la Reserva :::";
        
        String mess="Sr.(a) " + nombres + " " + apellidos + ", " + "su reserva ha sido confirmada, muchas gracias por su preferencia." + "\n" +
        "Los esperamos el día " + dia + " de " + mes + " a las " + hora + " pm.";
        
        String user="ulimasoft2@gmail.com";
        String pass="Pa$$w0rd123";
        SendMail.send(to, subject, mess, user, pass);
        /*String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        SendMail.send(to,subject, message, user, pass);
        out.println("Mail send successfully");*/
        
        RequestDispatcher rd = request.getRequestDispatcher("reservaconfirmada.html");   
        rd.forward(request, response);   
    }   

}
