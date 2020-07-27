package com.exam.se07.jdom;

import com.exam.se07.dom.Address;
import com.exam.se07.dom.Student;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import javax.xml.stream.XMLOutputFactory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class JDOMCreator {
    public static Document create(List<Student> list) { // создание корневого элемента
                                            // элемента
                                            // <students>
        Element root = new Element("students");
        Iterator<Student> studentIterator = list.iterator();
        while(studentIterator.hasNext()) {
            Student student = studentIterator.next();
            // создание элемента <student> и его содержимого
            Element studentElement = new Element("student");
            // создание атрибутов и передача им значений
            studentElement.setAttribute("login", student.getLogin());
            studentElement.setAttribute("phone", String.valueOf(student.getTelephone()));
            Element faculty = new Element("faculty");
            faculty.setText(student.getFaculty());
            //вложение элемента <faculty> в эемент <student>
            studentElement.addContent(faculty);
            Element name = new Element("name");
            name.setText(student.getName());
            studentElement.addContent(name);
            // создание элемента <address>
            Element addressElement = new Element("address");
            Address address = student.getAddress();
            Element country = new Element("country");
            country.setText(address.getCountry());
            addressElement.addContent(country);
            Element city = new Element("city");
            city.setText(address.getCity());
            addressElement.addContent(city);
            Element street = new Element("street");
            street.setText(address.getStreet());
            // вложение элемента <street> в элемент <address>
            addressElement.addContent(street);
            // вложение элемента <address> в элемент <student>
            studentElement.addContent(addressElement);
            // вложение элемента <student> в элемент <students>
            root.addContent(studentElement);
        } // конец цикла while
                    // создание основного дерева XML-документа
        return new Document(root);
    }

    public static boolean saveDocument(String fileName, Document doc) {
        boolean complete = true;
        XMLOutputter outputter = new XMLOutputter();
        // запись XML-документа
        try {
            outputter.output(doc, new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            complete = false;
        } catch (IOException e) {
            e.printStackTrace();
            complete = false;
        }
        return complete;
    }
}
