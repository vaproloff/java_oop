package sem_06_hw;

import sem_06_hw.models.*;

public class Main{
	public static void main(String[] args){
		Persister<User> userSaver = new UserPersister();
		Reporter<User> userReporter = new UserReporter();
		User user = new User("Bob");
		userSaver.save(user);
		userReporter.report(user);
	}
}