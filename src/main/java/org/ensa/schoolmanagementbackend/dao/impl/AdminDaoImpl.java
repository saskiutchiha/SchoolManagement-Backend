package org.ensa.schoolmanagementbackend.dao.impl;

import org.ensa.schoolmanagementbackend.dao.entity.Admin;
import org.ensa.schoolmanagementbackend.dao.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDaoImpl{

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

}
