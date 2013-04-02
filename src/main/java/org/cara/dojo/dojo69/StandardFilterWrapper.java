package org.cara.dojo.dojo69;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.codehaus.plexus.interpolation.InterpolatorFilterReader;
import org.codehaus.plexus.interpolation.PropertiesBasedValueSource;
import org.codehaus.plexus.interpolation.StringSearchInterpolator;
import org.codehaus.plexus.interpolation.ValueSource;
import org.codehaus.plexus.util.FileUtils;

public class StandardFilterWrapper extends FileUtils.FilterWrapper {

  private List<ValueSource> valueSources;

  public StandardFilterWrapper(List<String> filterFiles) {

    valueSources = new ArrayList<ValueSource>();

    for (String filterFile : filterFiles) {
      ValueSource valueSource = readFilterFile(filterFile);
      valueSources.add(valueSource);
    }
  }

  private ValueSource readFilterFile(String filterFilePath) {

    Properties properties = new Properties();
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(filterFilePath);
      properties.load(fis);
    } catch (IOException e) {
      throw new IllegalArgumentException("Filter file " + filterFilePath
          + " could not be read", e);
    } finally {
      try {
        if (fis != null) {
          fis.close();
        }
      } catch (IOException e) {
        throw new IllegalArgumentException("Filter file " + filterFilePath
            + " could not be closed", e);
      }
    }
    return new PropertiesBasedValueSource(properties);
  }

  @Override
  public Reader getReader(Reader fileReader) {

    StringSearchInterpolator propertiesInterpolator =
        new StringSearchInterpolator();
    for (ValueSource valueSource : valueSources) {
      propertiesInterpolator.addValueSource(valueSource);
    }
    InterpolatorFilterReader interpolatorFilterReader =
        new InterpolatorFilterReader(fileReader, propertiesInterpolator);
    interpolatorFilterReader.setInterpolateWithPrefixPattern(false);
    return interpolatorFilterReader;
  }
}
