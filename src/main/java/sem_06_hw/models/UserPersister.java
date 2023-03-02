package sem_06_hw.models;

public class UserPersister implements Persister<User> {
    public void save(User user) {
        System.out.println("Save user: " + user.getName());
    }
}