package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationStatisticsDTO {
    private String type;

    private BigDecimal type10_11;
    private BigDecimal type11_12;
    private BigDecimal type12_13;
    private BigDecimal type13_14;
    private BigDecimal type14_15;
    private BigDecimal type15_16;
    private BigDecimal type16_17;
    private BigDecimal type17_18;
    private BigDecimal type18_19;
    private BigDecimal type19_20;

    // Getters and Setters

}
