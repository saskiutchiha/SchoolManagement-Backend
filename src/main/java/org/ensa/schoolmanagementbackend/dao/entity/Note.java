package org.ensa.schoolmanagementbackend.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "notes")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double note;
    private Boolean estAbsent;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")

    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "s_module_id")


    private SModule sModule;

    @ManyToOne
    @JoinColumn(name = "m_eval_id")
    private MEvaluation mEval;
}
