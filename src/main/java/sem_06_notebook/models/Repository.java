package sem_06_notebook.models;

import java.util.List;

public interface Repository<T> {
    T create(T item);
    T delete(String id);
    T find(String request);
    T getById(List<T> items, String id);
    void saveRepo(List<T> items);
    List<T> getAll();
}
