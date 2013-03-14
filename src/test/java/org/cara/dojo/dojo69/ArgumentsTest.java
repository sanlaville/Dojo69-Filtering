package org.cara.dojo.dojo69;

import org.cara.dojo.dojo69.Arguments;
import org.fest.assertions.api.Assertions;
import org.junit.Test;


public class ArgumentsTest {

  @Test(expected = IllegalArgumentException.class)
  public void parse_Should_ThrowException_IfLessThan2Arguments() {

    // Given
    Arguments arguments = new Arguments();
    String args[] = new String[] { "one" };

    // When
    arguments.parse(args);

    // Then
    // Exception thrown
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_Should_ThrowException_IfArgumentsAreNull() {

    // Given
    Arguments arguments = new Arguments();

    // When
    arguments.parse(null);

    // Then
    // Exception thrown
  }

  @Test
  public void parse_Should_ReadArguments() {

    // Given
    Arguments arguments = new Arguments();
    String arg1 = "one";
    String arg2 = "two";
    String arg3 = "three";
    String arg4 = "four";
    String args[] = new String[] { arg1, arg2, arg3, arg4 };

    // When
    arguments.parse(args);

    // Then
    Assertions.assertThat(arguments.getFileToProcess()).isEqualTo(arg1);
    Assertions.assertThat(arguments.getFilterFiles()).containsExactly(arg2,
        arg3, arg4);
  }
}
