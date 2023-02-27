package sem_05_personal.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositoryFile implements Repository {
    private Mapper mapper;
    private JsonMapper jsonMapper;
    private FileOperation fileOperation;
    private JsonOperation jsonOperation;

    public RepositoryFile(FileOperation fileOperation, JsonOperation jsonOperation, Mapper mapper, JsonMapper jsonMapper) {
        this.fileOperation = fileOperation;
        this.jsonOperation = jsonOperation;
        this.mapper = mapper;
        this.jsonMapper = jsonMapper;
    }

//    @Override
//    public List<User> getAllUsers() {
//        List<String> lines = fileOperation.readAllLines();
//        List<User> users = new ArrayList<>();
//        for (String line : lines) {
//            users.add(mapper.map(line));
//        }
//        return users;
//    }

    @Override
    public List<User> getAllUsers() {
        Iterator<JSONObject> usersJson = jsonOperation.readFromJson().iterator();
        List<User> users = new ArrayList<>();
        while (usersJson.hasNext()) {
            users.add(jsonMapper.mapFromJson(usersJson.next()));
        }
        return users;
    }

    @Override
    public String CreateUser(User user) {

        List<User> users = getAllUsers();
        int max = 0;
        for (User item : users) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        user.setId(id);
        users.add(user);
        saveRepository(users);
        return id;
    }

    private void saveRepository(List<User> users) {
        List<String> lines = new ArrayList<>();
        JSONArray usersJson = new JSONArray();
        for (User item : users) {
            lines.add(mapper.map(item));
            usersJson.add(jsonMapper.mapToJson(item));
        }
        fileOperation.saveAllLines(lines);
        jsonOperation.saveToJson(usersJson);
    }

    public User deleteUser(String userId) {
        List<User> users = getAllUsers();
        User foundUser = findUserById(users, userId);
        if (foundUser != null) {
            users.remove(foundUser);
            saveRepository(users);
        }
        return foundUser;
    }

    public void updateUser(String userId, User updatedUser) {
        List<User> users = getAllUsers();
        User foundUser = findUserById(users, userId);
        if (foundUser != null) {
            foundUser.setFirstName(updatedUser.getFirstName());
            foundUser.setLastName(updatedUser.getLastName());
            foundUser.setPhone(updatedUser.getPhone());
        }
        saveRepository(users);
    }

    public User findUserById(List<User> users, String userId) {
        User foundUser = null;
        for (User user : users) {
            if (user.getId().equals(userId)) {
                foundUser = user;
            }
        }
        return foundUser;
    }
}
