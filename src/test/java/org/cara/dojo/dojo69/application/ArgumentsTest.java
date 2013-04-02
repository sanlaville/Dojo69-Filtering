package org.cara.dojo.dojo69.application;

import org.cara.dojo.dojo69.application.Arguments;
import org.fest.assertions.api.Assertions;
import org.junit.Test;


public class ArgumentsTest {

  @Test(expected = IllegalArgumentException.class)
  public void parse_Should_ThrowException_IfLessThan2Arguments() {

    // Given
  	String args[] = new String[] { "one" };

    // When
  	Arguments.parse(args);

    // Then
    // Exception thrown
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_Should_ThrowException_IfArgumentsAreNull() {

    // When
    Arguments.parse(null);

    // Then
    // Exception thrown
  }

  @Test
  public void parse_Should_ReadArguments() {

    // Given
    String arg1 = "one";
    String arg2 = "two";
    String arg3 = "three";
    String arg4 = "four";
    String args[] = new String[] { arg1, arg2, arg3, arg4 };

    // When
    Arguments arguments = Arguments.parse(args);

    // Then
    Assertions.assertThat(arguments.getFileToProcess()).isEqualTo(arg1);
    Assertions.assertThat(arguments.getFileProcessed()).isEqualTo(arg2);
    Assertions.assertThat(arguments.getFilterFiles()).containsExactly(arg3, arg4);
  }
}
