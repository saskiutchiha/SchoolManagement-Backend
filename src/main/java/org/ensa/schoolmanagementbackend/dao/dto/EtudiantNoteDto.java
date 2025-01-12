package org.ensa.schoolmanagementbackend.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ensa.schoolmanagementbackend.dao.entity.Etudiant;
import org.ensa.schoolmanagementbackend.dao.entity.Note;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantNoteDto extends Etudiant {
    private List<Note> NotesList ;
}
