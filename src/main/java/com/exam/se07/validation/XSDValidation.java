package com.exam.se07.validation;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidation {
    public static void main(String[] args) throws SAXException, IOException {
        // 1. Поиск и создание экземпляра фабрики для языка XML Schema
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // 2. Компиляция схемы
        // Схема загружается в объект типа java.io.File, но вы также можете использовать
        // классы java.net,URL и javax.xml.transform.Source
        File schemaLocation = new File("../resources/com/exam/se07/xsd/students3.xsd");
        Schema schema = factory.newSchema(schemaLocation);

        // 3. Создание валидатора для схемы
        Validator validator = schema.newValidator();

        // 4. Разбор проверямого документа
        Source source = new StreamSource(args[0]);

        // 5. Валидация документа
        try {
            validator.validate(source);
            System.out.println(args[0] + " is valid");
        } catch (SAXException ex) {
            System.out.println(args[0] + "is not valid because ");
            System.out.println(ex.getMessage());
        }
    }

}
