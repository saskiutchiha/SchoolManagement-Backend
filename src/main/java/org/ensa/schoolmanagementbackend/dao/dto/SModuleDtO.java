package org.ensa.schoolmanagementbackend.dao.dto;
import  org.ensa.schoolmanagementbackend.dao.entity.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ensa.schoolmanagementbackend.dao.entity.Prof;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SModuleDtO {
    private String nemodule;
    private Module module;
    private Prof prof;
    private double coef;
    private long code ;

    // Getters et Setters
}
