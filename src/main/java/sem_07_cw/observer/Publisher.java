package sem_07_cw.observer;

// Это интерфейс рассылки наблюдателям
// Он может регистрировать наблюдателей, избавляться от них, и рассылать им всем сообщения
public interface Publisher {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void sendOffer(String nameCompany, int salary);
}
