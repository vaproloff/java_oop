package sem_06_hw.models;

public class UserReporter implements Reporter<User>{
    public void report(User user) {
        System.out.println("Report for user: " + user.getName());
    }
}
