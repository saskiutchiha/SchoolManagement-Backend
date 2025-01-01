package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfRepository extends JpaRepository<Prof,Long> {

//    @Query("Select pr from Prof pr Where pr.code NOT IN (SELECT sm.prof.code FROM SModule sm WHERE sm.prof IS NOT NULL)")
//    List<Prof> profDispo();

}
