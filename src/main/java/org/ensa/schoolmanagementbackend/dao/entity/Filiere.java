package org.ensa.schoolmanagementbackend.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filieres")
@Data

public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    public Filiere() {
    }

    public Filiere(Long code, String NFiliere, String nom_filiere, String discription, List<Module> modules) {
        this.code = code;
//        this.NFiliere = NFiliere;
        this.nom_filiere = nom_filiere;
        this.discription = discription;
        this.modules = modules;
    }

    private String nom_filiere;

    public void setCode(Long code) {
        this.code = code;
    }

//    public void setNFiliere(String NFiliere) {
//        this.NFiliere = NFiliere;
//    }

    public void setNom_filiere(String nom_filiere) {
        this.nom_filiere = nom_filiere;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Long getCode() {
        return code;
    }

//    public String getNFiliere() {
//        return NFiliere;
//    }

    public String getNom_filiere() {
        return nom_filiere;
    }

    public String getDiscription() {
        return discription;
    }

    public List<Module> getModules() {
        return modules;
    }

    private String discription;

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Module> modules = new ArrayList<Module>();
}