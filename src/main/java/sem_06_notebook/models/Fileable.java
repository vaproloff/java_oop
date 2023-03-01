package sem_06_notebook.models;

public interface Fileable<T> {
    T read();

    void save(T t);
}
