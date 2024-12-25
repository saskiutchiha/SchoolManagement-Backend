package org.ensa.schoolmanagementbackend.dao.entity;

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
@Table(name = "m_evaluations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String description;
    private Double coef;
    private String nom;

    @OneToMany(mappedBy = "mEvaluation", cascade = CascadeType.ALL)
    private List<ElemMevaluation> elemMevaluations = new ArrayList<>();

    @OneToMany(mappedBy = "mEval", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();
}