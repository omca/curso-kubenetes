package org.aguzman.springcloud.msvc.usuarios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Shopping extends Vendor{

  public static void main(String[] args) {



    Predicate<String> valida = x -> x.length() > 1; // recibe un parametro y retorna un boolean
    Consumer<List<String>> lista = x -> x.forEach(System.out::println);

    System.out.println(valida.test("1"));
  }


}

@FunctionalInterface
interface Saludar {

  void saludando();



}
class Vendor{
  final void m1(){
    System.out.println("holaaa m1");

  }
}

