package org.aguzman.springcloud.msvc.cursos.services;

import org.aguzman.springcloud.msvc.cursos.models.Usuario;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
  private static List<String> lista = Arrays.asList("omar", "carlos", "luis");

  public  void main(String[] args) {

    referenceMethodsJava8();
    //javaUtilFunction();
    //foreachMethod();
    //fechas();
    //test();
  }

  public  static void referenceMethodsJava8() {

    lista.stream().filter(new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return false;
      }
    });

    Predicate predicate = new Predicate() {
      @Override
      public boolean test(Object o) {
        return false;
      }
    };

    List<String> listaRefere = new ArrayList<String>(lista);
    listaRefere.forEach(SimplePrinter::print);

  }

  public static void javaUtilFunction() {

    List<String> listanueva =
    lista.stream().filter(x -> x.equals("omar"))
        .collect(Collectors.toList());

    listanueva.forEach(System.out::println);

  }


  public static void foreachMethod() {


    //
    lista.forEach(System.out::println);

    List<String> items = new ArrayList<>();
    items.add("coins");
    items.add("pens");
    items.add("keys");
    items.add("sheets");

    items.forEach((String name) -> {
      System.out.println(name);
    });

  }


  public static void fechas() {
    LocalDate localDate = LocalDate.now();
    System.out.println(localDate);
    System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Lima")).plusYears(10));

  }

  public static Optional<Usuario> test() {

    Usuario usuario = new Usuario();
    usuario.setEmail("calderonomar4@gmail.com");
    usuario.setId(1l);
    // NOT EMPTY
    Optional<Usuario> optionalUsuario = Optional.of(usuario);

    System.out.println("**** NOT EMPTY ****");
    System.out.println(optionalUsuario.toString());
    System.out.println(optionalUsuario.isPresent());
    System.out.println(optionalUsuario.get().getId() );

    optionalUsuario.filter(usu -> usu.getId().equals(1));

    // EMPTY
    Optional<Usuario> empty = Optional.empty();
    System.out.println("\n**** EMPTY ****");
    System.out.println(empty.toString());
    System.out.println(empty.isPresent());
    System.out.println(empty.get().getId());
    System.out.println();
    return Optional.empty();
  }

}



class SimplePrinter {
  public static void print(String str) {
    System.out.println(str);
  }
}
