package org.cara.dojo.dojo69.main;

import java.io.File;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class ApplicationTest {

	File expectedFileProcessed = new File("target/test-classes/FilteringTest.filter_Should_GenerateFilteredFile_WithExpectedKey.approved.txt");
	String fileProcessed = "target/test-classes/config-filtered.properties";
	 
	@Before
	public void initBeforeTest() throws Exception {
		File fileFromLastExecution = new File(fileProcessed);
		if (fileFromLastExecution.exists())
			fileFromLastExecution.delete();
	}
		
	@Test
	public void filter_Should_GenerateFilteredFile_WithExpectedKey()
			throws Exception {
		// Given
		String fileToProcess = "src/test/resources/config.properties";
		String[] args = new String[] {fileToProcess, fileProcessed, "target/test-classes/filter1.properties", "target/test-classes/filter2.properties"};

		// When
		Main.main(args);
		
		// Then
		File actualFileProcessed = new File(fileProcessed);
		Assertions.assertThat(actualFileProcessed).hasContentEqualTo(expectedFileProcessed);
	}
}
