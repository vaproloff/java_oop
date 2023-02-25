package sem_05_personal.model;

import java.util.regex.Pattern;

public class ValidateUser {
    private Pattern patternName = Pattern.compile("^\\S*$");
    private Pattern patternPhone = Pattern.compile("^\\d*$");

    public void check(User user) throws Exception {
        if (!patternName.matcher(user.getFirstName()).matches()) {
            throw new Exception("Illegal first name");
        }
        if (!patternName.matcher(user.getLastName()).matches()) {
            throw new Exception("Illegal last name");
        }
        if (!patternPhone.matcher(user.getPhone()).matches()) {
            throw new Exception("Illegal phone number");
        }
    }
}
