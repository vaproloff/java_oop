package sem_06_notebook;

import sem_06_notebook.controller.NotepadController;
import sem_06_notebook.models.*;
import sem_06_notebook.view.NotepadView;

public class Main {
    public static void main(String[] args) {
        JsonDb jsonDb = new JsonDb("src/main/java/sem_06_notebook/notes.json");
        TxtDb txtDb = new TxtDb("src/main/java/sem_06_notebook/notes/");
        Repository notesRepo = new Repository(jsonDb, txtDb);
        NotepadController controller = new NotepadController(notesRepo);
        NotepadView view = new NotepadView(controller);
        view.run();
    }
}
