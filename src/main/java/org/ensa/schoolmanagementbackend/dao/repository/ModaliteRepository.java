package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModaliteRepository extends JpaRepository<MEvaluation,Long> {
}
