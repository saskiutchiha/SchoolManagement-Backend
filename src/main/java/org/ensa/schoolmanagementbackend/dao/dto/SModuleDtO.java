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

    public String getNemodule() {
        return nemodule;
    }

    public Module getModule() {
        return module;
    }

    public Prof getProf() {
        return prof;
    }

    public double getCoef() {
        return coef;
    }

    public long getCode() {
        return code;
    }

    public void setNemodule(String nemodule) {
        this.nemodule = nemodule;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setCode(long code) {
        this.code = code;
    }

    // Getters et Setters
}
