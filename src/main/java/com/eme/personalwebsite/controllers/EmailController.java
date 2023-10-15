package com.eme.personalwebsite.controllers;

import com.eme.personalwebsite.helpers.EmailSender;
import com.eme.personalwebsite.models.MensajeModel;
import com.eme.personalwebsite.services.MensajeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class EmailController {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private MensajeService mensajeService;

    @PostMapping("/email")
    public ResponseEntity<String> email(HttpServletRequest request) {
        ResponseEntity<String> response;

        MensajeModel mensaje = new MensajeModel();
        mensaje.setName(request.getHeader("name"));
        mensaje.setEmail(request.getHeader("email"));
        mensaje.setBody(request.getHeader("message"));

        response = this.mensajeService.setMensajeRepository(mensaje);

        if (response.getStatusCode() == ResponseEntity.ok().build().getStatusCode()){
            return this.emailSender.sendEmail(
                    request.getHeader("email"),
                    "Correo recibido",
                    "Hola! " + request.getHeader("name") + "\n\n" + "Gracias por contactarme, te responderé lo más pronto posible.\n\n" + "Saludos cordiales,\n\n" + "Fina Mariano");
        } else {
            return response;
        }

    }
}