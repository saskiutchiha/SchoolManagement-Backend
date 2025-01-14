package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.EvaluationStatisticsDTO;
import org.ensa.schoolmanagementbackend.dao.dto.SmoduleStatsinfoDto;
import org.ensa.schoolmanagementbackend.dao.entity.Module;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.repository.SModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SModuleMetier
{ @Autowired
    SModuleRepository sModuleRepository;
    public Long addSmodule(SModule sModule){
        return sModuleRepository.save(sModule).getCode();
    }
    public void modifier(SModule sModule){
        sModuleRepository.save(sModule);
    }
    public void deletesmodule(SModule sModule){
        sModuleRepository.delete(sModule);
    }
    public SModule getSmodule(Long code){
        return sModuleRepository.getOne(code);
    }
    public List<SModule> getSModuleByProf(Long profid) {
        List<SModule> smodules = sModuleRepository.findByProf_Code(profid);
        for (SModule sModule : smodules) {
            // Keep only the code and NEmodule, set other fields to null
            sModule.setCoef(null);
            sModule.setModule(null);
            sModule.setProf(null);
            sModule.setNotes(null);
            sModule.setElemMevaluations(null);
            sModule.setSmodule_etudiant(null);
        }
        return smodules;
    }
    public Long getSmodulescode(Long modulecode){
         return sModuleRepository.getAllByModule_Code(modulecode).getFirst().getCode();
    }
    public void validermodule(Long code){
        SModule sm = sModuleRepository.getById(code);
        sm.setEstValide(true);
        sModuleRepository.save(sm);
    }
    public List<SmoduleStatsinfoDto> getEvaluationStatistics(Long codeModule) {
        List<Object[]> results = sModuleRepository.getEvaluationStatisticsByModuleCode(codeModule);
        return results.stream()
                .map(row -> new SmoduleStatsinfoDto(
                        (String) row[0],                  // type
                        (Double) row[1],                 // average
                        (Double) row[2],                 // median
                        (Double) row[3],                 // standardDeviation
                        (Double) row[4],                 // minGrade
                        (Double) row[5] ,
                        ((BigDecimal) row[6]).doubleValue()   // maxGrade
                                          // weight
                ))
                .collect(Collectors.toList());
    }
    public List<EvaluationStatisticsDTO> getEvaluationStatisticsByIntervales(Long codeModule) {
        return sModuleRepository.getEvaluationStatisticsByintervales(codeModule);
    }
}
