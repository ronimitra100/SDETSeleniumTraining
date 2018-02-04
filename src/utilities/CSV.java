package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	public static List<String[]> get(String filename){
		List<String[]> data = new ArrayList<String[]>();
		String row;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while((row=br.readLine())!=null) {
				String[] line = row.split(",");
				data.add(line);
			}
			br.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found: " + filename);
		}
		catch(IOException e) {
			System.out.println("ERROR: Error reading file: " + filename);
		}
		return data;
	}

}
