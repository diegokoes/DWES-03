package es.daw.jakarta.models;

import java.util.List;
import java.util.ArrayList;

public class Carro {
    //private List<ItemCarro> items = new ArrayList<>();
    private List<ItemCarro> items;
    
    public Carro() {
        items = new ArrayList<>();
    }


    public List<ItemCarro> getItems() {
        return items;
    }

    public void addItemCarro(ItemCarro itemCarro){
        // Hay que controlar si existe ya previamente el item en el carro

        // Si existe incremento la cantidad en 1

        // Si no existe añado el item del Carro
        items.add(itemCarro);
    }

    public int getTotal(){
        // FORMA IMPERATIVA
        // Recorrer los items del carro
        // Coger el precio de cada item
        // sumatorio del precio
        // devolver el total

        // FORMA API STREAM (FUNCIONAL)
        //Dame el sumatorio de todos los precios de los productos de la lista

        return 0;

    }

    
}