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
@Table(name = "profs")
@Data
//@AllArgsConstructor
public class Prof {
    public Prof(Long id, String nom, String prenom, long code, String email, String specialite, String password, List<SModule> sModules) {
        this.nom = nom;
        this.prenom = prenom;
        this.code = code;
        this.email = email;
        this.specialite = specialite;
        this.password = password;
        this.sModules = sModules;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    public void setsModules(List<SModule> sModules) {
        this.sModules = sModules;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.code = id;
    }

    public Prof() {
    }

    private String nom;
    private String prenom;
    private String email;
    private String specialite;
    private String password;

    public Long getId() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public long getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getPassword() {
        return password;
    }

    public List<SModule> getsModules() {
        return sModules;
    }

    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SModule> sModules = new ArrayList<>();
}