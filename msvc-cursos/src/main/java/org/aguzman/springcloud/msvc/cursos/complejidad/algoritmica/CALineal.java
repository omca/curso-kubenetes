package org.aguzman.springcloud.msvc.cursos.complejidad.algoritmica;

import java.time.LocalDateTime;
import java.util.Arrays;

public class CALineal {


  public static void main(String[] args) {
    int[] numeros = {1, 2, 3, 4, 5};
    System.out.println(LocalDateTime.now());
    System.out.println(linearSearch(numeros, 6));
    System.out.println(LocalDateTime.now());
  }

    /**
     * busqueda lineal
     * @param array
     * @param target
     * @return
     */
  public static int linearSearch(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
