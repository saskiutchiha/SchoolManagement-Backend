package org.ensa.schoolmanagementbackend.dao.impl;

import org.ensa.schoolmanagementbackend.dao.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import  org.ensa.schoolmanagementbackend.dao.entity.Module;
import java.util.List;

@Repository
public class ModuleImpl {
    @Autowired
    ModuleRepository moduleRepository;
    public List<Module> getModules(){

        return moduleRepository.findAll();
    }
}
