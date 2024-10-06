package es.daw.jakarta.services;

import java.util.List;

import es.daw.jakarta.models.Producto;

public interface ProductService {
    
    // Método abstracto. No es necesario poner la palabra reservada abstract
    public List<Producto> listar();
}
