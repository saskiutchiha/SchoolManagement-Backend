package org.ensa.schoolmanagementbackend.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "m_evaluations")
@Data
@Getter
@Setter
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
    @JsonIgnore
    private List<ElemMevaluation> elemMevaluations = new ArrayList<>();

    @OneToMany(mappedBy = "mEval", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Note> notes = new ArrayList<>();
}