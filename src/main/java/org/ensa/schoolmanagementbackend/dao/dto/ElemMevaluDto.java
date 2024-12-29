package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;
import org.ensa.schoolmanagementbackend.dao.entity.SModule;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElemMevaluDto {
    private long id;
    private SModule smodule;
    private MEvaluation meval;
    private double coef;
}
