package ru.spring.hw6task1.resitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.hw6task1.Model.Note;

import java.util.Optional;

@Repository

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
