package com.exam.se07.jdom;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
//import org.w3c.dom.Document;

import java.io.IOException;


public class JDOMMain {
    public static void main(String[] args) {
        try{
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(JDOMMain.class.getResourceAsStream("../students.xml"));
            JDOMAnalyzer.listCreator(document)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            System.out.println("Ошибка при разборе документа" + e);
        }


    }
}

