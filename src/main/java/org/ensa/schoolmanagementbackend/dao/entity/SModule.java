package org.ensa.schoolmanagementbackend.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "s_modules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NEmodule;
    private Double coef;
    private Boolean estValide;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private Prof prof;

    @OneToMany(mappedBy = "sModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "sModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ElemMevaluation> elemMevaluations = new ArrayList<ElemMevaluation>();

    @OneToMany(mappedBy = "sModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SmoduleEtudiant> smoduleEtudiants = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "etudiant_smodule")
    private List<Etudiant> etudiants;

}

