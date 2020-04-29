package com.exam.se03.Localization;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateFormatParseExample {
    public static void main(String[] args) {
        Locale localeNOR = new Locale("no", "NO");

        DateFormat[] dateFormatters = new DateFormat[] {
                DateFormat.getDateInstance(DateFormat.SHORT, localeNOR),
                DateFormat.getDateInstance(DateFormat.MEDIUM, localeNOR),
                DateFormat.getDateInstance(DateFormat.LONG, localeNOR),
                DateFormat.getDateInstance(DateFormat.FULL, localeNOR)
        };

        System.out.println("Parsing: ");
        Date date = new Date();
        for (DateFormat dft :
                dateFormatters) {
            try {
                String strDate = dft.format(date);
                Date parseDate = dft.parse(strDate);
                System.out.println(strDate + " | "
                                        + dft.format(parseDate));
            } catch (ParseException e) {
                System.out.println(e);
            }

            System.out.println("Leniency: ");
            try {
                System.out.println("32.01.08|"
                                        + dateFormatters[0].parse("32.01.08"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
