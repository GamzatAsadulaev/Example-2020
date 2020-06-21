package com.exam.se04;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedInputStream pipeIn = new PipedInputStream();
            PipedOutputStream pipedOut = new PipedOutputStream();
            pipeIn.connect(pipedOut);

            for (int i = 0; i < 20; i++) {
                pipedOut.write(i);
            }
            byte[] buffer = new byte[pipeIn.available()];

            if (pipeIn.read(buffer) != buffer.length) {
                throw new IllegalStateException();
            }

            System.out.println(Arrays.toString(buffer));
        } catch (IOException e) {
            System.out.println("Impossible IOException occur: ");
            e.printStackTrace();
        }

    }
}
