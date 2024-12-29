package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.ElemMevaluation;
import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;
import org.ensa.schoolmanagementbackend.dao.repository.ElemMevalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElemMevalMetier
{ @Autowired
    ElemMevalRepository elemMevalRepository;
    public Long addElemMeval(ElemMevaluation elemMeval){
        return elemMevalRepository.save( elemMeval ).getId();
    }
    public void deletemodalite(ElemMevaluation elemMeval){
        elemMevalRepository.delete(elemMeval);
    }
    public void modifiermodalite(ElemMevaluation elemMeval){
        elemMevalRepository.save(elemMeval);
    }

}
