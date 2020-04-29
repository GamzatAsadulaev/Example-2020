package com.exam.se03;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LocaleTest {

    @Test
    void name() {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayLanguage(Locale.CHINESE));

        for (Locale locale :
                Locale.getAvailableLocales()) {
//            System.out.println(locale);
        }

    }
}
