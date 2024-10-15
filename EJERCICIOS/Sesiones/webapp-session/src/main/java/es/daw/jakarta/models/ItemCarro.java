package es.daw.jakarta.models;

public class ItemCarro {

    // ATRIBUTOS
    private int cantidad;
    private Producto producto;

    // CONSTRUCTORES
    public ItemCarro(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    // GETTERS & SETTERS
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // MÉTODOS DE COMPORTAMIENTO
    public int getImporte(){
        return cantidad*producto.getPrecio();
    }
    
    // SOBREESCRITURA DE MÉTODOS DE OBJECT...
    
    
}
