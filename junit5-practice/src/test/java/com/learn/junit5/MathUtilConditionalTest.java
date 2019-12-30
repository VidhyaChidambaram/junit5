package com.learn.junit5;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import com.learn.junit5.exceptions.MathUtilsException;

@TestInstance(Lifecycle.PER_CLASS)
public class MathUtilConditionalTest {

  MathUtils mathUtils;

  @BeforeAll
  public void envSetup() {
    System.setProperty("env", "DEV");
  }

  @BeforeEach
  void setUp() throws Exception {
    mathUtils = new MathUtils();
  }

  /**
   * Nested collection of tests for {@link MathUtils#add(int, int)} method
   * 
   * @author vidhy
   *
   */
  @Nested
  @DisplayName("add method test suite")
  class TestAdd {

    @RepeatedTest(3)
    public void testAdd() throws MathUtilsException {
      int result = mathUtils.add(1, 3);
      Assertions.assertEquals(4, result);
    }

    @Test
    public void testAddException() {
      assertThrows(MathUtilsException.class, () -> mathUtils.add(0, 0),
          "MathUtilsException expected when both inputs are zero");
    }

  }


  @Test
  @EnabledIfSystemProperty(named = "env", matches = "DEV")
  public void testConditionalExecution() {
    assertEquals("DEV", System.getProperty("env"));
  }

  @Test
  @DisplayName("MathUtils.testCreateFibonacci")
  void testCreateFibonacci() {
    int[] fibonacci10 = new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
    Assertions.assertAll(
        () -> assertThrows(MathUtilsException.class, () -> mathUtils.createFibonacci(0),
            "MathUtilsException was not thrown"),
        () -> assertArrayEquals(fibonacci10, mathUtils.createFibonacci(10)));
  }


  @AfterEach
  void tearDown() throws Exception {}
}
