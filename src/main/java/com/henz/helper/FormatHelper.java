package com.henz.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FormatHelper {
	
	public final static String DATE_PATTERN_OF_DB = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_PATTERN_OF_HTML_FORM = "yyyy-MM-dd'T'HH:mm";
	
	private FormatHelper() {
		
	}

	public static String convertDateAsStringToAnotherFormat(String initialPattern, String convertPattern, String dateAsStringInitialPattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(initialPattern);
		
		Date dateInitialPattern = format.parse(dateAsStringInitialPattern);
		format = new SimpleDateFormat(convertPattern);
		String convertedDateAsString = format.format(dateInitialPattern);
		
		return convertedDateAsString;
	}
}
