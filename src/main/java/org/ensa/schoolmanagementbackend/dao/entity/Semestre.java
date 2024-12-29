package org.ensa.schoolmanagementbackend.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "semestres")
@Data
public class Semestre {
    public Long getCode() {
        return code;
    }

    public Semestre() {
    }

    public Semestre(Long code, String NSemestre, String nom, List<Module> modules) {
        this.code = code;
        this.NSemestre = NSemestre;
        this.nom = nom;
        this.modules = modules;
    }

    public String getNSemestre() {
        return NSemestre;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setNSemestre(String NSemestre) {
        this.NSemestre = NSemestre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public String getNom() {
        return nom;
    }

    public List<Module> getModules() {
        return modules;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String NSemestre;
    private String nom;

    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Module> modules = new ArrayList<Module>();
}