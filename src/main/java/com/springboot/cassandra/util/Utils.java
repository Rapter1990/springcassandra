package com.springboot.cassandra.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {

    public static LocalDate formatDate(LocalDate date) throws ParseException {

        String dateFormat = "MM/dd/yyyy";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        String formattedString = date.format(formatter);

        LocalDate localDate = LocalDate.parse(formattedString, formatter);

        return localDate;
    }
}
