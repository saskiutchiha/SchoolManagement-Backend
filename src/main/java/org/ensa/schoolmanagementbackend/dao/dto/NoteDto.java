package org.ensa.schoolmanagementbackend.dao.dto;

import jakarta.persistence.*;
import lombok.*;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;
import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {

    private Long id;

    private Double note;
    private Boolean estAbsent;
    private Etudiant etudiant;

    private SModule smodule;

    private MEvaluation meval;
}
