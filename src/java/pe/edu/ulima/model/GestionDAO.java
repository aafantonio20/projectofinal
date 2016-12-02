package pe.edu.ulima.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GestionDAO {

    public EntityManagerFactory emf;
    public EntityManager em;

    public void conectarse() {
        emf = Persistence.createEntityManagerFactory("LoginPU");
        em = emf.createEntityManager();
    }

    public void desconectarse() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    public void registrarUsuario(Usuario usuario) {
        conectarse();

        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        desconectarse();
    }

    public void registrarVenta(Venta venta) {
        conectarse();

        em.getTransaction().begin();
        em.persist(venta);
        em.getTransaction().commit();

        desconectarse();
    }

    public void registrarDetalleVenta(DetalleVenta detVenta) {
        conectarse();

        em.getTransaction().begin();
        em.persist(detVenta);
        em.getTransaction().commit();

        desconectarse();
    }

    public void registrarCliente(Cliente cliente) {
        conectarse();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        desconectarse();
    }

    public void registrarReserva(Reserva reserva) {
        conectarse();

        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();

        desconectarse();
    }

    public boolean validarLogueo(String username, String password) {

        conectarse();
        boolean estado = false;
        Query query = em.createQuery(
                "select user from Usuario user where user.username=:p1 and user.password=:p2");

        query.setParameter("p1", username);
        query.setParameter("p2", password);

        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        if (usuarios.size() == 0) {
            estado = false;
        } else {
            estado = true;
        }
        desconectarse();

        return estado;
    }

    //REGISTRAR CATEGORÍA:
    public void registrarCategoria(Categoria categoria) {
        conectarse();

        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();

        desconectarse();
    }

    //REGISTRAR PROVEEDOR:
    public void registrarProveedor(Proveedor proveedor) {
        conectarse();

        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();

        desconectarse();
    }

    //REGISTRAR PRODUCTO:
    public void registrarProducto(Producto producto) {
        conectarse();

        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();

        desconectarse();
    }

    public List<Categoria> obtenerCategorias() {
        conectarse();
        List<Categoria> categorias
                //Query query = em.createQuery(

                = em.createQuery("SELECT p FROM Categoria p").getResultList();
        desconectarse();
        return categorias;
    }

    public List<Personal> obtenerPersonal() {
        conectarse();
        List<Personal> personal
                //Query query = em.createQuery(

                = em.createQuery("SELECT p FROM Personal p").getResultList();
        desconectarse();
        return personal;
    }

    public List<Producto> obtenerProductos() {
        conectarse();
        List<Producto> productos
                //Query query = em.createQuery(

                = em.createQuery("SELECT p FROM Producto p").getResultList();
        desconectarse();
        return productos;
    }

    public List<Producto> obtenerProductosActivos() {
        conectarse();
        List<Producto> productos
                //Query query = em.createQuery(

                = em.createQuery("SELECT p FROM Producto p where p.estado='activo'").getResultList();
        desconectarse();
        return productos;
    }

    public List<Producto> obtenerProductosFiltrados(int idCategoria) {

        conectarse();
        List<Producto> productos = null;
        Query query = em.createQuery("SELECT p FROM Producto p where p.id_categoria_id_categoria=:p1");
        query.setParameter("p1", idCategoria);

        desconectarse();
        return productos;
    }

    public List<Venta> obtenerVenta() {
        conectarse();
        List<Venta> venta
                //Query query = em.createQuery(

                = em.createQuery("SELECT v FROM Venta v").getResultList();
        desconectarse();
        return venta;
    }

    public List<Reserva> obtenerReservas() {
        conectarse();
        List<Reserva> reservas
                //Query query = em.createQuery(

                = em.createQuery("SELECT r FROM Reserva r").getResultList();
        desconectarse();
        return reservas;
    }

    /*
    public List<Producto> obtenerProductosActivos(String estado) {
        conectarse();
        List<Producto> productos = null;
        Query query = em.createQuery("select p from Producto p where p.estado=:p1");
        query.setParameter("p1", estado);

        desconectarse();
        return productos;
    }*/

    public List<Proveedor> obtenerProveedores() {
        conectarse();
        List<Proveedor> proveedores
                = em.createQuery("SELECT p FROM Proveedor p").getResultList();
        desconectarse();
        return proveedores;
    }

    public Categoria obtenerCategoriaSegunID(int idCategoria) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select c from Categoria c where c.id_categoria =:c1");
        query.setParameter("c1", idCategoria);
        Categoria categoria = null;
        try {
            categoria = (Categoria) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return categoria;
    }

    public Cliente obtenerClienteSegunID(int idCliente) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select c from Cliente c where c.id_cliente =:c1");
        query.setParameter("c1", idCliente);
        Cliente cliente = null;
        try {
            cliente = (Cliente) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return cliente;
    }

    public Personal obtenerPersonalSegunID(int idPersonal) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p from Personal p where p.id_personal =:p1");
        query.setParameter("p1", idPersonal);
        Personal personal = null;
        try {
            personal = (Personal) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return personal;
    }

    public Personal obtenerPerSegunIDVenta(int idVenta) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p.id_personal from Venta p where p.id_venta =:p1");
        query.setParameter("p1", idVenta);
        Personal personal = null;
        try {
            personal = (Personal) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return personal;
    }

    public List<ObjetoDetalle> obtenerObjetosDetalleSegunIdVenta(int idVenta) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p.nombre, d.cantidad, p.precio, d.cantidad*p.precio as precioT from"
                + " Venta v JOIN DetalleVenta d on v.id_venta = d.Venta"
                + " join Producto p"
                + " on p.id_producto = d.Producto where v.id_venta = :p1");
        query.setParameter("p1", idVenta);
        List<ObjetoDetalle> detalles = null;
        try {
            detalles = (List<ObjetoDetalle>) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return detalles;
    }

    private Connection conectarse2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/sistema_venta?user=root&password=1234");
        } catch (ClassNotFoundException cne) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/sistema_venta?user=root&password=";

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public List<ObjetoDetalle> obtenerObjDet(int idVenta) throws SQLException {
        List<ObjetoDetalle> lista = new ArrayList<>();

        //1.1 Interface Connection
        Connection cn = this.getConnection();
        //1.2. Sentencia SQL 
        String sql = "select p.nombre, d.cantidad, p.precio, d.cantidad*p.precio as totalt\n"
                + "from\n"
                + "venta v inner join detalleventa d on \n"
                + "v.id_venta = d.id_venta_id_venta inner join producto p on\n"
                + "p.id_producto = d.id_producto_id_producto\n"
                + "where\n"
                + "v.id_venta = ?;";
        //1.3.Interface PreparedStatement
        PreparedStatement psmt = null;
        //1.4. Interface ResultSet
        ResultSet rs = null;
        try {
            //1.5. Precompilamos la sentencia sql 
            psmt = cn.prepareStatement(sql);
            //1.6.Ejecutamos
            psmt.setInt(1, idVenta);
            rs = psmt.executeQuery();
            // 1.7 Procesar ResultSet
            // Recuperamos los datos de la consulta 
            while (rs.next()) { //más de un registro                

                //1.8.Creamos un objeto AlumnoBean cn estos datos
                ObjetoDetalle objRef = new ObjetoDetalle();
                objRef.setNombre(rs.getString("nombre"));
                objRef.setCantidad(rs.getInt("cantidad"));
                objRef.setPrecio(rs.getFloat("precio"));
                objRef.setPrecioT(rs.getFloat("totalT"));

                //1.9.Lo adicionamos ref la lista
                lista.add(objRef);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            //1.10 Cerramos los recursos
            //puede lanzar excepciones SQLException
            try {
                psmt.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {

            }
        }
        return lista;
    }

    public List<ObjetoSolo> obtenerMontoTotal(int idVenta) throws SQLException {
        List<ObjetoSolo> lista = new ArrayList<>();

        //1.1 Interface Connection
        Connection cn = this.getConnection();
        //1.2. Sentencia SQL 
        String sql = "select sum(d.cantidad*p.precio) as SUPERTOTAL\n"
                + "from\n"
                + "venta v inner join detalleventa d on \n"
                + "v.id_venta = d.id_venta_id_venta inner join producto p on\n"
                + "p.id_producto = d.id_producto_id_producto\n"
                + "where\n"
                + "v.id_venta = ?;";
        //1.3.Interface PreparedStatement
        PreparedStatement psmt = null;
        //1.4. Interface ResultSet
        ResultSet rs = null;
        try {
            //1.5. Precompilamos la sentencia sql 
            psmt = cn.prepareStatement(sql);
            //1.6.Ejecutamos
            psmt.setInt(1, idVenta);
            rs = psmt.executeQuery();
            // 1.7 Procesar ResultSet
            // Recuperamos los datos de la consulta 
            while (rs.next()) { //más de un registro                

                //1.8.Creamos un objeto AlumnoBean cn estos datos
                ObjetoSolo objRef = new ObjetoSolo();
                objRef.setMonto(rs.getFloat("SUPERTOTAL"));
                //1.9.Lo adicionamos ref la lista
                lista.add(objRef);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            //1.10 Cerramos los recursos
            //puede lanzar excepciones SQLException
            try {
                psmt.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {

            }
        }
        return lista;
    }

    public Categoria obtenerCatSegunIDProd(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p.id_categoria from Producto p where p.id_producto =:p1");
        query.setParameter("p1", idProducto);
        Categoria categoria = null;
        try {
            categoria = (Categoria) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return categoria;
    }

    /*
    public List<Producto> obtenerListaProdSegunIDVenta(int idVenta) {
        conectarse();
        List<Producto> productos = em.createQuery("select v.id_producto from Venta v where v.id_venta =:v1").getResultList();
        desconectarse();
        return productos;
    }
     */

 /*
    conectarse();
        List<Producto> productos = null;
        Query query = em.createQuery("SELECT p FROM Producto p where p.id_categoria_id_categoria=:p1");
        query.setParameter("p1", idCategoria);

        desconectarse();
        return productos;
     */
 /*
    public List<DetalleVenta> obtenerListaDetVentaSegunIDVenta(int idVenta) {
        conectarse();
        List<DetalleVenta> detVentas = em.createQuery("select id_detalleventa from Venta v where v.id_venta =:v1").getResultList();
        desconectarse();
        return detVentas;
    }*/

 /*
     public DetalleVenta obtenerDetVentaSegunIDVenta(int idVenta) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select id_detalleventa from Venta v where v.id_venta =:v1");
        query.setParameter("v1", idVenta);
        DetalleVenta detalleventa = null;
        try {
            detalleventa = (DetalleVenta) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return detalleventa;
    }*/
    public Producto obtenerProducto(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p from Producto p where p.id_producto=:p1");
        query.setParameter("p1", idProducto);
        Producto producto = null;
        try {
            producto = (Producto) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return producto;
    }

    public Usuario obtenerUsuario(String username) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select u from Usuario u where u.username =:p1");
        query.setParameter("p1", username);
        Usuario user = null;
        try {
            user = (Usuario) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return user;
    }

    public Proveedor obtenerProSegunIDProd(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p.id_proveedor from Producto p where p.id_producto =:p1");
        query.setParameter("p1", idProducto);
        Proveedor proveedor = null;
        try {
            proveedor = (Proveedor) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return proveedor;
    }

    /* public Proveedor obtenerProSegunIDProd(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p.id_proveedor from Producto p where p.id_producto =:p1");
        query.setParameter("p1", idProducto);
        Proveedor proveedor = null;
        try {
            proveedor = (Proveedor) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return proveedor;
    }*/
    public Producto obtenerProductoSegunID(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p from Producto p where p.id_producto =:p1");
        query.setParameter("p1", idProducto);
        Producto producto = null;
        try {
            producto = (Producto) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return producto;
    }

    public Venta obtenerVentaSegunID(int idVenta) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select v from Venta v where v.id_venta =:v1");
        query.setParameter("v1", idVenta);
        Venta venta = null;
        try {
            venta = (Venta) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return venta;
    }

    public Reserva obtenerReservaSegunID(int idReserva) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select r from Reserva r where r.id_reserva =:r1");
        query.setParameter("r1", idReserva);
        Reserva reserva = null;
        try {
            reserva = (Reserva) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return reserva;
    }

    /*
    public Venta obtenerVentaSegunID(int idVenta) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select v from Venta v where v.id_venta =:v1");
        query.setParameter("v1", idVenta);
        Venta venta = null;
        try {
            venta = (Venta) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return venta;
    }
     */
    public Proveedor obtenerProveedorSegunID(int idProveedor) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p from Proveedor p where p.id_proveedor =:p1");
        query.setParameter("p1", idProveedor);
        Proveedor proveedor = null;
        try {
            proveedor = (Proveedor) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return proveedor;
    }

    public void eliminarProductoSegunID(int idProducto) {
        conectarse();

        Producto producto = em.find(Producto.class, idProducto);
        em.getTransaction().begin();
        em.remove(producto);
        em.getTransaction().commit();

        desconectarse();
    }

    public void eliminarVentaSegunID(int idVenta) {
        conectarse();

        Venta venta = em.find(Venta.class, idVenta);
        em.getTransaction().begin();
        em.remove(venta);
        em.getTransaction().commit();

        desconectarse();
    }

    public void eliminarReservaSegunID(int idReserva) {
        conectarse();

        Reserva reser = em.find(Reserva.class, idReserva);
        em.getTransaction().begin();
        em.remove(reser);
        em.getTransaction().commit();

        desconectarse();
    }

    public void modificarProducto(Producto producto) {
        conectarse();

        em.getTransaction().begin();
        em.merge(producto);
        em.getTransaction().commit();

        desconectarse();
    }

    public void modificarCliente(Cliente cliente) {
        conectarse();

        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();

        desconectarse();
    }

    public void modificarReserva(Reserva reserva) {
        conectarse();

        em.getTransaction().begin();
        em.merge(reserva);
        em.getTransaction().commit();

        desconectarse();
    }

    //Método para enviar email:
    //Esta clase Email es donde se encuentra toda la lógica.
    public boolean enviarCorreo(String de, String clave, String para, String mensaje, String asunto) {

        boolean enviado = false;

        try {
            String host = "smtp.gmail.com";
            Properties propies = System.getProperties();
            propies.put("mail.smtp.starttls.enable", "true");
            propies.put("mail.smtp.host", host);
            propies.put("mail.smtp.user", de);
            propies.put("mail.smtp.password", clave);
            propies.put("mail.smtp.port", 587);
            propies.put("mail.smtp.auth", "true");
            propies.put("mail.smtp.ssl.trust", host);

            Session sesion;
            sesion = Session.getDefaultInstance(propies, null);

            MimeMessage message = new MimeMessage(sesion);

            message.setFrom(new InternetAddress(de));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject(asunto);
            message.setContent(mensaje, "text/html; charset=utf-8");
            Transport transport = sesion.getTransport("smtp");

            transport.connect(host, de, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            enviado = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return enviado;
    }

    //----------------------------------------------------------------
    //2. Insertar un registro en la base de datos (en la tabla tb_alumnos)
    public void insertarDetalleVenta(DetalleVenta ref) {
        //2.1. Interface Connection
        Connection cn = DBConexion.getConnection();
        //2.2 Sentencia SQL 
        String sql = "INSERT INTO detalleventa(CANTIDAD, DESCRIPCION,ID_PRODUCTO_ID_PRODUCTO, ID_VENTA_ID_VENTA) VALUES (?,?,?,?)";
        //2.3.Interface PreparedStatement
        PreparedStatement pstmt = null;
        try {
            //2.4. Precompilamos la sentencia sql 
            pstmt = cn.prepareStatement(sql);

            //2.5.insertar el registro en la tabla tb_alumno 
            pstmt.setInt(1, ref.getCantidad());
            pstmt.setString(2, ref.getDescripcion());
            Producto prod = new Producto();
            prod = ref.getId_producto();
            pstmt.setInt(3, prod.getId_producto());
            Venta vent = new Venta();
            vent = ref.getId_venta();
            pstmt.setInt(4, vent.getId_venta());
            // 2.6.Ejecutar
            int rc = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                //2.7.Liberar recursos
                //puede lanzar excepciones SQLException
                pstmt.close();
                cn.close();
            } catch (SQLException ex) {

            }
        }
    }

    //3.Eliminar un registro 
    //De un alumno cn un código pasado por argumento 
    public void eliminarDetVen(int idVenta) {
        // 3.1 Interface Connection
        Connection cn = DBConexion.getConnection();
        // 3.2 Sentencia SQL
        String sql = "DELETE FROM detalleventa WHERE ID_VENTA_ID_VENTA=?; ";
        //3.3 Interface PreparedStatement
        PreparedStatement pstmt = null;
        try {
            //3.4 Precompilamos la sentencia sql 
            pstmt = cn.prepareStatement(sql);
            // 3.5 Colocar valores a las ??
            pstmt.setInt(1, idVenta);
            // 3.6 Ejecutar
            int cont = pstmt.executeUpdate();
            //System.out.println("Cantidad de registros afectados: " + cont);

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                // 3.7 Liberar recursos
                // puede lanzar excepciones SQLException
                pstmt.close();
                cn.close();
            } catch (SQLException ex) {

            }
        }
    }

  
     public List<Liquidacion> obtenerLiquidacion() throws SQLException {
        List<Liquidacion> lista = new ArrayList<>();

        //1.1 Interface Connection
        Connection cn = this.getConnection();
        //1.2. Sentencia SQL 
        String sql = "select sum(d.cantidad*p.precio) as SUPERTOTAL\n"
                + "from\n"
                + "venta v inner join detalleventa d on \n"
                + "v.id_venta = d.id_venta_id_venta inner join producto p on\n"
                + "p.id_producto = d.id_producto_id_producto\n";
        //1.3.Interface PreparedStatement
        PreparedStatement psmt = null;
        //1.4. Interface ResultSet
        ResultSet rs = null;
        try {
            //1.5. Precompilamos la sentencia sql 
            psmt = cn.prepareStatement(sql);
            //1.6.Ejecutamos
            rs = psmt.executeQuery();
            // 1.7 Procesar ResultSet
            // Recuperamos los datos de la consulta 
            while (rs.next()) { //más de un registro                

                //1.8.Creamos un objeto AlumnoBean cn estos datos
                Liquidacion objRef = new Liquidacion();
                objRef.setLiquidacion(rs.getFloat("SUPERTOTAL"));
                //1.9.Lo adicionamos ref la lista
                lista.add(objRef);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            //1.10 Cerramos los recursos
            //puede lanzar excepciones SQLException
            try {
                psmt.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {

            }
        }
        return lista;
    }
    

}
