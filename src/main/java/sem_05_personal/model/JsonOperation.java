package sem_05_personal.model;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonOperation {
    private String fileName;

    public JsonOperation(String fileName) {
        this.fileName = fileName;
    }

    public JSONArray readFromJson() {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(fileName)) {
            return (JSONArray) parser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveToJson(JSONArray usersJson) {
        try (FileWriter jsonFile = new FileWriter(fileName, false)) {
            jsonFile.write(usersJson.toJSONString());
            jsonFile.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
