package org.cara.dojo.dojo69.application;

import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.io.File;
import java.util.List;

import org.cara.dojo.dojo69.adapter.plexus.PlexusFilter;
import org.cara.dojo.dojo69.application.Filter;
import org.junit.Before;
import org.junit.Test;

public abstract class FilterTest {

	String fileProcessed = "target/test-classes/config-filtered.properties";
	Filter filter;

	protected abstract PlexusFilter newFilter();

	@Before
  public void initBeforeTest() throws Exception {
  	File fileFromLastExecution = new File(fileProcessed);
  	if (fileFromLastExecution.exists())
  		fileFromLastExecution.delete();
  }

	@Test
  public void filter_Should_GenerateFilteredFile_WithExpectedKey()
      throws Exception {
      	String fileToProcess = "src/test/resources/config.properties";
      	List<String> filterFiles = asList("target/test-classes/filter1.properties", "target/test-classes/filter2.properties");
      	
      	
      	filter = newFilter();
      	filter.filter(fileToProcess, fileProcessed, filterFiles );
      	
      	// Then
      	File expectedFileProcessed = new File("target/test-classes/FilteringTest.filter_Should_GenerateFilteredFile_WithExpectedKey.approved.txt");
      	File actualFileProcessed = new File(fileProcessed);
      	assertThat(actualFileProcessed).hasContentEqualTo(expectedFileProcessed);
      }

}