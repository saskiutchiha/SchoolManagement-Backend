package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.SmoduleEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmoduleEtudiantRepository extends JpaRepository<SmoduleEtudiant, Long> {

    List<SmoduleEtudiant> findBysModule_Code(Long code);

    @Query("SELECT COUNT(se.etudiant.id) " +
            "FROM SmoduleEtudiant se " +
            "WHERE se.sModule.code IN (" +
            "  SELECT sm.code FROM SModule sm WHERE sm.module.code IN (" +
            "    SELECT m.code FROM Module m WHERE m.filiere.code = :filiereId" +
            "  )" +
            ")")
    long countEtudiantsByFiliereId(@Param("filiereId") Long filiereId);
}
