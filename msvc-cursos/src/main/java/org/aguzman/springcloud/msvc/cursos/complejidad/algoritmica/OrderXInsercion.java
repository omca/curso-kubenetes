package org.aguzman.springcloud.msvc.cursos.complejidad.algoritmica;

import java.time.LocalDateTime;

public class OrderXInsercion {

  public static void main(String[] args) {
    int[] numeros = {1, 2, 3, 4, 5};

    System.out.println(LocalDateTime.now());
    insertionSort(numeros);
    System.out.println(LocalDateTime.now());
  }

  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int current = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > current) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = current;
    }
  }


}
