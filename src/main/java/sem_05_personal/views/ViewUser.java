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

    public void run(){
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
        for (User user: users) {
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

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
