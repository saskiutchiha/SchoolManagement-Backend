package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.FiliereStatsDTO;
import org.ensa.schoolmanagementbackend.dao.dto.ModuleStatsDTO;
import org.ensa.schoolmanagementbackend.dao.entity.Module;
import java.util.List;

public interface DashboardMetier {


    List<FiliereStatsDTO> getFiliereStats();
    List<ModuleStatsDTO> bestAndWorstModules();

    long getProfCount();

    long getEtudiantCount();

    long getModuleCount();

    long getFiliereCount();
}
