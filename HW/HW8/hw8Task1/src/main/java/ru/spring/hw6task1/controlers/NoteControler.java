package ru.spring.hw6task1.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.hw6task1.Model.Note;
import ru.spring.hw6task1.servises.NoteServises;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteControler {

    private final NoteServises noteServises;

    @GetMapping("")
    public List<Note> findAllNotes() {
        return noteServises.findAllNotes();
    }

    @GetMapping("/test")
    public void test() {
        noteServises.test();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findAllNotes(@PathVariable(name = "id") Long id) {
        Note note = noteServises.findNoteById(id);
        if (note == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Note> addNotes(@RequestBody Note note) {
        return new ResponseEntity<>(noteServises.addNote(note), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> addNotes(@PathVariable(name = "id") Long id, @RequestBody Note note) {

        Note updateNote = noteServises.updateNote(id, note);
        if (updateNote == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(updateNote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNotes(@PathVariable(name = "id") Long id) {

        Note note = noteServises.deleteNote(id);

        if (note == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }
}
