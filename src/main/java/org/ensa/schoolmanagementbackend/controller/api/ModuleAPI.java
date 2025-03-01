package org.ensa.schoolmanagementbackend.controller.api;
import org.ensa.schoolmanagementbackend.dao.dto.ElemMevaluDto;
import org.ensa.schoolmanagementbackend.dao.dto.SModuleDtO;
import org.ensa.schoolmanagementbackend.dao.entity.*;

import org.ensa.schoolmanagementbackend.dao.entity.Module;
import org.ensa.schoolmanagementbackend.dao.impl.ModuleImpl;
import org.ensa.schoolmanagementbackend.metier.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/module")
@CrossOrigin(origins = "http://localhost:5173")
public class ModuleAPI {
    @Autowired
    ModuleMetierImpl module;
    @Autowired
    SModuleMetier smoduleMetier;
    @Autowired
    ElemMevalMetier elemMevalMetier;
    @Autowired
    private ModuleMetierImpl moduleMetierImpl;
    @Autowired
    SmoduleEtudMetier smoduleEtudMetier;
    @Autowired
    MEvaluationMetier mevaluationMetier;
    @Autowired
    NoteMetier noteMetier;
    @GetMapping("/getmodules")
    public List<Module> getModules(){
    return module.getModules();
    }
    @PostMapping("/addmodule")
    public void addModule(@RequestBody Module m){
        module.addModule(m);
//        System.out.println(m);
    }
    @PostMapping("/addSmodule")
    public ResponseEntity<Long> addSModule(@RequestBody SModuleDtO smdto){
//        smoduleMetier.addSmodule(sm);
         SModule sm = new SModule();
         sm.setProf(smdto.getProf());
         sm.setCoef(smdto.getCoef());
         sm.setModule(smdto.getModule());
         sm.setNEmodule(smdto.getNemodule());
        System.out.println(sm);
        Long code  = smoduleMetier.addSmodule(sm);
        smoduleEtudMetier.affecteEtudiantSmodule(smdto.getModule().getCode(), code);
        return ResponseEntity.ok(code);
    }
    @PostMapping("/addmodlitedelem")
    public ResponseEntity<Long> addmodliledelem(@RequestBody ElemMevaluDto emdto){
        List<SmoduleEtudiant> listsmetud = smoduleEtudMetier.findbySmoduleCode(emdto.getSmodule().getCode());
        List<Note> lnotes = new ArrayList<>();
        for (SmoduleEtudiant smEtud : listsmetud) {
            Note note = new Note();
            note.setMEval(emdto.getMeval());
            note.setSModule(emdto.getSmodule()); // Setting the SModule from emdto
            note.setEtudiant(smEtud.getEtudiant()); // Linking the student from the current iteration
             // Default grade, you can adjust this value
            note.setEstAbsent(false); // Default presence status
            lnotes.add(note);
        }
        noteMetier.savenotes(lnotes);
        ElemMevaluation em = new ElemMevaluation();
        em.setSModule(emdto.getSmodule());
        em.setCoef(emdto.getCoef());
        em.setMEvaluation(emdto.getMeval());
        return ResponseEntity.ok(elemMevalMetier.addElemMeval(em));
    }
    @PostMapping("/modifiermodule")
    public void modifiermodule(@RequestBody Module m){
        module.modifyModule(m);
    }
    @PostMapping("/modifier")
    public void modifier(@RequestBody SModuleDtO smdto){
        SModule sm = new SModule();
        sm.setCode(smdto.getCode());
        sm.setProf(smdto.getProf());
        sm.setCoef(smdto.getCoef());
        sm.setModule(smdto.getModule());
        sm.setNEmodule(smdto.getNemodule());
        smoduleMetier.modifier(sm);
    }
    @PostMapping("deletemodalite")
    public void deleteModule(@RequestBody ElemMevaluation elmme){
        elemMevalMetier.deletemodalite( elmme);
    }
    @PostMapping("/modifiermodlitedelem")
    public void modifiermodliledelem(@RequestBody ElemMevaluDto emdto){
        ElemMevaluation em = new ElemMevaluation();
        em.setSModule(emdto.getSmodule());
        em.setId(emdto.getId());
        em.setCoef(emdto.getCoef());
        em.setMEvaluation(emdto.getMeval());
        elemMevalMetier.modifiermodalite(em);
    }
    @PostMapping("/deletesmodule")
    public void deletesmodule(@RequestBody SModule sm){
        sm = smoduleMetier.getSmodule(sm.getCode());
        smoduleMetier.deletesmodule(sm);
    }
    @PostMapping("/deletemodule")
    public void deletemodule(@RequestBody Module m){
        System.out.println(m);
        Module m1 = moduleMetierImpl.getModule(m.getCode());
        moduleMetierImpl.deleteModule(m1);

    }
    @GetMapping("/getmodulesbyprof/{profid}")
    public List<SModule> getModuleByProfid(@PathVariable Long profid){
        return smoduleMetier.getSModuleByProf(profid);
    }
    @GetMapping("/Modalite")
    public List<MEvaluation> getModalite(){
        return mevaluationMetier.getmodalite();
    }
}
