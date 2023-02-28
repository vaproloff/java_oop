package sem_06_hw;

public class Persister {
    private User user;

    public Persister(User user) {
        this.user = user;
    }

    public void save() {
        System.out.println("Save user: " + user.getName());
    }
}