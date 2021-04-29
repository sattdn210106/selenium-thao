package common;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Common {
    public static JSONArray getJsonData(String pathFileJson) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(pathFileJson);
        Object obj = jsonParser.parse(reader);
        return (JSONArray) obj;
    }

    public static String plusDayFromNow(long daysToAdd, String formatDay) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(formatDay);
        return LocalDate.now().plusDays(daysToAdd).format(myFormatObj);
    }

    public static File readFile(String fileName) {
        String path = new File(fileName).getAbsolutePath();
        return new File(path);
    }

    public static String changeDateFormat(String date, String newFormat) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(newFormat);
        return LocalDate.parse(date).format(myFormatObj);
    }

    public static String plusDaysFromDate(String date, long daysToAdd) {
        return LocalDate.parse(date).plusDays(daysToAdd).toString();
    }
}
