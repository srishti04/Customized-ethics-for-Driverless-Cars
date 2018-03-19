package wekaClassifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class populateLisCatName 
{
	
	String filePath = "/Users/srishti/Desktop/Code/codeFiles/dataset2.csv";
	
	
	public void readExcelFile()
	{

		String line = "";
		String splitBy = ",";
        try 
        {
        	BufferedReader br = new BufferedReader(new FileReader(filePath)); 
        	while ((line = br.readLine()) != null)
        	{
        		String[] catName = line.split(splitBy);
        	}
        }
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
	}
	
	public List<String> populate(List<String> inLis, String inCat)
	{
		
		String line = "";
		String splitBy = ",";
        try 
        {
        	BufferedReader br = new BufferedReader(new FileReader(filePath)); 
        	while ((line = br.readLine()) != null)
        	{
        		String[] catName = line.split(splitBy);
        		//if detected category is equal to category read from each row in dataset
        		if(catName[8].equals(inCat))
        		{
        			inLis.add(catName[9]);	
        		}
        	}
        }
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
		return inLis;
	}
}
