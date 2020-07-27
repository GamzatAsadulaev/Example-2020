package com.exam.se07.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws Exception {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(false);
        parserFactory.setNamespaceAware(true);
        SAXParser parser = parserFactory.newSAXParser();
        try {
            parser.parse(Launcher.class.getResourceAsStream("web.xml"), new WebXmlHandler(3));
        } catch (ToMuchServletFoundException ignore) {}

        System.out.println("End of launcher");
    }

}
