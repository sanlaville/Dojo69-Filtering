package org.cara.dojo.dojo69;

import java.io.File;
import java.io.IOException;
import org.apache.maven.shared.filtering.MavenFilteringException;
import org.codehaus.plexus.util.FileUtils;

public class Filtering {

  public void filter(Arguments arguments) throws MavenFilteringException,
      IOException {

    StandardFilterWrapper filterWrapper =
        new StandardFilterWrapper(arguments.getFilterFiles());

    filter(arguments.getFileToProcess(),arguments.getFileProcessed(), filterWrapper);
  }

  private void filter(String inputFile, String outputFile, StandardFilterWrapper filterWrapper)
      throws IOException {

    File from = new File(inputFile);
    File to = new File(outputFile);

    FileUtils.FilterWrapper[] wrappers =
        new FileUtils.FilterWrapper[] { filterWrapper };
    FileUtils.copyFile(from, to, "UTF-8", wrappers);
  }

}
