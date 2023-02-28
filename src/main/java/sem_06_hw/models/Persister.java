package sem_06_hw.models;

public interface Persister<T>{
    void save(T t);
}
