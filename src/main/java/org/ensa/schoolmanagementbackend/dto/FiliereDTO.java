package org.ensa.schoolmanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiliereDTO {
    private Long filiereId;
    private String nomFiliere;
    private String description;
    private long studentCount;
}