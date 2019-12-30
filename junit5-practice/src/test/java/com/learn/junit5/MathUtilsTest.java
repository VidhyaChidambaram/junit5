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
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import com.learn.junit5.exceptions.MathUtilsException;

/**
 * @author vidhy
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class MathUtilsTest {

  MathUtils mathUtils;

  private TestInfo testInfo;

  private TestReporter testReporter;

  @BeforeAll
  public void envSetUp() {
    System.setProperty("env", "DEV");
  }

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp(TestInfo testInfo, TestReporter testReporter) throws Exception {
    mathUtils = new MathUtils();
    this.testInfo = testInfo;
    this.testReporter = testReporter;
  }

  @Test
  @DisplayName("testAdd_Success")
  public void testAdd_Success() throws MathUtilsException {
    testReporter.publishEntry("started Test :" + testInfo.getDisplayName());
    int result = mathUtils.add(1, 2);
    testReporter.publishEntry("End Test " + testInfo.getDisplayName());
    Assertions.assertEquals(5, result, testInfo.getDisplayName() + " failed");
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

  /**
   * If a test is disabled this will not run. As of JUnit Jupiter, @Ignore does not work anymore
   * unless vintage is used
   */
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
