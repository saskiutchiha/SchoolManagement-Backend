package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.ProfElementStatsDTO;
import org.ensa.schoolmanagementbackend.dao.dto.SModuleDtO;
import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.repository.ProfRepository;
import org.ensa.schoolmanagementbackend.dao.repository.SModuleRepository;
import org.ensa.schoolmanagementbackend.dao.dto.ProfDispoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfElementMetierImpl implements  ProfElementMetier {

    @Autowired
    private SModuleRepository smoduleRepository;

    @Autowired
    private ProfRepository profRepository;

    @Override
    public void affect(Prof professeur, SModuleDtO smoduleDto) {
        SModule sModule = smoduleRepository.findById(smoduleDto.getCode())
                .orElseThrow();

        System.out.println(sModule.getModule().getNom());

        sModule.setProf(professeur);

        smoduleRepository.save(sModule);
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

    @Override
    public List<SModule> showAffectation() {
        return smoduleRepository.smoduleAffected();
    }

    @Override
    public void deleteAffectation(SModule sModule) {
        smoduleRepository.deleteProfAffectation(sModule);
    }


    @Override
    public List<ProfElementStatsDTO> getProfElementStats() {
        List<Prof> profs = profRepository.findAll();

        return profs.stream()
                .map(prof -> {
                    long nombreSModule = smoduleRepository.countByProf(prof);
                    return new ProfElementStatsDTO(prof, nombreSModule);
                })
                .collect(Collectors.toList());
    }
}
