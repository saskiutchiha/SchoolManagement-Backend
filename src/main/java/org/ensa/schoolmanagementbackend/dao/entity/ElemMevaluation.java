package org.ensa.schoolmanagementbackend.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "elem_mevaluations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElemMevaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double coef;

    @ManyToOne
    @JoinColumn(name = "s_module_id")
    private SModule sModule;

    @ManyToOne
    @JoinColumn(name = "m_evaluation_id")
    private MEvaluation mEvaluation;
}