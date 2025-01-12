package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;
import org.ensa.schoolmanagementbackend.dao.repository.ModaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MEvaluationMetier {
    @Autowired
    ModaliteRepository modaliteRepository;
    public List<MEvaluation> getmodalite(){
      return  modaliteRepository.findAll();
    }
}
