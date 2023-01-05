package org.aguzman.springcloud.msvc.cursos.complejidad.algoritmica;

import java.time.LocalDateTime;

public class OrderXSeleccion {

  public static void main(String[] args) {
    int[] numeros = {6, 3, 8, 1, 2};
    System.out.println(LocalDateTime.now());
    selectionSort(numeros);
    System.out.println(LocalDateTime.now());
  }

  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }

}
