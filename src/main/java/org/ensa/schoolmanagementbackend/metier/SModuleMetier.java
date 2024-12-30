package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.repository.SmoduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SModuleMetier
{ @Autowired
    SmoduleRepository sModuleRepository;
    public Long addSmodule(SModule sModule){
        return sModuleRepository.save(sModule).getCode();
    }
    public void modifier(SModule sModule){
        sModuleRepository.save(sModule);
    }
    public void deletesmodule(SModule sModule){
        sModuleRepository.delete(sModule);
    }
    public SModule getSmodule(Long code){
        return sModuleRepository.getOne(code);
    }

}
