package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.*;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EtudiantDto {
    Etudiant etudiant;
}
