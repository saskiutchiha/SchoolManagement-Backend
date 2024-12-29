package org.ensa.schoolmanagementbackend.dao.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modules")
@Data

public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    public Module() {
    }

    public Module(Long code, String NModule, String nom, Filiere filiere, Semestre semestre, List<SModule> sModules) {
        this.code = code;
        this.NModule = NModule;
        this.nom = nom;
        this.filiere = filiere;
        this.semestre = semestre;
        this.sModules = sModules;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setNModule(String NModule) {
        this.NModule = NModule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public void setsModules(List<SModule> sModules) {
        this.sModules = sModules;
    }

    public String getNModule() {
        return NModule;
    }

    public String getNom() {
        return nom;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public List<SModule> getsModules() {
        return sModules;
    }

    private String NModule;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SModule> sModules = new ArrayList<>();

}
