package org.cara.dojo.dojo69;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.Assertions;
import org.junit.Test;


public class FilteringTest {

	@Test
	public void filter_Should_GenerateFilteredFile_WithExpectedKey()
			throws Exception {
		// Given
		Filtering filtering = new Filtering();
		
		String fileToProcess = "target/test-classes/config.properties";
		String fileProcessed = "target/test-classes/config-filtered.properties";
		
		List<String> filterFiles = new ArrayList<String>();
		filterFiles.add("target/test-classes/filter1.properties");
		filterFiles.add("target/test-classes/filter2.properties");

		IArguments arguments = new ArgumentsMock(fileToProcess, fileProcessed, filterFiles);
		
		// When
		filtering.filter(arguments);
		
		// Then
		File expectedFileProcessed = new File("target/test-classes/FilteringTest.filter_Should_GenerateFilteredFile_WithExpectedKey.approved.txt");
		File actualFileProcessed = new File(fileProcessed);
		Assertions.assertThat(actualFileProcessed).hasContentEqualTo(expectedFileProcessed);
	}
}
