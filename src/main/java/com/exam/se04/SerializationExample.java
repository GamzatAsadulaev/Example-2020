package com.exam.se04;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        try{
            // сериализация
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Object objSave = new Integer(1);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(objSave);

            //Смотрим, во что проевратился сериализованный объект
            byte[] bArray = os.toByteArray();
            for(byte b: bArray) {
                System.out.print((char) b);
            }
            System.out.println();
            // десериализация
            ByteArrayInputStream is = new ByteArrayInputStream(bArray);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object objRead = ois.readObject();

            Integer deserialized = (Integer) objRead;

            System.out.println(deserialized.equals(objSave));

            // проверяем идентичность объективов
            System.out.println("readed object is: " + objRead.toString());
            System.out.println("Object equality is: "
                    + objSave.equals(objRead));
            System.out.println("reference equality is: " + (objSave == objRead));
        }catch (NotSerializableException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
