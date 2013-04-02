package org.cara.dojo.dojo69.application;

import java.util.List;

public interface Filter {

	void filter(String fileToProcess, String fileProcessed,
      List<String> filterFiles);

}
