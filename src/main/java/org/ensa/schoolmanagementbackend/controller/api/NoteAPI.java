package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.dto.EtudiantNoteDto;
import org.ensa.schoolmanagementbackend.dao.dto.NoteDto;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;
import org.ensa.schoolmanagementbackend.dao.entity.Note;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.metier.NoteMetier;
import org.ensa.schoolmanagementbackend.metier.SModuleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/note")
@CrossOrigin(origins = "http://localhost:5173")
public class NoteAPI
{
    @Autowired
    SModuleMetier moduleMetier;
    @Autowired
    NoteMetier noteMetier;
    @Autowired
    SModuleMetier sModuleMetier;
    @GetMapping("getetudiantnotes/{smoduleid}")
    public List<EtudiantNoteDto> getEtudiantNotes(@PathVariable Long smoduleid){

        return noteMetier.getEtudiantsWithNotes(smoduleid);
    }
    @PostMapping("savenotes")
    public void  savenotesNotes( @RequestBody  List<NoteDto> notesdto){
        List<Note> notes = new ArrayList<>();

        for (NoteDto noteDto : notesdto) {
            // Création d'un objet Note
            Note note = new Note();

            // Utilisation des setters pour associer les valeurs de NoteDto à Note
            note.setId(noteDto.getId());
            note.setNote(noteDto.getNote());
            note.setEstAbsent(noteDto.getEstAbsent());
            note.setEtudiant(noteDto.getEtudiant());  // Set l'objet Etudiant
            note.setSModule(noteDto.getSmodule());    // Set l'objet SModule
            note.setMEval(noteDto.getMeval());        // Set l'objet MEvaluation

            // Ajouter l'objet Note à la liste
            notes.add(note);


        }
        System.out.println("lllllllll");
        System.out.println(notes);
       noteMetier.savenotes(notes);
    }
    @GetMapping("calcuelmoyenne/{smoduleid}")
    public Map<Etudiant, Double> getmoyenne(@PathVariable Long smoduleid){
        SModule sm = moduleMetier.getSmodule(smoduleid);
        return noteMetier.calculerMoyenneParEtudiant(sm);
    }
    @GetMapping("modulevalider/{smoduleid}")
    public void validerModule(@PathVariable Long smoduleid){
        sModuleMetier.validermodule(smoduleid);
        SModule sm = moduleMetier.getSmodule(smoduleid);
        noteMetier.calculerMoyenneParEtudiant(sm);
    }

}
