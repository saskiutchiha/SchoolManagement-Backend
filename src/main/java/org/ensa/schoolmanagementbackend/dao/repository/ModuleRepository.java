package org.ensa.schoolmanagementbackend.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  org.ensa.schoolmanagementbackend.dao.entity.Module;
@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
