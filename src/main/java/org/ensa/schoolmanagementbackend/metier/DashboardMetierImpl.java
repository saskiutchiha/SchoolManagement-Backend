package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.FiliereStatsDTO;
import org.ensa.schoolmanagementbackend.dao.dto.ModuleStatsDTO;
import org.ensa.schoolmanagementbackend.dao.entity.Filiere;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.entity.SmoduleEtudiant;
import org.ensa.schoolmanagementbackend.dao.impl.FiliereDaoImpl;
import org.ensa.schoolmanagementbackend.dao.impl.SmoduleEtudiantImpl;
import org.ensa.schoolmanagementbackend.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ensa.schoolmanagementbackend.dao.entity.Module;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardMetierImpl implements DashboardMetier{


    @Autowired
    private SmoduleEtudiantImpl smoduleEtudiantImpl;

    @Autowired
    private FiliereDaoImpl filiereDao;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private SmoduleEtudiantRepository smoduleEtudiantRepository;

    @Autowired
    private ProfRepository profRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    @Override
    public List<FiliereStatsDTO> getFiliereStats() {
        List<Filiere> filieres = filiereDao.getFilieres();

        return filieres.stream()
                .map(filiere -> {
                    long studentCount = smoduleEtudiantImpl.countEtudiantsByFiliereId(filiere.getCode());
                    long moduleCount = filiere.getModules().size();
                    return new FiliereStatsDTO(filiere.getCode(),filiere.getNom_filiere(), filiere.getDiscription(), studentCount,moduleCount);
                })
                .collect(Collectors.toList());
    }

    private double calculateModuleAverage(Module module) {
        List<Double> subModuleAverages = new ArrayList<>();

        // For each sub-module, calculate its average
        for (SModule sModule : module.getsModules()) {
            List<SmoduleEtudiant> smoduleEtudiants =
                    smoduleEtudiantRepository.findBysModule_Code(sModule.getCode());

            double subModuleAverage = smoduleEtudiants.stream()
                    .mapToDouble(SmoduleEtudiant::getMoyenne)
                    .average()
                    .orElse(0.0);

            subModuleAverages.add(subModuleAverage);
        }

        // Calculate module average from sub-module averages
        return subModuleAverages.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
    @Override
    public List<ModuleStatsDTO> bestAndWorstModules() {

        List<Module> modules = moduleRepository.findAll();

        // Calculate averages and create DTOs
        List<ModuleStatsDTO> moduleStats = new ArrayList<>();

        for (Module module : modules) {
            double moduleAverage = calculateModuleAverage(module);

            ModuleStatsDTO statsDTO = new ModuleStatsDTO(
                    module.getCode(),
                    module.getNom(),
                    Math.round(moduleAverage)  // Converting to long as per DTO
            );

            moduleStats.add(statsDTO);
        }

        // Sort by average
        List<ModuleStatsDTO> sortedStats = moduleStats.stream()
                .sorted(Comparator.comparing(ModuleStatsDTO::getMoyenne))
                .toList();

        // Get top 5 and bottom 5
        List<ModuleStatsDTO> result = new ArrayList<>();

        // Add top 5
        result.addAll(sortedStats.stream()
                .sorted(Comparator.comparing(ModuleStatsDTO::getMoyenne).reversed())
                .limit(5)
                .toList());

        // Add bottom 5
        result.addAll(sortedStats.stream()
                .limit(5)
                .toList());

        return result;
    }

    @Override
    public long getProfCount() {
        return profRepository.count();
    }

    @Override
    public long getEtudiantCount() {
        return etudiantRepository.count();
    }

    @Override
    public long getModuleCount() {
        return moduleRepository.count();
    }

    @Override
    public long getFiliereCount() {
        return filiereRepository.count();
    }


}
