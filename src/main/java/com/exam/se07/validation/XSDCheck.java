package com.exam.se07.validation;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import java.io.IOException;

public class XSDCheck {
    public static void main(String[] args) {
        String filename = "students.xml";
        // создание объекта парсера
        DOMParser parser = new DOMParser();
        try {
            // установка обработчика ошибок
//            parser.setErrorHandler(new MyErrorHandler("log.txt"));
            // установка способов проверки с использованием XSD
            parser.setFeature("http://xml.org/sax/features/validation", true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema", true);
            // запуск процесса проверки
            parser.parse(filename);
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
            System.out.print("идентификатор не распознан");
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();
            System.out.print("неподдерживаемая операция");
        } catch (SAXException exception) {
            exception.printStackTrace();
            System.out.print("глобальная SAX ошибка");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("ошибка I/O потока");
        }
        System.out.println("проверка " + filename + " завершена");
    }

}
