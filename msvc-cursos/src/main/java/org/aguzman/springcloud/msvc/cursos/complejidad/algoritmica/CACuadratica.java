package org.aguzman.springcloud.msvc.cursos.complejidad.algoritmica;

import java.time.LocalDateTime;

public class CACuadratica {


  public static void main(String[] args) {
    int[] numeros = {1, 2, 3, 4, 5};
    System.out.println(LocalDateTime.now());
    System.out.println(binarySearch(numeros, 6));
    System.out.println(LocalDateTime.now());
  }

  /**
   * busqueda lineal
     * @param array
   * @param target
   * @return
   */
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
