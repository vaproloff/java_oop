package sem_06_notebook.models;

public class TxtDb implements Fileable<String>{
    private String dirPath;

    public TxtDb(String dirPath) {
        this.dirPath = dirPath;
    }

    public String read() {
        return null;
    }

    public void save(String note) {

    }
}
