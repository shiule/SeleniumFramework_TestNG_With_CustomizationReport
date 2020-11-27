package src_main_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {

	public static Properties readFile(String fileName) throws IOException {
		FileInputStream inputFileName = null;
		Properties prop = null;
		try {
			inputFileName = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(inputFileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			inputFileName.close();
		}
		return prop;

	}

}
