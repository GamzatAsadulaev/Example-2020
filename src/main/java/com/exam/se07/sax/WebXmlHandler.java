package com.exam.se07.sax;

import com.sun.org.apache.xerces.internal.impl.xs.util.XInt;
import jdk.nashorn.internal.ir.CallNode;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;




public class WebXmlHandler extends DefaultHandler {
    private final StringBuilder accumulator = new StringBuilder();

    private final int expectedCountServlets;
    private int foundElements = 0;

    private String servletName;
    private String servletClass;
    private String servletId;


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    public WebXmlHandler(int expectedCountServlets) {
        this.expectedCountServlets = expectedCountServlets;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        accumulator.setLength(0);
        if (localName.equals("servlet")) {
            servletId = attributes.getValue("id");
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        accumulator.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (localName) {
            case "servlet-name":
                servletName = accumulator.toString().trim();
                break;

            case "servlet-class":
                servletClass = accumulator.toString().trim();
                break;

            case "servlet":
                String id = Optional.ofNullable(servletId)
                                    .map(str -> " (id=" + str + ")")
                                    .orElse("");
                System.out.println("Servlet " + servletName + id  + ": "+ servletClass);
                if(++foundElements == expectedCountServlets) {
                    throw new ToMuchServletFoundException();
                }
                break;
        }
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        System.out.println("ERROR: line" + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXParseException {
        System.out.println("FATAL: line" + exception.getLineNumber() + ": " + exception.getMessage());
        throw exception;
    }

    @Override
    public void endDocument() {
        System.out.println("Parsing ended");
    }
}

