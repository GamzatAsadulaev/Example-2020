package com.exam.se04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequanceInputStreamExample {
    public static void main(String[] args) {
        FileInputStream inFile1 = null;
        FileInputStream inFile2 = null;
        SequenceInputStream sequanceStream = null;
        FileOutputStream outFile = null;
        try {
            inFile1 = new FileInputStream("C:\\Users\\asadu\\IdeaProjects\\java-core-09-2020\\src\\main\\resources\\com\\exam\\se04\\file1.txt");
            inFile2 = new FileInputStream("C:\\Users\\asadu\\IdeaProjects\\java-core-09-2020\\src\\main\\resources\\com\\exam\\se04\\file2.txt");
            sequanceStream = new SequenceInputStream(inFile1, inFile2);
            outFile = new FileOutputStream("C:\\Users\\asadu\\IdeaProjects\\java-core-09-2020\\src\\main\\resources\\com\\exam\\se04\\file3.txt");
            int readedByte = sequanceStream.read();
            while(readedByte != -1) {
                outFile.write(readedByte);
                readedByte = sequanceStream.read();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
        } finally {
            try {
                sequanceStream.close();
            } catch (IOException e) {
            }
            try {
                outFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
