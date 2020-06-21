package com.exam.se04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("file.out");

        System.setOut(new PrintStream(fileOutputStream));

        System.out.println("Hello, world!");
    }
}
