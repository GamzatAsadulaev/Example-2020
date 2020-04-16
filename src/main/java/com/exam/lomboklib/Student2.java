package com.exam.lomboklib;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student2 {
    private String name;
    private String surname;
    private int age;
}

class Launcher2 {
    public static void main(String[] args) {
        Student2 student2 = new Student2();
        Student2 student21 = new Student2("Kiril", "Frolof", 25);
        System.out.println(student21.getName());
        System.out.println(student21);

    }
}
