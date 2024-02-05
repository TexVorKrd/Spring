package ru.spring.hw6task1.servises;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.hw6task1.Model.Note;
import ru.spring.hw6task1.aspect.TrackUserAction;
import ru.spring.hw6task1.resitory.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServises {

    private final NoteRepository repository;

    /**
     * Добавление заметки.
     * @param note - заметка
     * @return Возвращает заметку
     */
    @TrackUserAction
    public Note addNote(Note note) {
        if (note != null) return repository.save(note);
        return null;
    }

    /**
     * Выывод всех заметок
     * @return - спмсок заметок
     */
    public List<Note> findAllNotes() {
        return repository.findAll();
    }

    /**
     * Поиск по идентификатору
     * @param id - идентификатор
     * @return - Заметка
     */
    public Note findNoteById(Long id) {
        Optional<Note> note = repository.findById(id);
        return note.orElse(null);
    }

    /**
     * Обновление записи с указанным идентификатором
     * @param id - идентификатор
     * @param note - данные для обновления
     * @return - обновленная заметка
     */
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

    /**
     * Удаление заметки по идентификатору
     * @param id - идентификатор удаляемого объекта
     * @return - удаленный объект
     */
    @TrackUserAction
    public Note deleteNote(Long id) {

        Optional<Note> optionalNote = repository.findById(id);
        if (optionalNote.isPresent()) {
            repository.deleteById(id);
            return optionalNote.get();
        } else {
            return null;
        }
    }

    public void test(){
        addNote(new Note("Задача1","Описание 1"));
        addNote(new Note("Задача2","Описание 2"));
        addNote(new Note("Задача3","Описание 3"));

        deleteNote(1L);

    }
}
