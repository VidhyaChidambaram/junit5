package com.learn.junit5;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
public class ServerConnectivityTest {

  /**
   * This is an example of usage of @Tag annotation Tagging will help isolate tests that should be
   * run on build vs local. Refer the pom.xml for surefire settings for excluding the tag named
   * "integration"
   */
  @Test
  public void testRedisServer() {
    fail("This test should fail if run on jenkins");
  }
}
