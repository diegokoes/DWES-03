# Ejemplo de un sencillo Listener de sesión

```
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MiSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Nueva sesión creada: " + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Sesión destruida: " + event.getSession().getId());
    }
}

```

# Ejercicio 1: amplicar el carrito de la compra con listeners

Vamos a crear un **nuevo paquete listeners.**

Creamos la clase **AppListener** que implemente **ServletContextListener**, **ServletRequestListener** y **HttpSessionListener**, por tanto usaremos el mismo listener para esos tres ámbitos.

Vamos a copiar este código y ejecutarlo para ver como funciona el listener:

```
@WebListener
public class AppListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("inicializando la aplicacion!");
        servletContext = sce.getServletContext();
        //servletContext.setAttribute("mensaje", "algun valor global de la app!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("destruyendo la aplicacion!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("inicializando el request!");
        //sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("destruyendo el request!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("inicializando la sesion http");

        // En vez de crear el carro en el servlet AgregarCarro
        // Carro carro = new Carro();
        // HttpSession session = se.getSession();
        // session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("destruyendo la sesion http");
    }
}

```

