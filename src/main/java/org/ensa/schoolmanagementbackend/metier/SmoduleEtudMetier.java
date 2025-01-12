package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.SModule;
import org.ensa.schoolmanagementbackend.dao.entity.SmoduleEtudiant;
import org.ensa.schoolmanagementbackend.dao.repository.SmoduleEtudRepository;
import org.ensa.schoolmanagementbackend.dao.repository.SmoduleEtudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmoduleEtudMetier {
    @Autowired
    SmoduleEtudRepository smoduleEtud;
    @Autowired
    SModuleMetier sModuleMetier;
    public void affecteEtudiantSmodule(long codemodule, long smcode) {
        Long smodulecode = sModuleMetier.getSmodulescode(codemodule);
        List<SmoduleEtudiant> listsmoduleetud = smoduleEtud.getAllBysModule_Code(smodulecode);
        SModule smodule = new SModule();
        smodule.setCode(smcode);
        for (SmoduleEtudiant smetud : listsmoduleetud){
            SmoduleEtudiant smetudtemp = new SmoduleEtudiant();
            smetudtemp.setSModule(smodule);
            smetudtemp.setEtudiant(smetud.getEtudiant());
            smoduleEtud.save(smetudtemp);
        }
    }
    public List<SmoduleEtudiant> findbySmoduleCode(Long code){
        return smoduleEtud.getAllBysModule_Code(code);
    }

}
