package org.cara.dojo.dojo69;

import java.io.IOException;
import org.apache.maven.shared.filtering.MavenFilteringException;

public class Main {

  public static void main(String[] args) throws MavenFilteringException,
      IOException {

    Arguments arguments = new Arguments();
    arguments.parse(args);

    // valorize the the file from the config file
    Filtering valorization = new Filtering();
    valorization.filter(arguments);
  }

}
