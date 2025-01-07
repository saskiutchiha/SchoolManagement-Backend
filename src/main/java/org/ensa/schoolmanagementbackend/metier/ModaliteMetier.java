package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;

import java.util.List;

public interface ModaliteMetier {
    List<MEvaluation> getModalites();
    void addModalite(MEvaluation modalite);
    void modifyModalite(MEvaluation modalite);
    void deleteModalite(Long id);
}