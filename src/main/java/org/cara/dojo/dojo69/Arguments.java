package org.cara.dojo.dojo69;

import java.util.ArrayList;
import java.util.List;

public class Arguments implements IArguments {

	private String fileToProcess;
	private String fileProcessed;
	private List<String> filterFiles;

	public void parse(String[] args) {

		final int nbMinExpectedArgs = 2;
		if (args == null || args.length < nbMinExpectedArgs) {
			throw new IllegalArgumentException("Expecting at least "
					+ nbMinExpectedArgs + " arguments.");
		}
		fileToProcess = args[0];
		fileProcessed = args[1];
		filterFiles = new ArrayList<String>();
		for (int i = 2; i < args.length; ++i) {
			filterFiles.add(args[i]);
		}
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
