package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModuleStatsDTO {
    private Long moduleId;
    private String nomModule;
    private long moyenne;
}
