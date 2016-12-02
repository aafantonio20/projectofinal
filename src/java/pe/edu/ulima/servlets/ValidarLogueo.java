package pe.edu.ulima.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import pe.edu.ulima.model.GestionDAO;
import pe.edu.ulima.model.Usuario;

@WebServlet(name = "ValidarLogueo", urlPatterns = {"/validarlogueo"})
public class ValidarLogueo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        GestionDAO usuarito = new GestionDAO();

        boolean estado = usuarito.validarLogueo(username, password);
        Usuario user1=usuarito.obtenerUsuario(username);
        
        if (estado) {
            //En este caso solo estamos redireccionando a un JSP sin SCRIPTLETS
            //por este motivo usamos "response.sendRedirect"
            //Pero si necesitaramos reenviarlo a un JSP que sí tiene SCRIPTSLETS; entonces,
            //en ese caso sólo necesitariamos ingresar el nombre del SERVLET (este servlet ya tiene un JSP que lo direcciona)
            //Sólo pondríamos así: response.sendRedirect("nombre_de_mi_servlet");

            if (user1.getId()==1) {
                response.sendRedirect("bienvenido.html");
            } else if(user1.getId()==2) {             
                response.sendRedirect("bienvenido_mozo.html");
            }else if(user1.getId()==3) {             
                response.sendRedirect("bienvenido_anfitrion.html");
            }else if(user1.getId()==4) {             
                response.sendRedirect("bienvenido_cajero.html");
            }else if(user1.getId()==5) {             
                response.sendRedirect("bienvenido_gerente.html");
            }
            
           // response.sendRedirect("bienvenido.html");
        } else {
            response.sendRedirect("inicio_sesion_again.jsp");
        }
    }
}
