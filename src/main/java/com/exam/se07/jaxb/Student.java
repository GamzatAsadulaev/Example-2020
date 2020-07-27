package com.exam.se07.jaxb;

import com.exam.se07.dom.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {"name", "telephone", "address"})
public class Student {

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class) // отбрасывает символы табуляции
    private String login;

    @XmlElement(required = true)
    private String name;

    @XmlAttribute(required = true)
    private String faculty;

    @XmlElement(required = true)
    private int telephone;

    @XmlElement(required = true)
    private Address address = new Address();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlRootElement
    public static class Address { // внутренний класс
        private String country;
        private String city;
        private String street;
    }

}
