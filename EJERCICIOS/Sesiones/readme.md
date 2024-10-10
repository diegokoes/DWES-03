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

<pre> Referencia: https://www.arquitecturajava.com/usando-java-session-en-aplicaciones-web/ </pre>
