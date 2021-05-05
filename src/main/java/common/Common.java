package common;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Common {

    public static String plusDayFromNow(long daysToAdd, String dateFormat) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(dateFormat);
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
