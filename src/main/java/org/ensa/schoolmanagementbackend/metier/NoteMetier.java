package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.EtudiantNoteDto;
import org.ensa.schoolmanagementbackend.dao.entity.*;
import org.ensa.schoolmanagementbackend.dao.repository.NoteRepository;
import org.ensa.schoolmanagementbackend.dao.repository.SmoduleEtudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteMetier {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    SmoduleEtudRepository smoduleEtud;
    // Méthode pour récupérer les notes par sModule.id
//    public List<Note> getNotesBySModuleId(Long sModuleId) {
//        return noteRepository.findBySModuleId(sModuleId);
//    }
    public List<EtudiantNoteDto> getEtudiantsWithNotes(Long sModuleId) {
        // 1. Récupérer les notes par sModuleId
        List<Note> notes = noteRepository.findNotesBySModuleId(sModuleId);

        // 2. Créer un Map pour regrouper les notes par étudiant (utiliser l'objet Etudiant comme clé)
        Map<Etudiant, List<Note>> notesByEtudiant = new HashMap<>();
        for (Note note : notes) {
            Etudiant etudiant = note.getEtudiant();
            note.setSModule(null);
            note.setEtudiant(null);
            notesByEtudiant.computeIfAbsent(etudiant, id -> new ArrayList<>()).add(note);
        }

        // 3. Créer une liste d'EtudiantNoteDto
        List<EtudiantNoteDto> etudiantsWithNotes = new ArrayList<>();
        for (Etudiant etudiant : notesByEtudiant.keySet()) {
            // 4. Créer l'objet EtudiantNoteDto
            List<Note> etudiantNotes = notesByEtudiant.get(etudiant);
            EtudiantNoteDto etudiantNoteDto = new EtudiantNoteDto();
            etudiantNoteDto.setId(etudiant.getId());  // Ou tout autre attribut que vous souhaitez récupérer
            etudiantNoteDto.setNom(etudiant.getNom()); // Si vous avez ces attributs dans Etudiant
            etudiantNoteDto.setPrenom(etudiant.getPrenom());  // Pareil ici pour les autres attributs

            etudiantNoteDto.setNotesList(etudiantNotes);

            // 5. Ajouter l'EtudiantNoteDto à la liste
            etudiantsWithNotes.add(etudiantNoteDto);

        }

        return etudiantsWithNotes;
    }
    public void savenotes (List<Note> notes){
        noteRepository.saveAll(notes);
    }
    public Map<Etudiant, Double> calculerMoyenneParEtudiant(SModule sousModule) {
        Map<Etudiant, Double> moyennes = new HashMap<>();

        // Parcourir tous les étudiants
        for (SmoduleEtudiant smE : smoduleEtud.getAllBysModule(sousModule)) {
            double coef = 0;
            double moyenne = 0.0;
            double total_coef  = 0;
            List<Note> lNotes = smE.getEtudiant().getNotes();
            // Parcourir les notes et leurs coefficients
            for (int i = 0; i < lNotes.size(); i++) {
                if (lNotes.get(i).getSModule().getCode() == sousModule.getCode()){
                    List <ElemMevaluation> mevals = sousModule.getElemMevaluations();
                    for (ElemMevaluation meval : mevals) {
                        if (meval.getMEvaluation().getCode() == lNotes.get(i).getMEval().getCode()){
                            coef = meval.getMEvaluation().getCoef();
                            total_coef += coef;
                            break;
                        }
                    }

                    double note = lNotes.get(i).getNote();
                    moyenne += note * coef;
                }
                }

                // Calculer la moyenne pondérée
                Etudiant etud = new Etudiant();
               etud.setId(smE.getEtudiant().getId());
               etud.setNom(smE.getEtudiant().getNom());
               SmoduleEtudiant smetud = smoduleEtud.findBysModuleAndEtudiant(sousModule, etud);

            smetud.setMoyenne((float)(moyenne/total_coef));
            smoduleEtud.save(smetud);
                moyennes.put(etud, moyenne);

        }

        return moyennes;
    }
}
