package sem_06_notebook.models;

public class Note {
    private String id;
    private String topic;
    private String content;

    public Note(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    public Note(String id, String topic, String content) {
        this(topic, content);
        this.id = id;
    }

    public Note(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Заметка %s.%n%s%n%s%n", id, topic, content);
    }
}
