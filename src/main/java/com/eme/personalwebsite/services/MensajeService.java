package com.eme.personalwebsite.services;

import com.eme.personalwebsite.models.MensajeModel;
import com.eme.personalwebsite.repositories.IMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    @Autowired
    private IMensajeRepository mensajeRepository;

    private void ingresarMensaje(MensajeModel mensajeModel) throws DataIntegrityViolationException {
        this.mensajeRepository.save(mensajeModel);
    }

    public ResponseEntity<String> setMensajeRepository(MensajeModel mensaje) {
        try {
            this.ingresarMensaje(mensaje);
            return new ResponseEntity<>("Mensaje ingresado correctamente", HttpStatus.OK);
        } catch(DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Falló el ingreso del mensaje a DB", HttpStatus.BAD_REQUEST);
        }
    }

}
