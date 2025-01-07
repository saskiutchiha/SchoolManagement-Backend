package org.ensa.schoolmanagementbackend.controller.api;


import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.Semestre;
import org.ensa.schoolmanagementbackend.dao.impl.ProfImpl;
import org.ensa.schoolmanagementbackend.metier.SemestreMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/semestre")
@CrossOrigin(origins = "http://localhost:5173")
public class SemestreRestAPI {

    @Autowired
    private SemestreMetier semestreMetier;


    @GetMapping("/getsemestres")
    public List<Semestre> getSemestres() {
        return semestreMetier.getsemestres();
    }

}
