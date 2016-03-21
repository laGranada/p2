package fileAccess;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Stephanie Böhning
 * @version v.01
 * 
 * modified: 18.03.2016
 * 
 * This example should show you how to use the class file.
 * Have fun!
 */
public class FileExample {

	private File file;
	
	/**
	 * This constructor opens a file.
	 * 
	 * @param dir is the name of the directory to which you want to have access
	 */
	public FileExample(String dir) {
		file = new File(dir);
		
	}
	
	/**
	 * This method list all files of this directory
	 */
	public void listAllFiles () {
		if (file != null && file.exists() && file.isDirectory()) {

			//get all files in this directory
			File [] listOfFiles = file.listFiles();
			System.out.println("This files are in the directory " + file.getAbsolutePath());

			//print out name of files
			for (File f : listOfFiles) {
				if (f.isFile()) {
					System.out.println(f.getName());
				}
			}
		}
	}
	
	/**
	 * This method list all subdirectories of this directory
	 */
	public void listAllSubdirectorys () {
		if (file != null && file.exists() && file.isDirectory()) {

			//get all files in this directory
			File [] listOfFiles = file.listFiles();
			System.out.println("This subdirectorys are in the directory " + file.getAbsolutePath());
			
			//print out name of directories
			for (File f : listOfFiles) {
				if (f.isDirectory()) {
					System.out.println(f.getName());
				}
			}
		}
	}

	/**
	 * This method renames the file and changes the last modified time.
	 * 
	 * @param newName is the new name of the file
	 * @param newTime is the last modified time of the file. Please use the format "yyyy-MM-dd HH:mm:ss" for changing the time stamp
	 */
	public void changeFile (String newName, String newTime) {
		
		if (file != null && file.exists()) {
			file.renameTo(new File(newName));

			//change time
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {

				//create a date and set the date for the file
				Date time = sdf.parse(newTime);
				file.setLastModified(time.getTime());
				
				//test modified date
				Date checkDate = new Date(file.lastModified());
				System.out.println("This file was modified at: " + checkDate.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		FileExample ex = new FileExample("C:\\Data");

		ex.listAllFiles();
		ex.listAllSubdirectorys();
		ex.changeFile("bla.txt", "2013-11-23 12:43:01");
		
	}

}
