package org.aguzman.springcloud.msvc.cursos.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {


        //Create formatter
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy'T'HH:mm:ss.SSS");


        OffsetDateTime p = OffsetDateTime.parse(FOMATTER.format(LocalDateTime.now()), FOMATTER);


//Local date time instance
        LocalDateTime localDateTime = LocalDateTime.now();

//Get formatted String
        String ldtString = FOMATTER.format(localDateTime);
        System.out.println(LocalDateTime.parse(ldtString, FOMATTER));

    }

}
