# Conceptos fundamentales de HttpSession con Java

## Servlet que introduce datos en una sesión

```
@WebServlet("/CrearSession")
public class CrearSession extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession misession = request.getSession(true);
        Producto miproducto = new Producto(1, "telefono", 300);
        misession.setAttribute("producto", miproducto);
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>Producto en session</body></html>");
        pw.close();
    }
}
```

## Servlet que lee datos de la sesión

```
@WebServlet("/VerSession")
public class VerSession extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession misession = request.getSession();
        Producto miproducto = (Producto) misession.getAttribute("producto");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>" + miproducto.getId() + "," + miproducto.getConcepto() + "," + miproducto.getImporte() + "</body></html>");
        pw.close();
    }
}
```

El primer Servlet (CreaSession) se encarga de crear la session y almacenar un producto en ella. Mientras el segundo Servlet se encargará de acceder a los datos y mostrarlos por pantalla.

![image](https://github.com/user-attachments/assets/55a467ea-c5b8-4d09-a5e7-099728c10beb)

Hemos compartido información perteneciente al mismo usuario entre dos Servlets. 

No se debe abusar del almacenamiento de objetos en Session ya que al ser por cada usuario si tenemos muchos usuarios concurrentes estaremos obligando al servidor a utilizar mucha memoria para almacenarlos.

<i> Referencia: https://www.arquitecturajava.com/usando-java-session-en-aplicaciones-web/ </i>

# Ejercicio 1: sistema de login

## Pasos:
- Crear un nuevo proyecto para tener un entorno limpio llamado **webapp-session.**
    - Para ello vamos a copiar el proyecto webapp-session y limpiamos todo menos lo relativo al ejercicio de login con sesiones.
- Reutilizaremos los servlets **LoginCookieServlet y LogoutServlet** en los que cambiaremos el uso de cookies por HttpSession. Por tanto creamos **LoginSessionServlet y LogoutSessionServlet.**
    - En el **doPost de LoginSessionServlet** implementaremos el código para añadir a la sesión el username (login):
      
          ```
      
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
      
          ```
      
    - En el **doGet de LoginSessionServlet** implementaremos el código para devolver una página como la siguiente:

      <img src="https://github.com/user-attachments/assets/0c613f20-9036-4b0b-898a-82df3203a3e1" height="150px"/>

    - En el **doGet de LogoutSessionServlet** implementaremos el código para invalidar la sesión.

- Añadimos una implementación del servicio de login **LoginServiceSessionImpl**




# Ejercicio 2: carro de la compra

Vamos a partir de una página index.html muy sencilla con un menú para manejar mi "tienda":

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de la compra</title>
</head>
<body>
<h3>Manejo de cookies Http</h3>
<ul>
    <li><a href="productos">Mostrar productos html</a></li>
    <li><a href="login">Login</a></li>
    <li><a href="logout">Logout</a></li>
    <li><a href="carro/ver">ver carro</a></li>
</ul>

</body>
</html>
```


Para poder comprar debemos haber hecho login (iniciado sesión). 

Finalmente daremos un diseño con Bootstrap.

