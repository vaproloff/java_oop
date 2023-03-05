package sem_06_notebook.controller;

import sem_06_notebook.models.Note;
import sem_06_notebook.models.Repository;

import java.io.IOException;
import java.util.List;

public class NotepadController {
    private Repository repo;

    public NotepadController(Repository repo) {
        this.repo = repo;
    }

    public Note getNodeById(String id) {
        return repo.getById(getAllNotes(), id);
    }

    public List<Note> getAllNotes() {
        return repo.getAll();
    }

    public Note saveNote(Note note) throws IOException {
        return repo.create(note);
    }

    public boolean deleteNote(Note note) throws IOException {
        return repo.delete(note);
    }

    public boolean updateNote(Note note) throws IOException {
        return repo.update(note);
    }

    public List<Note> findNotes(String request) {
        return repo.find(request);
    }
}
