package org.ensa.schoolmanagementbackend.dao.repository;

import org.ensa.schoolmanagementbackend.dao.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // Utilisation d'une méthode dérivée pour rechercher par sModule.id
//    List<Note> findBySModuleId(Long sModuleId);

    // Exemple d'une requête JPQL personnalisée
    @Query("SELECT n FROM Note n WHERE n.sModule.code = :sModuleId")
    List<Note> findNotesBySModuleId(@Param("sModuleId") Long sModuleId);

}
