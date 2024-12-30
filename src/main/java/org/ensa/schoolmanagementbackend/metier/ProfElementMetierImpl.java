package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.repository.ProfRepository;
import org.ensa.schoolmanagementbackend.dao.repository.SmoduleRepository;
import org.ensa.schoolmanagementbackend.dao.dto.ProfDispoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfElementMetierImpl implements  ProfElementMetier {

    @Autowired
    private SmoduleRepository smoduleRepository;

    @Autowired
    private ProfRepository profRepository;

    @Override
    public void affect(Prof professeur, SModule smodule) {
        smodule.setProf(professeur);
        smoduleRepository.save(smodule);
    }

    @Override
    public List<ProfDispoDTO> disponibleProf() {
        List<Prof> profs = profRepository.findAll();  // Get the Prof entities
        List<ProfDispoDTO> profDispoDTOs = new ArrayList<>();

        // Map each Prof entity to ProfDispoDTO
        for (Prof prof : profs) {
            ProfDispoDTO dto = new ProfDispoDTO();
            dto.setCode(prof.getCode());
            dto.setNameProf(prof.getNom());
            profDispoDTOs.add(dto);
        }

        return profDispoDTOs;
    }

    @Override
    public List<SModule> disponibleSModule() {
        return smoduleRepository.smoduleDispo();
    }
}
