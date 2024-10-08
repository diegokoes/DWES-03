# Conceptos fundamentales de Cookies con Java


Para crear una cookie y enviarla al cliente:

```
// Crear una cookie
Cookie cookie = new Cookie("usuario", "nombreDeUsuario");
// Establecer tiempo de expiración en 7 días
cookie.setMaxAge(7 * 24 * 60 * 60); 
response.addCookie(cookie);

```

Para leer la cookie, el servlet recibiría todas las cookies en el HttpServletRequest:

```
Cookie[] cookies = request.getCookies();
for (Cookie c : cookies) {
    if (c.getName().equals("usuario")) {
        String nombreUsuario = c.getValue();
        // Realizar alguna acción con el valor de la cookie
    }
}

```

# Ejercicio 1

Práctica guiada para mejorar el sistema de login.

Observa el siguiente código:

```
// Forma 1: API Stream
Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
return Arrays.stream(cookies)
             .filter(c -> "username".equals(c.getName()))
             .map(Cookie::getValue)
             .findAny();

```

```
// Forma 2:
Cookie[] cookies = request.getCookies();
String nombre = null;

if (cookies != null) {
    for (Cookie cookie : cookies) {
        if ("username".equals(cookie.getName())) {
            nombre = cookie.getValue();
            break;
        }
    }
}

```

## Pasos:

1. Reutilizaremos el proyecto webapp-ut03
2. Crearemos una página html nueva llamada cookie.html:
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cabeceras Http</title>
</head>
<body>
<h3>Manejo de cookies Http</h3>
<ul>
    <li><a href="/productos">mostrar productos html</a></li>
    <li><a href="/login.html">login</a></li>
    <li><a href="/logout">logout</a></li>
</ul>

</body>
</html>
```
3. Vamos a hacer dos controladores (servlets): LoginServlet y LogoutServlet
4. Vamos a crear el servicio de Login: LoginService y LoginServiceImpl
