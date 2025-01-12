package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.impl.ModuleImpl;
import org.ensa.schoolmanagementbackend.dao.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import  org.ensa.schoolmanagementbackend.dao.entity.Module;
import  org.ensa.schoolmanagementbackend.dao.entity.SModule;
import java.util.List;
@Component
public class ModuleMetierImpl implements ModuleMetier {
    @Autowired
    ModuleImpl module;
    @Autowired
    ModuleRepository moduleRepository;
    @Override

    public List<Module> getModules() {
        List<Module> modules = module.getModules();
        for (Module module : modules) {
            for (SModule sModule : module.getsModules()) {


                    sModule.setProf(null);
            }
        }
        return modules;
    }

    @Override
    public void deleteModule(Module module) {
        moduleRepository.delete(module);
    }

    @Override
    public void modifyModule(Module module) {
        moduleRepository.save(module);
    }

    public void addModule(Module module) {
        moduleRepository.save(module);
    }
    public Module getModule(Long code) {
        return moduleRepository.getById(code);
    }

}
