package sem_05_personal.model;

public interface Mapper {
    String map(User user);
    User map(String line);
}
