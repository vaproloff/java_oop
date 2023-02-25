package sem_05_personal;

import sem_05_personal.controllers.UserController;
import sem_05_personal.model.*;
import sem_05_personal.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        JsonOperation jsonOperation = new JsonOperation("users.json");
        Repository repository = new RepositoryFile(fileOperation, jsonOperation, new UserMapper(), new JsonMapper());
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}
