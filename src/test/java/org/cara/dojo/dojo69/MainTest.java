package org.cara.dojo.dojo69;

import java.util.List;

import org.approvaltests.Approvals;
import org.junit.Test;


public class MainTest {
	
	@Test
	public void approvalTests() throws Exception
	{
		// Given
		String expectedFileFilteredPath = "target/test-classes/config-filtered.properties";
		String[] args = new String[]{"target/test-classes/config.properties", expectedFileFilteredPath, "target/test-classes/filter1.properties", "target/test-classes/filter2.properties"};
		
		// When
		Main.main(args);
		
		// Then	
		List<String> keys = TestUtils.getFilteredKeys(expectedFileFilteredPath);
		Approvals.verifyAll("key", keys);
	}

}
