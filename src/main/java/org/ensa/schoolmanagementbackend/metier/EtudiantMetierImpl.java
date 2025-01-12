package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.EnregistrerEtudiantDto;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;
import org.ensa.schoolmanagementbackend.dao.entity.Module;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.entity.SmoduleEtudiant;
import org.ensa.schoolmanagementbackend.dao.repository.EtudiantRepository;
import org.ensa.schoolmanagementbackend.dao.repository.ModuleRepository;
import org.ensa.schoolmanagementbackend.dao.repository.SmoduleEtudiantRepository;
import org.ensa.schoolmanagementbackend.dao.repository.SModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantMetierImpl implements EtudiantMetier {


    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private SModuleRepository sModuleRepository;

    @Autowired
    private SmoduleEtudiantRepository smoduleEtudiantRepository;

    @Override
    public void addEtudiants(List<Etudiant> etudiants, Long filiereId, Long semestreId) {
        List<Module> modules = moduleRepository.findByFiliereCodeAndSemestreCode(filiereId, semestreId);
        if (modules.isEmpty()) {
            throw new RuntimeException("No modules found for the given filiere and semestre");
        }
        List<Etudiant> savedEtudiants = new ArrayList<>();

        for (Etudiant etudiant : etudiants) {
            Etudiant savedEtudiant = etudiantRepository.save(etudiant);
            savedEtudiants.add(savedEtudiant);
        }
        for (Module module : modules) {
            List<SModule> sModules = sModuleRepository.findByModuleCode(module.getCode());
            for (SModule sModule : sModules) {
                for(Etudiant savedEtudiant: savedEtudiants)
                {
                    SmoduleEtudiant smoduleEtudiant = new SmoduleEtudiant();
                    smoduleEtudiant.setEtudiant(savedEtudiant);
                    smoduleEtudiant.setSModule(sModule);
                    smoduleEtudiantRepository.save(smoduleEtudiant);
                }
            }
        }
    }

    @Override
    public void updateEtudiant(Etudiant etudiant) {
        Etudiant managedEtudiant = etudiantRepository.findById(etudiant.getId())
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));
        managedEtudiant.setNom(etudiant.getNom());
        managedEtudiant.setPrenom(etudiant.getPrenom());
        etudiantRepository.save(managedEtudiant);
    }

    @Override
    public List<Etudiant> getEtudiants(EnregistrerEtudiantDto enregistrerEtudiantDto) {

        try {
            List<Module> modules = moduleRepository.findByFiliereCodeAndSemestreCode(enregistrerEtudiantDto.getFilieredto().getFiliereId(), enregistrerEtudiantDto.getSemestre().getCode());


            List<SModule> sModules = sModuleRepository.findByModuleCode(modules.getFirst().getCode());


            List<SmoduleEtudiant> smoduleEtudiants = smoduleEtudiantRepository.findBysModule_Code(sModules.getFirst().getCode());

            List<Etudiant> etudiants = new ArrayList<>();

            for (SmoduleEtudiant smoduleEtudiant : smoduleEtudiants) {
                etudiants.add(smoduleEtudiant.getEtudiant());
            }


            return etudiants;
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        Etudiant managedEtudiant = etudiantRepository.findById(etudiant.getId())
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));
        etudiantRepository.delete(managedEtudiant);
    }
}