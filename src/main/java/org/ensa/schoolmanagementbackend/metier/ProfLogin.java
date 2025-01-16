package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.impl.ProfImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfLogin {

    @Autowired
    private ProfImpl profimpl;

    // Méthode pour vérifier si le professeur existe dans la base de données
    public boolean verifierProfesseur(Prof prof) {
        // Recherche du professeur par son email ou un autre identifiant unique
        Prof professeurExistant = profimpl.findbymail(prof);

        if (professeurExistant != null && professeurExistant.getPassword().equals(prof.getPassword())) {
            return true; // Professeur vérifié
        }

        return false; // Professeur non trouvé ou mot de passe incorrect
    }
}
