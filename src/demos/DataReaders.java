package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		//readCSV();
		readXLS();

	}
	
	public static void readCSV() {
		String filename ="C:\\Users\\ronim_000\\Documents\\UserAccounts.csv";
		List<String[]> records = utilities.CSV.get(filename);
		for (String[] record: records) {
			System.out.println("\nNEW RECORD");
			for(String field:record) {
				System.out.println(field);
			}
		}
		
		
	}
	
	public static void readXLS() {
		String filename = "C:\\Users\\ronim_000\\Documents\\UserLogin.xls";
		String[][] data = utilities.Excel.get(filename);
		for (String[] record: data) {
			for(String cell:record) {
				System.out.println(cell);
			}
		}
		
	}
}
