package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
