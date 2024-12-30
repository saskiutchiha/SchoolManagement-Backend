package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmoduleRepository extends JpaRepository<SModule,Long> {

    @Query("SELECT sm FROM SModule sm WHERE sm.prof IS NULL")
    List<SModule> smoduleDispo();
}