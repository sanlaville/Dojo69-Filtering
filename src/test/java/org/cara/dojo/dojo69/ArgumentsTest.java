package org.cara.dojo.dojo69;

import org.fest.assertions.api.Assertions;
import org.junit.Assert;
import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class ArgumentsTest {

  @TestWith({"null", "one"})
  public void parse_Should_ThrowException_IfLessThan2Arguments(String args[]) {

    // Given
    Arguments arguments = new Arguments();

    // When
    try
    {
    	arguments.parse(args);
    	Assert.fail("Expected an IllegalArgumentException but was not thrown.");
    }
    catch (IllegalArgumentException iae)
    {
    	// Then
    	// Excepted an IllegalArgumentException
    }
  }
  
  @TestWith({"one:two", "one:two:three", "one:two:three:four", "one:two:three:four:five:six:seven"})
  public void parse_Should_ReadArguments(String[] args) {

    // Given
    Arguments arguments = new Arguments();


    // When
    arguments.parse(args);

    // Then
    Assertions.assertThat(arguments.getFileToProcess()).isEqualTo(args[0]);
    Assertions.assertThat(arguments.getFileProcessed()).isEqualTo(args[1]);
    
    String[] filterFilesArgs = new String[args.length -2];
    for (int i = 2; i < args.length; i++) {
    	filterFilesArgs[i-2] = args[i];
    }
    Assertions.assertThat(arguments.getFilterFiles()).containsExactly(filterFilesArgs);
   
  }
  
  @Coercion
  public String[] buildArgs(String input) {
	  return input.split(":");
  }
}
