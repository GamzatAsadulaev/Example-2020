package com.exam.se07.dom;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMMain {
    public static void main(String[] args) {
        try {
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parser.parse(DOMMain.class.getResourceAsStream("../students.xml"));
            Analyzer.listBuilder(document.getDocumentElement())
                    .forEach(System.out::println);
        } catch(SAXException e) {
            e.printStackTrace();
            System.out.println("ошибка SAX парсера");
        } catch(ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("ошибка конфигурации");
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("ошибка I/O потока");
        }
    }

}
