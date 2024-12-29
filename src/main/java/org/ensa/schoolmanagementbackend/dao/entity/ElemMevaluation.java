package org.ensa.schoolmanagementbackend.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "elem_mevaluations")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElemMevaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double coef;

    @ManyToOne
    @JoinColumn(name = "s_module_id")
    @JsonIgnore
    private SModule sModule;

    @ManyToOne
    @JoinColumn(name = "m_evaluation_id")

    private MEvaluation mEvaluation;
}