package org.cara.dojo.dojo69.application;

import java.util.Arrays;
import java.util.List;

public class Arguments {

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
    
    String[] copyOfRange = Arrays.copyOfRange(args, 2, args.length);
    filterFiles = Arrays.asList(copyOfRange);
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
