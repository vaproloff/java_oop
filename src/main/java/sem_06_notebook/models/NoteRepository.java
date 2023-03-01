package sem_06_notebook.models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NoteRepository implements Repository<Note> {
    private JsonDb jsonDb;
    private TxtDb txtDb;
    private int currentId = 1;

    public NoteRepository(JsonDb jsonDb, TxtDb txtDb) {
        this.jsonDb = jsonDb;
        this.txtDb = txtDb;
    }

    @Override
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

    @Override
    public Note create(Note note) {
        List<Note> notes = getAll();
        note.setId(String.format("%d", currentId++));
        notes.add(note);
        saveRepo(notes);
        return note;
    }

    @Override
    public Note delete(String id) {
        List<Note> notes = getAll();
        Note foundNote = getById(notes, id);
        if (foundNote != null) {
            notes.remove(foundNote);
            saveRepo(notes);
        }
        return foundNote;
    }

    @Override
    public Note find(String request) {
        return null;
    }

    @Override
    public Note getById(List<Note> notes, String id) {
        Note foundNote = null;
        for (Note note: notes) {
            if (note.getId().equals(id)) {
                foundNote = note;
            }
        }
        return foundNote;
    }

    @Override
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
