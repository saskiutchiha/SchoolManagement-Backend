package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.*;
import org.ensa.schoolmanagementbackend.dao.entity.Prof;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfElementStatsDTO {

    public Prof professeur;
    public long nombreSModule;
}
