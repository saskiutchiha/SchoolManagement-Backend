package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Filiere;
import org.ensa.schoolmanagementbackend.dao.impl.FiliereDaoImpl;
import org.ensa.schoolmanagementbackend.dao.impl.SmoduleEtudiantImpl;
import org.ensa.schoolmanagementbackend.dto.FiliereDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereMetierImpl implements FiliereMetier {

    @Autowired
    private FiliereDaoImpl filiereDao;

    @Autowired
    private SmoduleEtudiantImpl smoduleEtudiantImpl;

    @Override
    public List<FiliereDTO> getFilieres() {
        List<Filiere> filieres = filiereDao.getFilieres();

        return filieres.stream()
                .map(filiere -> {
                    long studentCount = smoduleEtudiantImpl.countEtudiantsByFiliereId(filiere.getId());
                    return new FiliereDTO(filiere.getId(),filiere.getNom_filiere(), filiere.getDiscription(), studentCount);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addFiliere(Filiere filiere) {
        filiereDao.addFiliere(filiere);
    }

    @Override
    public void updateFiliere(Filiere filiere) {
        filiereDao.updateFiliere(filiere);
    }

    @Override
    public void deleteFiliere(Filiere filiere) {
        filiereDao.deleteFiliere(filiere);
    }
}
