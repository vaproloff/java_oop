package sem_06_notebook.models;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonDb implements Fileable<JSONArray> {
    private String fileName;

    public JsonDb(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public JSONArray read() {
        JSONParser parser = new JSONParser();
        try {
            File file = new File(fileName);
            if (file.length() != 0) {
                FileReader reader = new FileReader(file);
                return (JSONArray) parser.parse(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public void save(JSONArray notes) {
        try (FileWriter jsonFile = new FileWriter(fileName, false)) {
            jsonFile.write(notes.toJSONString());
            jsonFile.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
