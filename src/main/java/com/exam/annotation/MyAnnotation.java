package com.exam.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)// указывает где будет доступно (compler| compiler-time
// and deploment-time processing| runtime)
@Target(value = {ElementType.TYPE, ElementType.FIELD}) // указывает для чего можно использовать нашу аннотацию, в каких местах
public @interface MyAnnotation {

    String param() default "123";

}
