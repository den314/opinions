package io.desz.opinions.service;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatUtil {

    private static DateTimeFormatter DEFAULT = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:MM");
    private static DateTimeFormatter formatter = DEFAULT;

    public static String format(TemporalAccessor temporal) {
        return formatter.format(temporal);
    }
}
