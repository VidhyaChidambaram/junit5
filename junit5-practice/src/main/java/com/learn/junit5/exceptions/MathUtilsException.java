package com.learn.junit5.exceptions;

public class MathUtilsException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public MathUtilsException(String message) {
    super(message);
  }

  public MathUtilsException(String message, Throwable err) {
    super(message, err);
  }
}
