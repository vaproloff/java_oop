package sem_06_notebook.models;

import java.io.IOException;
import java.util.List;

public class RepoWLog implements Repositoriable<Note> {
    private Logable logger;
    private Repositoriable repo;

    public RepoWLog(Logable logger, JsonDb jsonDb, TxtDb txtDb) {
        this.logger = logger;
        repo = new Repository(jsonDb, txtDb);
    }

    @Override
    public List<Note> getAll() {
        logger.addToLog("Requesting all notes");
        return repo.getAll();
    }

    @Override
    public Note create(Note newNote) throws IOException {
        logger.addToLog("Adding new note with ID = " + newNote.getId());
        return (Note) repo.create(newNote);
    }

    @Override
    public boolean delete(Note note) throws IOException {
        logger.addToLog("Deleting note with ID = " + note.getId());
        return repo.delete(note);
    }

    @Override
    public boolean update(Note note) throws IOException {
        logger.addToLog("Updating note with ID = " + note.getId());
        return repo.update(note);
    }

    @Override
    public List<Note> find(String request) {
        logger.addToLog("Searching notes with request: " + request);
        return repo.find(request);
    }

    @Override
    public Note getById(List<Note> notes, String id) {
        logger.addToLog("Picking note with ID = " + id);
        return (Note) repo.getById(notes, id);
    }

    @Override
    public void saveRepo(List<Note> items) throws IOException {
        logger.addToLog("Saving notes to DB");
        repo.saveRepo(items);
    }
}
