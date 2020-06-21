package com.exam.se05.serialization;

import lombok.Builder;
import lombok.Data;

import java.io.*;

@Data
@Builder
class Person implements Serializable {
    private String name;
    private String surname;
    private int age;
}

public class StandartSerializableExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizablePerson person = ExternalizablePerson.builder()
                .name("Ivan")
                .surname("Alexeev")
                .age(25)
                .build();

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);

        out.writeObject(person);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()));
        ExternalizablePerson deserializedObject = ((ExternalizablePerson) objectInputStream.readObject());
        System.out.println(deserializedObject);
        System.out.println("Same object = " + (person == deserializedObject));

    }
}
