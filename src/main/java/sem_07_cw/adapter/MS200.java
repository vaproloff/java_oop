package sem_07_cw.adapter;

import java.time.LocalDateTime;

public class MS200 implements MeteoSensor {
    int id;

    public MS200(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Float getTemperature() {
        return (float) 20;
    }

    public Float getHumidity() {
        return (float) 60;
    }

    public Float getPressure() {
        return (float) 752.4;
    }

    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }
}