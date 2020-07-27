package com.exam.se07.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class StAXStudentMain {
    public static void main(String[] args) throws Exception {
//        XMLInputFactory factory = XMLInputFactory.newInstance();
//        XMLStreamReader reader = factory.createXMLStreamReader(StAXStudentMain.class.getResourceAsStream("students.xml"));
//        new StAXStudentParser().process(reader);

        new StAXStudentParser().parse(StAXStudentMain.class.getResourceAsStream("students.xml"));
    }
}
