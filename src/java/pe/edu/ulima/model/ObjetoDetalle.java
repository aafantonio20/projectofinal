
package pe.edu.ulima.model;

public class ObjetoDetalle {
 
    private String nombre;
    private int cantidad;
    private float precio;
    private float precioT;

    public ObjetoDetalle() {
    }

    public ObjetoDetalle(String nombre, int cantidad, float precio, float precioT) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioT = precioT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecioT() {
        return precioT;
    }

    public void setPrecioT(float precioT) {
        this.precioT = precioT;
    }
    
    
    
}
