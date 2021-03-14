package com.springboot.cassandra.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date formatDate(Date date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = format.format(date);
        Date formatedDate = format.parse(dateString);

        return formatedDate;
    }
}
