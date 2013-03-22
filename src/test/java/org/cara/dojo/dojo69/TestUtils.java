package org.cara.dojo.dojo69;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

	public static List<String> getFilteredKeys(String pathFile) {
		BufferedReader br = null;
		List<String> keys = new ArrayList<String>();
	
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(pathFile));
	
			while ((sCurrentLine = br.readLine()) != null) {
				keys.add(sCurrentLine);
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return keys;
	}

}
