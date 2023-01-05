package org.aguzman.springcloud.msvc.cursos.controllers;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
//        for(int x = 0; x < 100000; x ++){
//            System.out.println(LocalDateTime.now().format(dateTimeFormatter));
//        }

//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
//
//        //Create formatter
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("MM/dd/yyyy'T'HH:mm:ss.SSS");

//        LocalDateTime fecha = formater.parse(LocalDateTime.now().toString());
//
//
//        OffsetDateTime p = OffsetDateTime.parse(FOMATTER.format(LocalDateTime.now()), FOMATTER);
//
//
////Local date time instance
////        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
//
////Get formatted String
//        String ldtString = FOMATTER.format(localDateTime);
//        System.out.println(LocalDateTime.parse(ldtString, FOMATTER));

    }

}
