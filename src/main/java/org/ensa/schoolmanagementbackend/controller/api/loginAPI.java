package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.impl.ProfImpl;
import org.ensa.schoolmanagementbackend.metier.ProfLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prof/verifie")
@CrossOrigin(origins = "http://localhost:5173")
public class loginAPI {

    @Autowired
    private ProfLogin proflogin;
    @Autowired
    ProfImpl profimpl;
    // Endpoint pour vérifier les informations du professeur
    @PostMapping("/verifier")
    public ResponseEntity<Long> verifierProfesseur(@RequestBody Prof prof) {
        // Vérification des informations dans la base de données
        boolean isValid = proflogin.verifierProfesseur(prof);

        if (isValid) {
            Long id = profimpl.findbymail(prof).getCode();
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            Long id  = (long) -1;
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }
    }
}
