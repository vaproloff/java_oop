package sem_06_notebook.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TxtDb{
    private String dirPath;

    public TxtDb(String dirPath) throws IOException {
        this.dirPath = dirPath;
        if (!Files.exists(Path.of(dirPath))) {
            Files.createDirectory(Path.of(dirPath));
        }
    }

    public void save(Note note) throws IOException {
        Path filePath = Path.of(dirPath + note.getId());
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        Files.writeString(filePath, String.format("%s%n%s", note.getTopic(), note.getContent()));
    }
}
