package org.ensa.schoolmanagementbackend.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "s_modules")
@Data
@Getter
@Setter
public class SModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String nemodule;
    private Double coef;
    private Boolean estValide;

    @ManyToOne
    @JoinColumn(name = "module_id")
    @JsonIgnore
    private Module module;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private Prof prof;


    @OneToMany(mappedBy = "sModule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "sModule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SmoduleEtudiant> smodule_etudiant = new ArrayList<>();



    public SModule() {
    }

    public SModule(Long code, String NEmodule, Double coef, Boolean estValide, Module module, Prof prof, List<Note> notes, List<ElemMevaluation> elemMevaluations, List<Etudiant> etudiant) {
        this.code = code;
//        this.NEmodule = NEmodule;
        this.coef = coef;
        this.estValide = estValide;
        this.module = module;
        this.prof = prof;
        this.notes = notes;
        this.elemMevaluations = elemMevaluations;
    }

    public void setCode(Long code) {
        this.code = code;
    }

//    public void setNEmodule(String NEmodule) {
//        this.NEmodule = NEmodule;
//    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public void setEstValide(Boolean estValide) {
        this.estValide = estValide;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void setElemMevaluations(List<ElemMevaluation> elemMevaluations) {
        this.elemMevaluations = elemMevaluations;
    }



    @OneToMany(mappedBy = "sModule", cascade = CascadeType.ALL)
    private List<ElemMevaluation> elemMevaluations = new ArrayList<ElemMevaluation>();

    @OneToMany(mappedBy = "sModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SmoduleEtudiant> smoduleEtudiants = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "etudiant_smodule")
    private List<Etudiant> etudiants;



    public Long getCode() {
        return code;
    }

//    public String getNEmodule() {
//        return NEmodule;
//    }

    public Double getCoef() {
        return coef;
    }

    public Boolean getEstValide() {
        return estValide;
    }

    public Module getModule() {
        return module;
    }

    public Prof getProf() {
        return prof;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<ElemMevaluation> getElemMevaluations() {
        return elemMevaluations;
    }



    public List<SmoduleEtudiant> getSmodule_etudiant() {
        return smodule_etudiant;
    }


    public void setSmodule_etudiant(List<SmoduleEtudiant> smodule_etudiant) {
        this.smodule_etudiant = smodule_etudiant;
    }


}