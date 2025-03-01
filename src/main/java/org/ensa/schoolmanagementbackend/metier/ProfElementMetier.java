package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.ProfElementStatsDTO;
import org.ensa.schoolmanagementbackend.dao.dto.SModuleDtO;
import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.dto.ProfDispoDTO;

import java.util.List;

public interface ProfElementMetier {

    public void affect(Prof professeur, SModuleDtO sModule);
    public List<ProfDispoDTO> disponibleProf();
    public List<SModule> disponibleSModule();
    public List<SModule> showAffectation();
    public void deleteAffectation(SModule sModule);

    List<ProfElementStatsDTO> getProfElementStats();
}
