package common.helpers;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Common {
    public static JSONArray getJsonData(String pathFileJson) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(pathFileJson);
        Object obj = jsonParser.parse(reader);
        return (JSONArray) obj;
    }

    public static String plusDayFromNow(long daysToAdd) {
        return LocalDate.now().plusDays(daysToAdd).toString();
    }

    public static File readFile(String fileName) {
        String path = new File(fileName).getAbsolutePath();
        return new File(path);
    }
}
