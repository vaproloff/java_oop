package sem_06_notebook.controller;

import sem_06_notebook.models.Note;
import sem_06_notebook.models.Repository;

import java.util.List;

public class NotepadController {
    private Repository repo;

    public NotepadController(Repository repo) {
        this.repo = repo;
    }

    public Note getNodeById(String id) throws Exception {
        Note foundNote = (Note) repo.getById(getAllNotes(), id);
        if (foundNote != null) {
            return foundNote;
        }
        throw new Exception("Note not found\n");
    }

    public List<Note> getAllNotes() {
        return repo.getAll();
    }

    public Note saveNote(Note note) {
        return (Note) repo.create(note);
    }

    public Note deleteNote(String id) {
        return (Note) repo.delete(id);
    }
}
