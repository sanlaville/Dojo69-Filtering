package org.cara.dojo.dojo69.application;

import java.util.Arrays;
import java.util.List;

public class Arguments {

  private String fileToProcess;
  private String fileProcessed;
  private List<String> filterFiles;

  Arguments(String fileToProcess, String fileProcessed,
      List<String> filterFiles) {
	  this.fileToProcess = fileToProcess;
	  this.fileProcessed = fileProcessed;
	  this.filterFiles = filterFiles;
  }

	public static Arguments parse(String[] args) {
		
		final int nbMinExpectedArgs = 2;
		if (args == null || args.length < nbMinExpectedArgs) {
			throw new IllegalArgumentException("Expecting at least "
					+ nbMinExpectedArgs + " arguments.");
		}
		String[] remainingArgs = Arrays.copyOfRange(args, 2, args.length);
		return new Arguments(args[0], args[1], Arrays.asList(remainingArgs));
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
