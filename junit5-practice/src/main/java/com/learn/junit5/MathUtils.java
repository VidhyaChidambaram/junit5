package com.learn.junit5;

import com.learn.junit5.exceptions.MathUtilsException;

/**
 * Test class to add some mathematical operations to test with junit5
 * 
 * @author vidhy
 *
 */
public class MathUtils {

  public int add(int a, int b) {
    return a + b;
  }

  public int[] createFibonacci(int noOfSeries) throws MathUtilsException {
    if (noOfSeries == 0 || noOfSeries == 1) {
      throw new MathUtilsException("noOfSeries received 0, required minimum 3");
    }
    int[] fibonacciSeries = new int[noOfSeries];
    fibonacciSeries[0] = 0;
    fibonacciSeries[1] = 1;
    for (int i = 2; i < fibonacciSeries.length; i++) {
      fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
    }
    return fibonacciSeries;
  }
}
