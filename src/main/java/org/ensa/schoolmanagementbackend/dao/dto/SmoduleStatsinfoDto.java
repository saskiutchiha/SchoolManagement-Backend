package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmoduleStatsinfoDto {
        private String type;
        private Double average;
        private Double standardDeviation;
        private Double minGrade;
        private Double maxGrade;
        private Double weight;
        private Double percentageAbove12;

}
