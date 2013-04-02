package org.cara.dojo.dojo69.application;

import java.util.List;

public class Filtering {

	private Filter filter;
	
	public Filtering(Filter filter) {
		this.filter = filter;
  }
	
  public void filter(Arguments arguments)  {

    List<String> filterFiles = arguments.getFilterFiles();
    String fileToProcess = arguments.getFileToProcess();
    String fileProcessed = arguments.getFileProcessed();
    filter.filter(fileToProcess, fileProcessed, filterFiles);
  }

}
