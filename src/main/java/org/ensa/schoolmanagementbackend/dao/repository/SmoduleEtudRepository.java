package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.entity.SmoduleEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SmoduleEtudRepository extends JpaRepository<SmoduleEtudiant, Long> {
    List<SmoduleEtudiant> getAllBysModule_Code(Long sModuleCode);

    List<SmoduleEtudiant> getAllBysModule(SModule sModule);


    SmoduleEtudiant findBysModuleAndEtudiant(SModule sModule, Etudiant etudiant);

}
