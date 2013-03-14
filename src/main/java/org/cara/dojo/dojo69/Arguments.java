package org.cara.dojo.dojo69;

import java.util.ArrayList;
import java.util.List;

public class Arguments {

  private List<String> filterFiles;
  private String fileToProcess;

  public void parse(String[] args) {

    final int nbMinExpectedArgs = 2;
    if (args == null || args.length < nbMinExpectedArgs) {
      throw new IllegalArgumentException("Expecting at least "
          + nbMinExpectedArgs + " arguments.");
    }
    fileToProcess = args[0];
    filterFiles = new ArrayList<String>();
    for (int i = 1; i < args.length; ++i) {
      filterFiles.add(args[i]);
    }
  }

  public List<String> getFilterFiles() {

    return filterFiles;
  }

  public String getFileToProcess() {

    return fileToProcess;
  }

}
