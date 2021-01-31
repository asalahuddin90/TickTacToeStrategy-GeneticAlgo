package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.control.TextArea;

/* This class creates the results file in the specified directory
 * When a good strategy is found, then this class is called to create the results file.
 * R code attached with the project is used to create a graph using the file created from this class.
 */
public class FileManager
{
//	String filePath = "C:\\Users\\Ahmad\\Documents\\RStudioWorkingDir\\geneticTTT.csv";
	String filePath = "."; //default folder to create file with generations and losses count of best strategy
	File textFile = new File(filePath);
	public boolean writeFile( StringBuilder data)
	{

		try (BufferedWriter out = new BufferedWriter( new FileWriter(this.textFile.getPath())))
		{
			out.write(data.toString());
		} 
		catch (IOException e) 
		{
			return false;
		}

		return true;
	}
	
	public StringBuilder readFile() 
	{
		StringBuilder fileContent = new StringBuilder();
		try{
			Scanner text = new Scanner(new File(this.textFile.getName())); //user enters file name
			while (text.hasNextLine())
			{
				fileContent.append(text.nextLine()+ "\n");				
			}
			text.close();
		}
		catch(Exception e)
		{
			System.out.println("The file could not be read.");
		}
		
		return fileContent;				
	}
}
