package org.cara.dojo.dojo69.adapter.plexus;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.cara.dojo.dojo69.application.Filter;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.FileUtils.FilterWrapper;

public class PlexusFilter implements Filter {

	public void filter(String fileToProcess, String fileProcessed, List<String> filterFiles) {
		StandardFilterWrapper filterWrapper =
				new StandardFilterWrapper(filterFiles);
	
		File from = new File(fileToProcess);
		File to = new File(fileProcessed);
	
		FilterWrapper[] wrappers =
				new FilterWrapper[] { filterWrapper };
		try {
	    FileUtils.copyFile(from, to, "UTF-8", wrappers);
    } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
	}

}
