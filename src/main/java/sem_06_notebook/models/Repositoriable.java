package sem_06_notebook.models;

import java.io.IOException;
import java.util.List;

public interface Repositoriable<T> {
    List<T> getAll();
    T create(T newItem) throws IOException;
    boolean delete(T item) throws IOException;
    boolean update(T item) throws IOException;
    List<T> find(String request);
    T getById(List<T> items, String id);
    void saveRepo(List<T> items) throws IOException;
}
