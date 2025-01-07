package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SmoduleRepository extends JpaRepository<SModule,Long> {

    List<SModule> findByModuleCode(Long moduleId);

    @Query("SELECT sm FROM SModule sm WHERE sm.prof IS NULL")
    List<SModule> smoduleDispo();

    @Query("SELECT sm FROM SModule sm WHERE sm.prof IS NOT NULL")
    List<SModule> smoduleAffected();

    @Modifying
    @Transactional
    @Query("UPDATE SModule sm SET sm.prof = NULL WHERE sm = :smodule")
    void deleteProfAffectation(SModule smodule);
}