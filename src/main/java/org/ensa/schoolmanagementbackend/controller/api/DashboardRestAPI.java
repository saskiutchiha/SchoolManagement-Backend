package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.dto.FiliereStatsDTO;
import org.ensa.schoolmanagementbackend.dao.dto.ModuleStatsDTO;
import org.ensa.schoolmanagementbackend.metier.DashboardMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ensa.schoolmanagementbackend.dao.entity.Module;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardRestAPI {

    @Autowired
    public DashboardMetier dashboardMetier;

    @GetMapping("/getFiliereData")
    public List<FiliereStatsDTO> getFiliereData() {
        return dashboardMetier.getFiliereStats();
    }

    @GetMapping("/getBestModules")
    public List<ModuleStatsDTO> bestAndWorstModules() {
        return dashboardMetier.bestAndWorstModules();
    }

    @GetMapping("/getProfCount")
    public long getProfCount() {
        return dashboardMetier.getProfCount();
    }

    @GetMapping("/getEtudiantCount")
    public long getEtudiantCount() {
        return dashboardMetier.getEtudiantCount();
    }

    @GetMapping("/getModuleCount")
    public long getModuleCount() {
        return dashboardMetier.getModuleCount();
    }

    @GetMapping("/getFiliereCount")
    public long getFiliereCount() {
        return dashboardMetier.getFiliereCount();
    }

}
