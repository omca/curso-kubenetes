package org.aguzman.springcloud.msvc.usuarios;

/**
 * Created by Omar Calderon Evangelista
 * User: Omar.Calderon
 * Date: 10/02/2023
 * Time: 19:19
 * Change Text
 */
public class Animal {
  void walk(){}
}

class LightWeithAnimal extends Animal {
  void jump(){}
}

class Elephant extends Animal{}
class Dog extends LightWeithAnimal{}

class Principal{

  void humpHole(LightWeithAnimal a){
    a.walk(); // animal
    a.jump(); // lighweithanimal
    a.walk(); // animal
  }

  public static void main(String[] args) {

  }

}
