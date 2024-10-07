# Ejercicio 1


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
