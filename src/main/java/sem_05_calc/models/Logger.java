package sem_05_calc.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    private FileWriter logWriter;

    public Logger(String filePath) throws IOException {
        this.logWriter = new FileWriter(filePath, true);
    }

    public void addToLog(String msg) throws IOException {
        logWriter.append(new Date().toString()).append("\n")
                .append(msg).append("\n\n");
        logWriter.flush();
    }
}
