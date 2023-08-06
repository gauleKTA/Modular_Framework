package commonLibs.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static String getCurrentDateAndTime() {
		LocalDateTime dateTime= LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-YYYY-hh-MM-ss");
		String dateTimeFormat = dateTime.format(format);
		return dateTimeFormat;
	}

}
