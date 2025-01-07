package org.ensa.schoolmanagementbackend.controller.api;


import org.ensa.schoolmanagementbackend.dao.dto.EnregistrerEtudiantDto;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;
import org.ensa.schoolmanagementbackend.metier.EtudiantMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@CrossOrigin(origins = "http://localhost:5173")
public class EtudiantRestAPI {

    @Autowired
    private EtudiantMetier etudiantMetier;

    @PostMapping("/addetudiants")
    public void addEtudiants(@RequestBody List<Etudiant> etudiants, @RequestParam Long filiereId, @RequestParam Long semestreId) {
        etudiantMetier.addEtudiants(etudiants, filiereId, semestreId);
    }

    @PostMapping("/getetudiants")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Etudiant> getEtudiants(@RequestBody EnregistrerEtudiantDto enregistrerEtudiantDto) {
        return etudiantMetier.getEtudiants(enregistrerEtudiantDto);
    }

    @DeleteMapping("/deleteetudiant")
    @CrossOrigin(origins = "http://localhost:5173")
    public void deleteEtudiant(@RequestBody Etudiant etudiant) {
        etudiantMetier.deleteEtudiant(etudiant);
    }

    @PutMapping("/updateetudiant")
    public void updateEtudiant(@RequestBody Etudiant etudiant) {
        etudiantMetier.updateEtudiant(etudiant);
    }


}