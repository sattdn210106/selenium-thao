package common.helpers;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Common {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static JSONArray getJsonData(String pathFileJson) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(pathFileJson);
        Object obj = jsonParser.parse(reader);
        return (JSONArray) obj;
    }

    public static String plusDayFromNow(long daysToAdd) {
        return LocalDate.now().plusDays(daysToAdd).toString();
    }

}
