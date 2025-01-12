package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.dto.EtudiantNoteDto;
import org.ensa.schoolmanagementbackend.dao.dto.EvaluationStatisticsDTO;
import org.ensa.schoolmanagementbackend.dao.dto.NoteDto;
import org.ensa.schoolmanagementbackend.dao.dto.SmoduleStatsinfoDto;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;
import org.ensa.schoolmanagementbackend.dao.entity.Note;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.entity.SmoduleEtudiant;
import org.ensa.schoolmanagementbackend.metier.NoteMetier;
import org.ensa.schoolmanagementbackend.metier.SModuleMetier;
import org.ensa.schoolmanagementbackend.metier.SmoduleEtudMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profvision")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfSmoduleVisionAPI {
    @Autowired
    SmoduleEtudMetier SmetudMetier;
    @Autowired
    SModuleMetier SmoduleMetier;
    @GetMapping("getmoyeenes/{smoduleid}")
public List<SmoduleEtudiant> getmoyennes(@PathVariable Long smoduleid){
        List<SmoduleEtudiant> listmouennes =  SmetudMetier.findbySmoduleCode(smoduleid);
        // Set the sModule property to null for each item
        for (SmoduleEtudiant smoduleEtudiant : listmouennes) {
            smoduleEtudiant.setSModule(null);
        }
        return listmouennes;
}
    @GetMapping("/statistics/{codeModule}")
    public ResponseEntity<List<SmoduleStatsinfoDto>> getEvaluationStatistics(
            @PathVariable Long codeModule) {
        List<SmoduleStatsinfoDto> statistics = SmoduleMetier.getEvaluationStatistics(codeModule);
        return ResponseEntity.ok(statistics);
    }
    @GetMapping("/statisticsintervale/{codeModule}")
    public List<EvaluationStatisticsDTO> getEvaluationStatisticsByIntervales(@PathVariable Long codeModule) {
        return SmoduleMetier.getEvaluationStatisticsByIntervales(codeModule);
    }
}
