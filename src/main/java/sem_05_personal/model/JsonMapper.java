package sem_05_personal.model;

import org.json.simple.JSONObject;

public class JsonMapper {
    public JSONObject mapToJson(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put("id", user.getId());
        userJson.put("firstName", user.getFirstName());
        userJson.put("lastName", user.getLastName());
        userJson.put("phoneNumber", user.getPhone());
        return userJson;
    }

    public User mapFromJson(JSONObject jsonObject) {
        return new User(jsonObject.get("id").toString(),
                jsonObject.get("firstName").toString(),
                jsonObject.get("lastName").toString(),
                jsonObject.get("phoneNumber").toString());
    }
}
