package com.exam.se05.serialization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ExternalizablePerson implements Externalizable {
    private String name;
    private String surname;
    private int age;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("WriteExternal called");
        out.writeObject(name);
        out.writeObject(surname);
        out.writeInt(age);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("ReadExternal called");
        name = ((String) in.readObject());
        surname = ((String) in.readObject());
        age = in.readInt();

    }
}

public class StandartExternalizableExample {
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
