package com.exam.se04;

import java.io.*;

public class BufferedIOOldStyle {



    public static void main(String[] args)  {
        String inputFile = "C:\\Users\\asadu\\IdeaProjects\\java-core-09-2020\\chatlog.txt";
        String outputFile = "C:\\Users\\asadu\\IdeaProjects\\java-core-09-2020\\chatlogOut.txt";
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new BufferedInputStream(new FileInputStream(inputFile));
            output = new BufferedOutputStream(new FileOutputStream(outputFile));

            int countBytes = 0;
            int current;
            while((current = input.read()) >= 0) {
                System.out.println(current);
                output.write(current);
                ++countBytes;
            }
            System.out.println(countBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
