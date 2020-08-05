import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConvertMyFile {

	public static void main(String[] args) throws IOException{
		
		String fileTypeLiteral = "";
		String convertToType = "";
		
		Path filePath;
		
		boolean filePathMatches = false;
		
		//Program name output to console.
		outputProgramName();
		
		//Get the user to input the file type they want to convert.
		
		fileTypeLiteral = getFileType();
		
		//Get the user to input the path to the file location they want to convert.
		
		filePath = getMyPath(fileTypeLiteral);
		
		//Get file name from the path
		
		String filename = filePath.getFileName().toString();
		
		//Make an actual FILE object using File(String pathname)
		
		File file = new File(filePath.toString());
		
		//What type of file do we convert into? Get user input.
		
		convertToType = getFileTypeToConvertInto(fileTypeLiteral);
		
		
		//copy file into eclipse project
	
			if (fileTypeLiteral == ".txt" || fileTypeLiteral == ".TXT") 
			{
								
				File newFile = convertTheTxt(convertToType,file);
				//Goes to createTheFile();
				
				//method that pops up a window with the newly created file type.
				printOutput(newFile, filename, convertToType);
				
			}
			
			else if (fileTypeLiteral == ".csv" || fileTypeLiteral == ".CSV") 
			{
				
				convertTheCsv(convertToType,filename);
				
			}
			else if (fileTypeLiteral == ".xml" || fileTypeLiteral == ".XML") 
			{
				
				convertTheXml(convertToType,filename);
				
			}
			else if (fileTypeLiteral == ".html" || fileTypeLiteral == ".HTML") 
			{
				
				convertTheHtml(convertToType,filename);
			}	
			else if (fileTypeLiteral == ".dat" || fileTypeLiteral == ".DAT") {
				
				convertTheDat(convertToType,filename);
			}	
			else 
			{
				
			}
			
			//close the program
			//Note: close both files here. If the user re-runs the program and one of these files
			//remains open, java will throw an exception.
			//exitThisProgram(newFile, file);
			exitThisProgram();
		}

	private static void outputProgramName() {

		System.out.println("");
		System.out.println("  _______  __   __       _______      ______   ______   .__   __. ____    ____  _______ .______     .___________. _______ .______");      
		System.out.println(" |   ____||  | |  |     |   ____|    /      | /  __  \\  |  \\ |  | \\   \\  /   / |   ____||   _  \\    |           ||   ____||   _  \\");     
		System.out.println(" |  |__   |  | |  |     |  |__      |  ,----'|  |  |  | |   \\|  |  \\   \\/   /  |  |__   |  |_)  |   `---|  |----`|  |__   |  |_)  |");    
		System.out.println(" |   __|  |  | |  |     |   __|     |  |     |  |  |  | |  . `  |   \\      /   |   __|  |      /        |  |     |   __|  |      /");     
		System.out.println(" |  |     |  | |  `----.|  |____    |  `----.|  `--'  | |  |\\   |    \\    /    |  |____ |  |\\  \\----.   |  |     |  |____ |  |\\  \\----.");
		System.out.println(" |__|     |__| |_______||_______|    \\______| \\______/  |__| \\__|     \\__/     |_______|| _| `._____|   |__|     |_______|| _| `._____|");
		System.out.println("Version 2");
		System.out.println("");
	}

	private static File convertTheTxt(String convertToType,File file) throws IOException
	{
	
		//convert from TXT to CSV
		//Step 1.) Create a new .csv file....
		 File newFile = createFile(convertToType);
		
		System.out.println("Writing to file at path " + newFile.getAbsolutePath() + "...");
		
		//Bucky - Read to file - https://www.youtube.com/watch?v=3RNYUKxAgmw
		
		Scanner x = null;
		
		//Bucky - write to files - https://www.google.com/search?q=the+new+boston+write+to+a+file&ie=&oe=#kpvalbx=_g4kEX9fSGM70tAbYrqTYCw18
				
		FileWriter myWriter = new FileWriter(newFile, false);
		
		//First, open and read from the .txt file
		try {
			
			//x = new Scanner(new File("" + filename));///////////reads the filename, not the data
			
			//Should have used this constructor: Scanner(File, String)
			x = new Scanner(file);
			
		}
		catch(Exception e)
		{
			System.out.println("Could not find file to open it");
		}
		
		//Read/Write from file - There are 4 main variables inside the txt file
		try {
			
			//Read first 12 lines (nextLine(), not next()) into comments
				for (int i = 0; i<12; i++)
				{
					String comments = x.nextLine();
					
					//Check that the Compiler compliance level is set to at least 1.5 for your project:
						//Project > Properties > Java Compiler
			
					//1. printf(Locale, String , Object[])
					//2. printf(String, Object[])
					
					// I am  Eclipse IDE for Java Developers Version: 2018-09 (4.9.0) Build id: 20180917-1800
					
					//FileWriter Docs: public FileWriter(String fileName,boolean append) throws IOException
					myWriter.write("#" + comments + "\n");
					 
				}
				
				//flush the writer -----unnecessary when using printf()
				 myWriter.flush();
				
				System.out.println("");
		
				//Read the rest of the file
				while(x.hasNext())
				{
					
					
					//Read from old .txt file
					String internalDate = x.next();
					//Write to new .csv file
					myWriter.write(internalDate + ",");
					
					String internalTime = x.next();
					myWriter.write(internalTime + ",");
					
					String externalDate = x.next();
					myWriter.write(externalDate + ",");
					
					String externalTime = x.next();
					myWriter.write(externalTime + ",");
								
					String bg = x.next();
					myWriter.write(bg);
					
					myWriter.write("\n");
					
				}
		}
		finally 
		{
			x.close();
			myWriter.flush();
			myWriter.close();
		}
	    	
	 return newFile;   
	}
	
		private static void convertTheDat(String convertToType, String filename) 
		{
		// TODO Auto-generated method stub
		
	    }
		//fis = new FileInputStream(filePath);

		private static void convertTheHtml(String convertToType, String filename) {
			// TODO Auto-generated method stub
			
		}

		private static void convertTheXml(String convertToType, String filename) {
			// TODO Auto-generated method stub
			
		}

		private static void convertTheCsv(String convertToType, String filename) {
			// TODO Auto-generated method stub
					
		}

	private static String getFileExtension(String filePath) {
	    
	    int lastIndexOf = filePath.lastIndexOf(".");
	    
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return filePath.substring(lastIndexOf);
	}
	
	private static Boolean checkExtension(String fileTypeLiteral, String extension) {
	    
		Boolean extensionsMatch = false;
		
	    if (fileTypeLiteral.equals(extension)) {
	    	
	    	extensionsMatch = true;
	    	System.out.println("\n fileTypeLiteral = " + fileTypeLiteral + " & String extension = " +  extension);
	        
	    }
	    return extensionsMatch;
	}
	
	private static String getFileType() {
		
		char fileType = 'F';
		boolean validInput = false;
		String fileTypeLiteral = "";
		
		do 
		{
			try {
				System.out.println("Enter the file type you wish to convert");
				System.out.println("      c = .csv   d = .dat   h = .html   t = .txt  x = .xml");
				System.out.print(">> ");

				Scanner fileTypeUserInput = new Scanner(System.in);
				fileType = fileTypeUserInput.next().charAt(0);
			
				validInput = true;
			
			}catch (Exception e) //custom exception class 
			{
				System.out.print("\n Invalid input. Please enter c, d, h, t, or x >> ");
				//Log the invalid input in log file -----------
			}
			finally 
			{
				
				if (fileType == 'c' || fileType == 'C') {fileTypeLiteral = ".csv";}
				else if (fileType == 'd' || fileType == 'D') {fileTypeLiteral = ".dat";}
				else if (fileType == 'h' || fileType == 'H') {fileTypeLiteral = ".html";}
				else if (fileType == 't' || fileType == 'T') {fileTypeLiteral = ".txt";}
				else if (fileType == 'x' || fileType == 'X') {fileTypeLiteral = ".xml";}
				
				else {fileTypeLiteral = "INPUT FILETYPE ERROR LINE 26, filename: ConvertMyFile.java";} //log error 
			}
			
		} while (!validInput);
		
	return fileTypeLiteral;
	}
	
	private static Path getMyPath(String fileTypeLiteral) {
		
		String filePath;
		Path myPath = null;
		Boolean match;
		
		do
		{
		
			// Get path to file 
			
			System.out.println("\n Enter the path to your " + fileTypeLiteral + " file that you wish to convert. ");
			System.out.println("Or, enter 'a' to use the default " + fileTypeLiteral + " contained in this project.");
			System.out.print(">> ");
		
			Scanner filePathUserInput = new Scanner(System.in);
			filePath = filePathUserInput.nextLine();
			
			//Use default text file included in this project
			if (filePath.toString().equals("a") && (fileTypeLiteral == ".txt"|| fileTypeLiteral == ".TXT"))	
			{
				filePath = "C:\\Users\\Bob Ross\\Desktop\\workspace\\ConvertFile\\M,HeatherBGDataJune5.txt";
			}
			else if (filePath.toString().equals("a") && (fileTypeLiteral == ".dat" || fileTypeLiteral == ".DAT"))
			{
				filePath = "SCHEMA.dat";
			}
			//Does this file exist?????
			//System.out.print("\nInsert code here... ");
			
		
		
			//check that this is the anticipated file type.
			String myExtension = getFileExtension(filePath);
			match = false;
			match = checkExtension(fileTypeLiteral, myExtension);
			
			//System.out.println("\nmyExtension = " + myExtension);
	   
			if (match != true)
			{
				System.out.println("\nThe path that you entered does not lead to an anticipated " + fileTypeLiteral + " file");	
				//Allow the user to re-enter the desired file type for conversion
				fileTypeLiteral = getFileType();
				System.out.println("\ngetFileType() = " + getFileType());
			}
			else
			{
				//cast String into Path
				myPath = Paths.get(filePath);
				System.out.println("\n You can now convert File Name: " + myPath.getFileName() + "\n into another format.\n");
			}
	    
			} while (!match);
		
	return myPath;	
	}
	
	private static String getFileTypeToConvertInto(String convertFrom) {
		
		char fileType = 'F';
		boolean validInput = false;
		String fileTypeLiteral = convertFrom;
		
		do 
		{
			try {
				System.out.println("Enter the file type that you wish to convert your " + convertFrom + " file into.");
				System.out.println("      c = .csv   d = .dat   h = .html   t = .txt  x = .xml");
				System.out.print(">> ");

				Scanner fileTypeUserInput = new Scanner(System.in);
				fileType = fileTypeUserInput.next().charAt(0);
			
				validInput = true;
			
			}catch (Exception e) //custom exception class 
			{
				System.out.print("\n Invalid input. Please enter c, d, h, t, or x >> ");
				//Log the invalid input in log file -----------
			}
			finally 
			{
				
				if (fileType == 'c' || fileType == 'C') {fileTypeLiteral = ".csv";}
				else if (fileType == 'd' || fileType == 'D') {fileTypeLiteral = ".dat";}
				else if (fileType == 'h' || fileType == 'H') {fileTypeLiteral = ".html";}
				else if (fileType == 't' || fileType == 'T') {fileTypeLiteral = ".txt";}
				else if (fileType == 'x' || fileType == 'X') {fileTypeLiteral = ".xml";}
				
				else {fileTypeLiteral = "INPUT FILETYPE ERROR LINE 26, filename: ConvertMyFile.java";} //log error 
			}
			
		} while (!validInput);
		
	return fileTypeLiteral;
	}


	private static File createFile(String convertTo)
	{
		String newFileName = "";
		String myPath = "";
		
		if (convertTo == ".csv") {newFileName = "myNewFile.csv";}
		else if (convertTo == ".xml") {newFileName = "myNewFile.xml";}
		else if (convertTo == ".html") {newFileName = "myNewFile.html";}
		else if (convertTo == ".dat") {newFileName = "myNewFile.dat";}
		else if (convertTo == ".txt") {newFileName = "myNewFile.txt";}
		
		File myObj = new File(""+ newFileName);
		
		 try {
			 
		     if (( myObj).createNewFile()) 
		     {
		    	  myPath = myObj.getAbsolutePath();
		        System.out.println("File created: " + myObj.getName());
		      } 
		      else 
		      {
		        System.out.println("File already exists @ " + myObj.getAbsolutePath());
		        myPath = myObj.getAbsolutePath();
		      }
		    } 
		    catch (IOException e) 
		    {
		      System.out.println("An error occurred while creating the new file (line 512). ");
		      e.printStackTrace();
		    }

		   
		 return myObj;
		} 
	
		private static void printOutput(File newFile, String filename, String convertToType) throws IOException
		{
			//first check if Desktop is supported by Platform or not
			// https://www.journaldev.com/864/java-open-file////////////////////////
			
			        if(!Desktop.isDesktopSupported()){
			            
			        	System.out.println("Desktop is not supported");
			            return;
			        }
			        else {
			        	
			        Desktop desktop = Desktop.getDesktop();
			        
				        //let's try to open csv file 
	
				        if(newFile.exists()) {
				        	//System.out.println("newFile = " + newFile);
				        	desktop.open(newFile);
				        }
				        
				        //System.out.println("\nDesktop is supported. Pop up window containing file....");
				        
						System.out.println("\n-----------------------------------------------------------------------");
						System.out.println("\n   " + filename + " was converted into " + convertToType + " file.");
						System.out.println("\n-----------------------------------------------------------------------");
						
						System.out.print("\n Please close the new file that opened in the pop up window... ");
				
			        }
	   
		}
		
		private static void exitThisProgram()
		{
			//Exit the program here....	
			//exitThisProgram();
			
			System.out.println("To exit the program, input X");
			System.out.print(">>");
			
			Scanner s = null; 
			
			try
			{
				s = new Scanner(System.in);
				s.next();
			}
			catch (Exception e) //custom exception class 
			{
				System.out.print("\n Invalid input. Please enter x >> ");
				//Log the invalid input in log file -----------
			}
			if (s.equals("x")  || s.equals("X"))
			{
					System.exit(0);
			}
			
		}
		
}	


