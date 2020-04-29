package com.exam.se02.comparable;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Example01 {
    public static void main(String[] args) {
        Student [] students = new Student[] {
                new Student("Ruslan", "Frolof", 3),
                new Student("Alexey", "Semenov", 7),
                new Student("Andrey", "Fedorov", 1),
                new Student("Sergey", "Semenov", 10)
        };

        System.out.println("Before:\n" + Arrays.toString(students));
        Arrays.sort(students);
        System.out.println("After:\n" + Arrays.toString(students));
        //Arrays.sort(students, new StudentBySurnameComparator());
        //Arrays.sort(students, new SurnameNameComparator());
        //System.out.println("After Comparator:\n" + Arrays.toString(students));
        //Arrays.sort(students, (o1, o2) -> {return o1.getSurname().compareTo(o2.getSurname());}); // Lambda expression
        Arrays.sort(students, comparing(Student::getSurname).thenComparing(Student::getName));

    }

    static class StudentBySurnameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }

    static class SurnameNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            int result = o1.getSurname().compareTo(o2.getSurname());
            if(result == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return result;
        }
    }

}
