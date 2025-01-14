package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.dto.ProfElementStatsDTO;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.dto.ProfDispoDTO;
import org.ensa.schoolmanagementbackend.dao.dto.ProfSModuleDTO;
import org.ensa.schoolmanagementbackend.metier.ProfElementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profelement")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfElementRest {


    @Autowired
    private ProfElementMetier profElementMetier;


    @PostMapping("/affectprofelement")
    public void affect(@RequestBody ProfSModuleDTO profSModuleDTO) {
        System.out.println("Professeur: " + profSModuleDTO.getProfesseur());
        System.out.println("SModule: " + profSModuleDTO.getSmodule());
        profElementMetier.affect(profSModuleDTO.getProfesseur(), profSModuleDTO.getSmodule());
    }

    @GetMapping("/getdispoprof")
    public List<ProfDispoDTO> disponibleProf() {
        return profElementMetier.disponibleProf();
    }

    @GetMapping("/getdispoelem")
    public List<SModule> disponibleModule() {
        return profElementMetier.disponibleSModule();
    }

    @GetMapping("/showaffectprofelement")
    public List<SModule> showAffectation() {
        return profElementMetier.showAffectation();
    }


    @PutMapping("/deleteaffectprofelement")
    public void deleteAffectation(@RequestBody SModule sModule) {
        profElementMetier.deleteAffectation(sModule);
    }

    @GetMapping("/getProfElementStats")
    public List<ProfElementStatsDTO> getProfElementStats() {
        return profElementMetier.getProfElementStats();
    }
}