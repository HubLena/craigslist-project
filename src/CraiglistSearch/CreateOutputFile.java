package CraiglistSearch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import com.csvreader.CsvWriter;

public class CreateOutputFile {
	public static void outputFile(HashSet<JavaPosition> positions) {
		// TODO Auto-generated method stub
		// String csv = "C:\\output.csv";
		String outputFile = "C:\\Users\\GF\\Java_output\\output_position.csv";

		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();

		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile), ',');

			// if the file didn't already exist then we need to write out the
			// header line
			if (!alreadyExists) {
				csvOutput.write("posted date");
				csvOutput.write("title");
				csvOutput.write("demographic");

				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line

			for (JavaPosition position : positions) {
				csvOutput.write(position.getPostedDate());
				csvOutput.write(position.getTitle());
				csvOutput.write(position.getDemographic());
				csvOutput.endRecord();
			}

			csvOutput.close();
			System.out.println("The file is created. ");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

