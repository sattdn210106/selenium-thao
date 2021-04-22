package common.helpers;

import common.constants.Constant;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Helper {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
    public static JSONArray getJsonData (String pathFileJson) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(pathFileJson);
        Object obj = jsonParser.parse(reader);
        return (JSONArray) obj;
    }
}
