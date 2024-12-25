package org.ensa.schoolmanagementbackend.model.entities;

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
@NoArgsConstructor
@AllArgsConstructor
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String code;
    private String email;
    private String specialite1;
    private String password;

    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    private List<SModule> sModules = new ArrayList<>();
}