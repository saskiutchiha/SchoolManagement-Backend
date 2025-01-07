package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.dto.EnregistrerEtudiantDto;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;

import java.util.List;

public interface EtudiantMetier {

    public void addEtudiants(List<Etudiant> etudiants, Long filiereId, Long semestreId);
    public void updateEtudiant(Etudiant etudiant);
    public List<Etudiant> getEtudiants(EnregistrerEtudiantDto enregistrerEtudiantDto);
    public void deleteEtudiant(Etudiant etudiant);
}
