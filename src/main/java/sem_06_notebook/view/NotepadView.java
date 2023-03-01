package sem_06_notebook.view;

import sem_06_notebook.controller.NotepadController;
import sem_06_notebook.models.Note;

import java.util.List;
import java.util.Scanner;

public class NotepadView {
    private NotepadController notepadController;

    public NotepadView(NotepadController notepadController) {
        this.notepadController = notepadController;
    }

    public void run() {
        while (true) {
            try {
                String command = prompt("""
                        ---Главное меню---
                        1 - новая заметка, 2 - все заметки, 3 - показать заметку,
                        4 - найти заметку, 5 - удалить заметку, 0 - выход
                        """);
                switch (command) {
                    case "1" -> newNote();
                    case "2" -> showAll();
                    case "3" -> readNote();
                    case "4" -> findNote();
                    case "5" -> deleteNote();
                    case "0" -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.printf("Произошла ошибка: %s\n", e.getMessage());
            }
        }
    }

    private void newNote() {
        String title = prompt("Заголовок: ");
        String content = prompt("Содержание: ");
        notepadController.saveNote(new Note(title, content));
    }

    private void showAll() {
        List<Note> notes = notepadController.getAllNotes();
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    private void readNote() {
        String id = prompt("Идентификатор заметки: ");
        try {
            Note note = notepadController.getNodeById(id);
            System.out.println(note);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void findNote() {

    }

    private void deleteNote() {
        String id = prompt("Идентификатор заметки: ");
        try {
            Note deletedNote = notepadController.deleteNote(id);
            if (deletedNote != null) {
                System.out.printf("Note %s deleted\n", deletedNote.getId());
            } else {
                System.out.println("Note not found\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
