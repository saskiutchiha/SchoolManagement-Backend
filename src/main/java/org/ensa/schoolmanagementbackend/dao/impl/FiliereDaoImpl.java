package org.ensa.schoolmanagementbackend.dao.impl;

import org.ensa.schoolmanagementbackend.dao.entity.Filiere;
import org.ensa.schoolmanagementbackend.dao.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FiliereDaoImpl {

    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> getFilieres() {
        return filiereRepository.findAll();
    }

    public void addFiliere(Filiere filiere) {
        filiereRepository.save(filiere);
    }

    public void updateFiliere(Filiere filiere) {
        filiereRepository.save(filiere);
    }

    public void deleteFiliere(Filiere filiere) {
        filiereRepository.delete(filiere);
    }
}
