package com.exam.override;

public class CourseInspector {
    public static void main(String[] args) {
        CourseHelper bch = new BaseCourseHelper();
        Course course = bch.getCourse();
        //BaseCourse course2 =  bch.getCourse();
                                // ошибка компиляции
                                // механизм позднего свзяывания
                                // Метод возвращает Course

        bch.getCourse();
    }
}

class Course {}
class BaseCourse extends Course{}

class CourseHelper{
    public Course getCourse() {
        System.out.println("Course");
        return new Course();
    }
}

class BaseCourseHelper extends CourseHelper {
    public BaseCourse getCourse() {
        System.out.println("BaseCourse");
        return new BaseCourse();
    }
}