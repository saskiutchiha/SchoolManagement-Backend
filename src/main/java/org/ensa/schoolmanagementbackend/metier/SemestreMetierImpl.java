package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Semestre;
import org.ensa.schoolmanagementbackend.dao.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SemestreMetierImpl implements SemestreMetier {

    @Autowired
    private SemestreRepository semestreRepository;

    public List<Semestre> getsemestres() {
        return semestreRepository.findAll();
    }
}
