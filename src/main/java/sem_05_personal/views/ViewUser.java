package sem_05_personal.views;

import sem_05_personal.controllers.UserController;
import sem_05_personal.model.User;

import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        caseCreate();
                        break;
                    case READ:
                        caseRead();
                        break;
                    case LIST:
                        caseList();
                        break;
                    case DELETE:
                        caseDelete();
                        break;
                    case UPDATE:
                        caseUpdate();
                        break;
                }
            } catch (Exception e) {
                System.out.printf("Произошла ошибка: %s\n", e.getMessage());
            }
        }
    }

    private void caseCreate() throws Exception {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        userController.saveUser(new User(firstName, lastName, phone));
    }

    private void caseRead() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User user = userController.readUser(id);
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void caseList() {
        List<User> users = userController.readUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void caseDelete() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User deletedUser = userController.deleteUser(id);
            if (deletedUser != null) {
                System.out.printf("User %s deleted\n", deletedUser.getFirstName());
            } else {
                System.out.println("User not found\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void caseUpdate() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User foundUser = userController.readUser(id);
            if (foundUser != null) {
                System.out.println(foundUser);
                String changeChoice = prompt("Изменить (1 - имя, 2 - фамилию, 3 - телефон): ");
                switch (changeChoice) {
                    case "1" -> {
                        String newFirstName = prompt("Новое имя: ");
                        foundUser.setFirstName(newFirstName);
                        userController.updateUser(id, foundUser);
                    }
                    case "2" -> {
                        String newLastName = prompt("Новая фамилия: ");
                        foundUser.setLastName(newLastName);
                        userController.updateUser(id, foundUser);
                    }
                    case "3" -> {
                        String newPhone = prompt("Новый телефон: ");
                        foundUser.setPhone(newPhone);
                        userController.updateUser(id, foundUser);
                    }
                    default -> {
                    }
                }
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
