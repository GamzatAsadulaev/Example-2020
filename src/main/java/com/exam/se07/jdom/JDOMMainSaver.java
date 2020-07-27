package com.exam.se07.jdom;

import com.exam.se07.dom.Address;
import com.exam.se07.dom.Student;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.jdom2.Document;
import java.util.ArrayList;

public class JDOMMainSaver {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int j = 1; j < 3; j++) {
            Student st = new Student();
            st.setName("Petrov" + j);
            st.setLogin("petr"+ j);
            st.setFaculty("mmf");
            st.setTelephone(454556 + j * 3);
            Address adr = new Address();
            adr.setCity("Minsk");
            adr.setCountry("BLR");
            adr.setStreet("Gaja, " + j);
            st.setAddress(adr);
            students.add(st);
        }

        // создание дерева на основе списка студентов
        Document doc = JDOMCreator.create(students);
        // сохранение "дерева" в XML-документе
        if(JDOMCreator.saveDocument("studentsnew.xml", doc)) {
            System.out.println("Документ создан");
        } else {
            System.out.println("Документ НЕ создан");
        }

    }
}
