package wekaClassifier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import weka.core.*;
import weka.core.converters.CSVLoader;

public class arffConverter 
{

	public void convert(String inFile, String outFile)
	{
		try
		{
			// load CSV
		    CSVLoader loader = new CSVLoader();
		    //loader.setSource(new File(args[0]));
		    File f =  new File(inFile);
		    loader.setSource(f);
		    Instances data = loader.getDataSet();
		 
		    // save ARFF
		    /*ArffSaver saver = new ArffSaver();
		    saver.setInstances(data);
		    File f  = new File(outFile);	
		    
		    if(f.exists())
		    {
		    	f.delete();
		    }
		    saver.setFile(f);
		    //saver.setDestination(f);
		    saver.writeBatch();*/
		    
		    // save ARFF
	        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
	        writer.write(data.toString());
	        writer.flush();
	        writer.close(); 
		    
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
			
}
