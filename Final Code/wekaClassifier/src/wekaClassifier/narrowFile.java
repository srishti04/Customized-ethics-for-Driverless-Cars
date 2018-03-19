package wekaClassifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class narrowFile 
{
	String inTempFile = "/Users/srishti/Desktop/Code/codeFiles/temp.csv"; 
	String outTempFile = "/Users/srishti/Desktop/Code/codeFiles/temp.arff"; 
	public void createFile(String filePath, String inCat)
	{
		String line = "";
		String splitBy = ",";
		BufferedReader br;
		BufferedWriter bw;
        try 
        {
        	br = new BufferedReader(new FileReader(filePath));
        	bw = new BufferedWriter(new FileWriter(inTempFile));
        	int i = 0;
        	while ((line = br.readLine()) != null)
        	{
        		if(i == 0)
        		{
        			bw.write(line);
        			bw.newLine();
        		}
        		
        		String[] catName = line.split(splitBy);
        		String category = catName[8];
        		
        		if(category.equals(inCat))
        		{
        			//add the complete row to a new temp excel file
        			bw.write(line);
        			bw.newLine();
        		}
        		i++;
        	}
        	
        	br.close();
        	bw.close();
        }
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
	}
	
	public void convertToArff()
	{
		File f = new File(outTempFile);
		if(f.exists() && !f.isDirectory())
		{
			f.delete();
		}
		
		new arffConverter().convert(inTempFile, outTempFile);
	}
}
