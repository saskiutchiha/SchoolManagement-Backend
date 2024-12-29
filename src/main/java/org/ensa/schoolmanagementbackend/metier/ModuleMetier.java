package org.ensa.schoolmanagementbackend.metier;
import  org.ensa.schoolmanagementbackend.dao.entity.Module;

import java.util.List;

public interface ModuleMetier {
    public List<Module> getModules();
    public void deleteModule(Module module);
    public void modifyModule(Module module);

}
