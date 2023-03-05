package sem_06_notebook.view;

import sem_06_notebook.controller.NotepadController;
import sem_06_notebook.models.Note;

import java.io.IOException;
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
                        1 - создать заметку, 2 - выбрать заметку
                        3 - показать все, 4 - поиск, 0 - выход
                        Выбор:""" + " ");
                switch (command) {
                    case "1" -> newNote();
                    case "2" -> pickNote();
                    case "3" -> showAll();
                    case "4" -> search();
                    case "0" -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.printf("Произошла ошибка: %s\n", e.getMessage());
            }
        }
    }

    private void newNote() throws IOException {
        String title = prompt("Заголовок: ");
        String content = prompt("Содержание: ");
        notepadController.saveNote(new Note(title, content));
    }

    private void showAll() {
        List<Note> notes = notepadController.getAllNotes();
        if (!notes.isEmpty()) {
            for (Note note : notes) {
                System.out.println(note);
            }
        } else {
            System.out.println("Заметок пока нет");
        }
    }

    private void pickNote() {
        String id = prompt("Идентификатор заметки: ");
        Note note = notepadController.getNodeById(id);
        if (note != null) {
            System.out.println(note);
            try {
                String command = prompt("1 - изменить, 2 - удалить, другой символ - выход\nВыбор: ");
                switch (command) {
                    case "1" -> updateNote(note);
                    case "2" -> deleteNote(note);
                }
            } catch (Exception e) {
                System.out.printf("Произошла ошибка: %s\n", e.getMessage());
            }

        } else {
            System.out.printf("Заметки с ID = %s нет в записной книге%n", id);
        }
    }

    private void search() {
        String request = prompt("Введите текст для поиска: ");
        List<Note> foundNotes = notepadController.findNotes(request);
        if (!foundNotes.isEmpty()) {
            for (Note note : foundNotes) {
                System.out.println(note);
            }
        } else {
            System.out.println("По данному запросу заметок не найдено");
        }
    }

    private void deleteNote(Note note) {
        try {
            if (notepadController.deleteNote(note)) {
                System.out.printf("Заметка %s удалена\n", note.getId());
            } else {
                System.out.println("Ошибка при удалении!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateNote(Note note) {
        try {
            String command = "";
            while (!command.equals("0")) {
                command = prompt("1 - изменить заголовок, 2 - изменить содержание, 0 - сохранить и выйти\nВыбор: ");
                switch (command) {
                    case "1" -> note.setTopic(prompt("Введите новый заголовок: "));
                    case "2" -> note.setContent(prompt("Введите новое содержание: "));
                }
            }
        } catch (Exception e) {
            System.out.printf("Произошла ошибка: %s\n", e.getMessage());
        }
        try {
            if (notepadController.updateNote(note)) {
                System.out.println(note);
            } else {
                System.out.println("Ошибка при изменении!");
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
