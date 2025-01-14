package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FiliereStatsDTO {
    private Long filiereId;
    private String nomFiliere;
    private String description;
    private long studentCount;
    private long moduleCount;
}