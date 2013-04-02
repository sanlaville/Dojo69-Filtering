package org.cara.dojo.dojo69.application;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;


public class FilteringTest {

	@Test public void 
	filter_destructures_arguments_and_calls_filter() throws Exception {
		Filter filter = mock(Filter.class);
		Filtering filtering = new Filtering(filter);
		String inputPlaceholder = "inputFile";
		String outputPlaceholder = "outputFile";
		List<String> filtersPlaceHolder = asList("key1=value1");

		//no mocking of arguments because it is a ValueObject 
		// http://www.mockobjects.com/2007/04/test-smell-everything-is-mocked.html
		filtering.filter(new Arguments(inputPlaceholder, outputPlaceholder, filtersPlaceHolder));
		
		verify(filter).filter(inputPlaceholder, outputPlaceholder, filtersPlaceHolder);
	}
}
