package org.cara.dojo.dojo69.main;

import java.io.IOException;
import org.apache.maven.shared.filtering.MavenFilteringException;
import org.cara.dojo.dojo69.adapter.plexus.PlexusFilter;
import org.cara.dojo.dojo69.application.Arguments;
import org.cara.dojo.dojo69.application.Filtering;

public class Main {

  public static void main(String[] args) throws MavenFilteringException,
      IOException {

    Arguments arguments = Arguments.parse(args);

    // valorize the the file from the config file
    Filtering valorization = new Filtering(new PlexusFilter());
    valorization.filter(arguments);
  }

}
