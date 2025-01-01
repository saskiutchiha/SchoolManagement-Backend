package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.*;
import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfSModuleDTO {
    private Prof professeur;
    private SModuleDtO smodule;
}