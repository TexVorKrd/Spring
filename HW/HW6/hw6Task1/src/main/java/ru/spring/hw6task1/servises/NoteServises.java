package ru.spring.hw6task1.servises;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.hw6task1.Model.Note;
import ru.spring.hw6task1.resitory.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServises {

    private final NoteRepository repository;

    public Note addNote(Note note) {
        if (note != null) return repository.save(note);
        return null;
    }

    public List<Note> findAllNotes() {
        return repository.findAll();
    }

    public Note findNoteById(Long id) {
        Optional<Note> note = repository.findById(id);
        return note.orElse(null);
    }

    public Note updateNote(Long id, Note note) {

        if (note == null) return null;

        Optional<Note> optionalNote = repository.findById(id);

        if (optionalNote.isPresent()) {
            Note noteForUpdate = optionalNote.get();
            noteForUpdate.setTitle(note.getTitle());
            noteForUpdate.setContent(note.getContent());
            return repository.save(noteForUpdate);
        } else {
            return null;
        }
    }

    public Note deleteNote(Long id) {

        Optional<Note> optionalNote = repository.findById(id);
        if (optionalNote.isPresent()) {
            repository.deleteById(id);
            return optionalNote.get();
        } else {
            return null;
        }
    }
}
