package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.entity.Admin;
import org.ensa.schoolmanagementbackend.dao.entity.Filiere;
import org.ensa.schoolmanagementbackend.dto.FiliereDTO;
import org.ensa.schoolmanagementbackend.metier.FiliereMetier;
import org.ensa.schoolmanagementbackend.metier.FiliereMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filiere")
@CrossOrigin(origins = "http://localhost:5173")
public class FiliereRestAPI {

    @Autowired
    private FiliereMetier filiereMetier;


    @GetMapping("/getfilieres")
    public List<FiliereDTO> getAdmins(){
        return filiereMetier.getFilieres();
    }

    @PostMapping("/addfiliere")
    public void addAdmin(@RequestBody Filiere filiere){
        filiereMetier.addFiliere(filiere);
    }

    @PutMapping("/updatefiliere")
    public void updateAdmin(@RequestBody Filiere filiere){
        filiereMetier.updateFiliere(filiere);
    }

    @DeleteMapping("deletefiliere")
    @CrossOrigin(origins = "http://localhost:5173")
    public void deleteAdmin(@RequestBody Filiere filiere){
        filiereMetier.deleteFiliere(filiere);
    }
}