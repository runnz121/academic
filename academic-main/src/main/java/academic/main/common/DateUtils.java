package academic.main.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class DateUtils {

    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS_STRING = "yyyyMMddHHmmssSSS";

    public static String toString(LocalDateTime dateTime, String format) {
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }
}
