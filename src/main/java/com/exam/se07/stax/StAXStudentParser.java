package com.exam.se07.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXStudentParser {

    public void parse(InputStream input) {
        try {
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void process(XMLStreamReader reader) throws XMLStreamException {
        while(reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    StudentXMLElements enumName = StudentXMLElements.valueOf(name.toUpperCase());
                    writeStudentFeature(enumName);
                    studentInfoHandle(enumName, reader);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.println(reader.getText().trim());
                    break;
            }
        }
    }

    private void studentInfoHandle(StudentXMLElements element,
                                   XMLStreamReader reader) {
        switch (element) {
            case STUDENTS:
                System.out.println("Student");
                break;
            case STUDENT:
                String login = reader.getAttributeValue(null, StudentXMLElements.LOGIN
                        .name().toLowerCase());
                String faculty = reader.getAttributeValue(null,
                        StudentXMLElements.FACULTY.name().toLowerCase());
                System.out.println("Student: \nLogin: " + login + " \nFaculty: " + faculty);
                break;
            case ADDRESS:
                System.out.println(" Address: ");
                break;
        }
    }

    public void writeStudentFeature(StudentXMLElements element) {
        switch (element) {
            case STREET:
                System.out.print(" Street: ");
                break;
            case CITY:
                System.out.print(" City: ");
                break;
            case COUNTRY:
                System.out.print("Country: ");
                break;
            case TELEPHONE:
                System.out.print(" Telephone: ");
                break;
            case NAME:
                System.out.print("Name: ");
                break;
        }
    }


}
