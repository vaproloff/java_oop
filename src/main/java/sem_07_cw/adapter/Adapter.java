package sem_07_cw.adapter;

import java.time.LocalDateTime;

public class Adapter implements MeteoSensor {
    private SensorTemperature adaptee;

    public Adapter(SensorTemperature adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int getId() {
        return adaptee.identifier();
    }

    @Override
    public Float getTemperature() {
        return (float) adaptee.temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        LocalDateTime ldt = LocalDateTime.of(adaptee.year(), 1, 1, 0, 0);
        ldt = ldt.plusDays(adaptee.day() - 1);
        ldt = ldt.plusSeconds(adaptee.second());
        return ldt;
    }
}
