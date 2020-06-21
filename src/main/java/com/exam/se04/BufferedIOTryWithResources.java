package com.exam.se04;

import java.io.*;

public class BufferedIOTryWithResources {

    public static void main(String[] args)  {
        try {
            doIt();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void doIt() throws IOException {
        String inputFile = "C:\\Users\\asadu\\IdeaProjects\\java-core-09-2020\\chatlog.txt";
        String outputFile = "C:\\Users\\asadu\\IdeaProjects\\java-core-09-2020\\chatlogOut.txt";

        try(InputStream input = new BufferedInputStream(new FileInputStream(inputFile));
            OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            int countBytes = 0;
            int current;
            while((current = input.read()) >= 0) {
                System.out.println(current);
                output.write(current);
                ++countBytes;
            }
            System.out.println(countBytes);
        }

        }
}
