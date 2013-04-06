package org.cara.dojo.dojo69;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.fest.assertions.api.Assertions;
import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class FilteringTest {

	@TestWith("target/test-classes/config.properties," +
			  "target/test-classes/config-filtered.properties," + 
			  "target/test-classes/filter1.properties:target/test-classes/filter2.properties," + 
		      "target/test-classes/FilteringTest.filter_Should_GenerateFilteredFile_WithExpectedKey.approved.txt")
	public void filter_Should_GenerateFilteredFile_WithExpectedKey(String fileToProcess, String fileProcessed, String[] filters, String expectedFileProcessedPath)
			throws Exception {
		// Given
		List<String> filterFiles = Arrays.asList(filters);
		IArguments arguments = new ArgumentsMock(fileToProcess, fileProcessed, filterFiles);
		
		Filtering filtering = new Filtering();
		// When
		filtering.filter(arguments);
		
		// Then
		File expectedFileProcessed = new File(expectedFileProcessedPath);
		File actualFileProcessed = new File(fileProcessed);
		Assertions.assertThat(actualFileProcessed).hasContentEqualTo(expectedFileProcessed);
	}
	
	  @Coercion
	  public String[] buildFilters(String input) {
		  return input.split(":");
	  }
}
