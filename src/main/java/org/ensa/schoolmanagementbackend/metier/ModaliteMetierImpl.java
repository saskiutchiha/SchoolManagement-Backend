package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;
import org.ensa.schoolmanagementbackend.dao.repository.MEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ModaliteMetierImpl implements ModaliteMetier {

    @Autowired
    private MEvaluationRepository modaliteRepository;

    @Override
    public List<MEvaluation> getModalites() {
        return modaliteRepository.findAll();
    }

    @Override
    public void addModalite(MEvaluation modalite) {
        modaliteRepository.save(modalite);
    }

    @Override
    public void modifyModalite(MEvaluation modalite) {
        modaliteRepository.save(modalite);
    }

    @Override
    public void deleteModalite(Long id) {
        modaliteRepository.deleteById(id);
    }
}