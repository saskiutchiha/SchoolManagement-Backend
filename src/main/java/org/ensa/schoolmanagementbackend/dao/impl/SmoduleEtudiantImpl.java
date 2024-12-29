package org.ensa.schoolmanagementbackend.dao.impl;

import org.ensa.schoolmanagementbackend.dao.repository.ProfRepository;
import org.ensa.schoolmanagementbackend.dao.repository.SmoduleEtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class SmoduleEtudiantImpl {


    @Autowired
    private SmoduleEtudiantRepository smoduleEtudiantRepository;


    public long countEtudiantsByFiliereId(Long filiereId){
        return smoduleEtudiantRepository.countEtudiantsByFiliereId(filiereId);
    };

}
