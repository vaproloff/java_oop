package sem_06_notebook.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TxtLogger implements Logable {
    private String filePath;

    public TxtLogger(String filePath) {
        this.filePath = filePath;
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addToLog(String msg) {
        try (FileWriter logWriter = new FileWriter(filePath, true)) {
            logWriter.append(new Date().toString()).append("\n")
                    .append(msg).append("\n\n");
            logWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
