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


    public double getCoef() {
        return coef;
    }

    public MEvaluation getMeval() {
        return meval;
    }

    public SModule getSmodule() {
        return smodule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSmodule(SModule smodule) {
        this.smodule = smodule;
    }

    public void setMeval(MEvaluation meval) {
        this.meval = meval;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }
}
