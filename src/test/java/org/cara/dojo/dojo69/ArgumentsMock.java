package org.cara.dojo.dojo69;

import java.util.List;

public class ArgumentsMock implements IArguments {
	
	private String fileToProcess;
	private List<String> filterFiles;
	private String fileProcessed;

	public ArgumentsMock(String fileToProcess, String fileProcessed, List<String> filterFiles) {
		this.fileToProcess = fileToProcess;
		this.fileProcessed = fileProcessed;
		this.filterFiles = filterFiles;
	}

	public void parse(String[] args) {
		new UnsupportedOperationException("parse method should be not called with ArgumentsMock class");
		
	}

	public List<String> getFilterFiles() {
		return filterFiles;
	}

	public String getFileToProcess() {
		return fileToProcess;
	}

	public String getFileProcessed() {
		return fileProcessed;
	}

}
