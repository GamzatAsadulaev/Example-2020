package com.exam.se03.Localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatExample {
    public static void main(String[] args) {
        Locale[] locales  = {Locale.ENGLISH, new Locale("no", "NO"),
                Locale.JAPAN};
        NumberFormat[] numberFormatters = new NumberFormat[] {
                NumberFormat.getNumberInstance(locales[0]),
                NumberFormat.getNumberInstance(locales[1]),
                NumberFormat.getNumberInstance(locales[2]) };

        NumberFormat[] currFormatters = new NumberFormat[] {
                NumberFormat.getNumberInstance(locales[0]),
                NumberFormat.getCurrencyInstance(locales[1]),
                NumberFormat.getCurrencyInstance(locales[2]) };

        NumberFormat[] percentFormatters = new NumberFormat[] {
                NumberFormat.getPercentInstance(locales[0]),
                NumberFormat.getPercentInstance(locales[1]),
                NumberFormat.getPercentInstance(locales[2])
        };

        double number = 9876.598;
        System.out.println("Formatting the number: " + number);
        runFormatters(number, numberFormatters, locales);


        for(NumberFormat nf : numberFormatters) {
            nf.setMaximumFractionDigits(2); // задаем сколько максимум симолов должно выходить после запятой
        }
        System.out.println("Formatting the number: " + number +
                " to 2 dec. places: ");
        runFormatters(number, numberFormatters, locales);

        System.out.println("Formatting the currency amount: " + number);
        runFormatters(number, currFormatters, locales);
        runParsers("9876.598", numberFormatters, locales);
        runParsers("9876,598", numberFormatters, locales);
        runParsers("9876@598", numberFormatters, locales);
        runParsers("@9876598", numberFormatters, locales);
        runParsers("£9876.598", currFormatters, locales);
        runParsers("kr 9876,598", currFormatters, locales);
        runParsers("JPY98@76598", currFormatters, locales);
        runParsers("@9876598", currFormatters, locales);
    }

    static void runFormatters(double value, NumberFormat[] formatters, Locale[] locales) {
        for (int i = 0; i < locales.length; i++) {
            System.out.printf("%-24s: %s%n",
                    locales[i].getDisplayName(),
                    formatters[i].format(value));
        }
    }

    static void runParsers(String inputString, NumberFormat[] formatters, Locale[] locales) {
        System.out.println("Parsing: " + inputString);
        for (int i = 0; i < formatters.length; i++) {
            try{
                System.out.printf("%-24s: %s%n", locales[i].getDisplayName(), formatters[i].parse(inputString));
            } catch (ParseException e) {
                System.out.println(e);
            }
        }
    }

}
