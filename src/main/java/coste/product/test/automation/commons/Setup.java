package coste.product.test.automation.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Setup {

	public static Properties getProp() {
		Properties props = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream("./src/main/resource/setup.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	
	public static String getProp(String prop) {
		Properties props = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream("./src/main/resource/setup.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty(prop);
	}

	public static BufferedReader getQueries() throws IOException {
		File file = new File(
				"." + File.separator + "lib" + File.separator + "data" + File.separator + "DatabaseQueries.txt");
		FileReader fr = new FileReader(file);
		BufferedReader queries = new BufferedReader(fr);
		return queries;
	}
}
