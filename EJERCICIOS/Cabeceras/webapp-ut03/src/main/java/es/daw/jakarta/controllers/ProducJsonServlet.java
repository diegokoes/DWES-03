package es.daw.jakarta.controllers;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.daw.jakarta.services.ProductServiceImpl;
import es.daw.jakarta.models.Producto;
import es.daw.jakarta.services.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos.json")
public class ProducJsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService service = new ProductServiceImpl();
        List<Producto> productos = service.listar();

        // Jackson. Necesito el objeto que mapee objetos a json
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(productos);

        response.setContentType("application/json");

        response.getWriter().write(json);
                
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                // PENDIENTE, PARA EL LUNES 7 DE OCTUBRE !!!!!!!!!!!
                
    }
}
