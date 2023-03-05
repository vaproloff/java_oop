package sem_06_notebook.models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sem_05_personal.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository implements Repositoriable<Note> {
    private JsonDb jsonDb;
    private TxtDb txtDb;

    public Repository(JsonDb jsonDb, TxtDb txtDb) {
        this.jsonDb = jsonDb;
        this.txtDb = txtDb;
    }

    public List<Note> getAll() {
        Iterator<JSONObject> notesJson = jsonDb.read().iterator();
        List<Note> notes = new ArrayList<>();
        while (notesJson.hasNext()) {
            JSONObject noteJson = notesJson.next();
            Note note = new Note(noteJson.get("id").toString(),
                    noteJson.get("title").toString(),
                    noteJson.get("content").toString());
            notes.add(note);
        }
        return notes;
    }

    public Note create(Note newNote) throws IOException {
        List<Note> notes = getAll();
        int maxId = 0;
        for (Note note : notes) {
            maxId = Math.max(maxId, Integer.parseInt(note.getId()));
        }
        newNote.setId(String.format("%d", maxId + 1));
        notes.add(newNote);
        saveRepo(notes);
        txtDb.save(newNote);
        return newNote;
    }

    public boolean delete(Note note) throws IOException {
        List<Note> notes = getAll();
        Note foundNote = getById(notes, note.getId());
        if (foundNote != null) {
            notes.remove(foundNote);
            saveRepo(notes);
            txtDb.delete(foundNote);
            return true;
        }
        return false;
    }

    public boolean update(Note note) throws IOException {
        List<Note> notes = getAll();
        Note foundNote = getById(notes, note.getId());
        if (foundNote != null) {
            foundNote.setTopic(note.getTopic());
            foundNote.setContent(note.getContent());
            saveRepo(notes);
            txtDb.save(foundNote);
            return true;
        }
        return false;
    }

    public List<Note> find(String request) {
        List<Note> foundNotes = new ArrayList<>();
        for (Note note : getAll()) {
            if (note.getId().contains(request)) {
                foundNotes.add(note);
            }
            if (note.getTopic().contains(request) && !foundNotes.contains(note)) {
                foundNotes.add(note);
            }
            if (note.getContent().contains(request) && !foundNotes.contains(note)) {
                foundNotes.add(note);
            }
        }
        return foundNotes;
    }

    public Note getById(List<Note> notes, String id) {
        Note foundNote = null;
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                foundNote = note;
            }
        }
        return foundNote;
    }

    public void saveRepo(List<Note> notes) {
        JSONArray notesJson = new JSONArray();
        for (Note note : notes) {
            JSONObject noteJson = new JSONObject();
            noteJson.put("id", note.getId());
            noteJson.put("title", note.getTopic());
            noteJson.put("content", note.getContent());
            notesJson.add(noteJson);
        }
        jsonDb.save(notesJson);
    }
}
