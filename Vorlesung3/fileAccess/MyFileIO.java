package fileAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Stephanie Böhning
 * @version v.01
 * 
 * modified: 18.03.2016
 * 
 * This example should show you how to write data in files and read it from it.
 * Have fun!
 */
public class MyFileIO {

	private File file;
	private String text = "";

	/**
	 * This constructor opens a file with the specified name.
	 * 
	 * @param name This String is the name of the file which should be opened
	 */
	public MyFileIO(String name) {
		file = new File(name);
	}
	
	/**
	 * This method writes the data from text in a file and appends the new user data
	 * 
	 * @param message is a String it will be append at the end
	 */
	public void useWriterStream (String message) {
		
		try {
			FileWriter fOut = new FileWriter(file);
			BufferedWriter bufOut = new BufferedWriter(fOut);

			text += message + "\n";
			bufOut.write(text);
			
			bufOut.close();
			fOut.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * This method reads all data from file.
	 * 
	 * @return a String with the read data
	 */
	public String useReaderStream () {
		String data = "";

		try {
			
			FileReader reader = new FileReader(file);
			BufferedReader bufIn = new BufferedReader(reader);
			String line = bufIn.readLine();
			
			while (line != null) {
				data += line + "\n";
				line = bufIn.readLine();				
			}

			bufIn.close();
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	
	public void usePrintWriter (String message) {

		try {
			FileWriter fOut = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fOut);

			text += message + "\n";
			pw.println(text);
			
			pw.close();
			fOut.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String useScanner () {
		String data = "";
		Scanner scan;
		try {
			scan = new Scanner(file);	
			
			while (scan.hasNextLine()) {
				data += scan.nextLine() + "\n";
			}

			scan.close();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static void main(String[] args) {
		MyFileIO file = new MyFileIO("UserData.txt");
		String data = "";
		
		file.useWriterStream("Name: Mütze");
		file.useWriterStream("Givenname: Max");

		data = file.useReaderStream();
		System.out.println("In file:\n" + data);
		
		file.useWriterStream("Nickname: Kaulquappe");

		data = file.useReaderStream();
		System.out.println("In file:\n" + data);
	
	}

}
