package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ensa.schoolmanagementbackend.dao.entity.Filiere;
import org.ensa.schoolmanagementbackend.dao.entity.Semestre;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnregistrerEtudiantDto {
    private Semestre semestre;
    private FiliereDTO filieredto;
}
