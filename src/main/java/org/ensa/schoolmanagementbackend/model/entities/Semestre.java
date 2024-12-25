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
@Table(name = "semestres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NSemestre;
    private String nom;

    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Module> modules = new ArrayList<Module>();
}