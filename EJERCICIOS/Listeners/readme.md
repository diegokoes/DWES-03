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



