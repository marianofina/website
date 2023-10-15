# website
Backend para Sitio Personal
Este es el backend de un sitio personal que proporciona información personal desde un archivo JSON. Además, ofrece la capacidad de recibir mensajes de contacto a través de una solicitud POST a la URL /email, donde el mensaje se guarda una DB MariaDB y en caso de estar ok se envía un correo a la dirección proporcionada desde una cuenta configurada en porperties.
La aplicación se ejecutará en http://localhost:8080.

## Endpoints
### GET /data/seccion: Obtiene información de una sección específica (sección puede ser home, about, education, exp, portfolio o contact).
### POST /email: Envía un mensaje de contacto. Debe incluir los siguientes encabezados en la solicitud
name: Nombre del remitente.
email: Correo electrónico del remitente.
body: Cuerpo del mensaje.

## Ejemplo de Uso
### Obtener información de la sección "about"
curl http://localhost:8080/data/about
### Enviar un mensaje de contacto
curl -X POST http://localhost:8080/email -H "name: Tu Nombre" -H "email: tu@email.com" -H "body: Mensaje de prueba"
