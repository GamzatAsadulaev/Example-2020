package com.exam.se04;

import java.util.Scanner;

public class StandartStreamScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());

        scanner.close();

        System.out.println(scanner.nextLine());

    }
}
