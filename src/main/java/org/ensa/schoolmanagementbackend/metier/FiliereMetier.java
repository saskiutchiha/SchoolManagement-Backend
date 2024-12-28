package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Filiere;
import org.ensa.schoolmanagementbackend.dto.FiliereDTO;

import java.util.List;

public interface FiliereMetier {
    public List<FiliereDTO> getFilieres();
    public void addFiliere(Filiere filiere);
    public void updateFiliere(Filiere filiere);
    public void deleteFiliere(Filiere filiere);

}
