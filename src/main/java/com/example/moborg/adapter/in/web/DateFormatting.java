package com.example.moborg.adapter.in.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatting {

    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static LocalDateTime fromBrowserDate(String rawDate){
        LocalDate localDate = LocalDate.parse(rawDate, YYYY_MM_DD);
        return localDate.atStartOfDay();
    }
    public static String formatAsDate(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("MM/dd/yyyy").format(localDateTime);
    }
}
