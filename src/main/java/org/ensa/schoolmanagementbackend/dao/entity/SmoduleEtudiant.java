package org.ensa.schoolmanagementbackend.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "smoduleetudiant")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmoduleEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    private float moyenne;



    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    public Etudiant etudiant ;

    @ManyToOne
    @JoinColumn(name = "etudiant_id2")
    public SModule sModule ;
}
