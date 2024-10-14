# Ejemplo de un Filter

Ejemplo básico de un filtro de autenticación, que verifica un token antes de permitir el acceso:

```
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/api/protegido/*")
public class FiltroAutenticacion implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Código de inicialización si es necesario
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        // Verificación simple de autenticación mediante un token
        String token = httpRequest.getHeader("Authorization");

        if (token != null && token.equals("token_valido")) {
            // Continuar con la cadena de filtros
            chain.doFilter(request, response);
        } else {
            // Bloquear acceso si no está autorizado
            response.getWriter().write("Acceso no autorizado");
        }
    }

    @Override
    public void destroy() {
        // Código de limpieza si es necesario
    }
}

```
