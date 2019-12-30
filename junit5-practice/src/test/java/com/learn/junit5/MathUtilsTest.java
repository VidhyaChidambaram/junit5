/**
 * 
 */
package com.learn.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import com.learn.junit5.exceptions.MathUtilsException;

/**
 * @author vidhy
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class MathUtilsTest {

  MathUtils mathUtils;

  @BeforeAll
  public void envSetUp() {
    System.setProperty("env", "DEV");
  }

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    mathUtils = new MathUtils();
  }

  @Test
  public void testAdd_Success() {
    int result = mathUtils.add(1, 4);
    Assertions.assertEquals(5, result, "testAdd_Success failed");
  }

  @Test
  @DisplayName("MathUtils.createFibonacci_success")
  public void testCreateFibonacci() throws MathUtilsException {
    int[] fibonacci10 = new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
    int[] fibonacci20 = new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987,
        1597, 2584, 4181};
    Assertions.assertArrayEquals(fibonacci10, mathUtils.createFibonacci(10),
        "createFibonacci failed : ");
    Assertions.assertArrayEquals(fibonacci20, mathUtils.createFibonacci(20),
        "createFibonacci failed : ");
  }

  @Test
  @DisplayName("MathUtils.createFibonacci_exception")
  public void testCreateFibonacciException() {
    Assertions.assertThrows(MathUtilsException.class, () -> mathUtils.createFibonacci(0),
        "MathUtilsException should be thrown for input=0");
    Assertions.assertThrows(MathUtilsException.class, () -> mathUtils.createFibonacci(1),
        "MathUtilsException should be thrown for input=1");
  }

  @Test
  @Disabled
  public void test_UnimplementedFeature() {
    Assertions.fail("This test fails");
  }

  @AfterEach
  void tearDown() {
    mathUtils = null;
  }

}
