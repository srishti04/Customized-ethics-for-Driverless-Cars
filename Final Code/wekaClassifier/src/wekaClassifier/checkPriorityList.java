package wekaClassifier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class checkPriorityList 
{
	String filePath = "/Users/srishti/Desktop/Code/codeFiles/defaultPriorityList.csv";
	
	
	List<String> getList = new ArrayList<String>();
	
	//read file loads the priority list in data structure getList
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
        		getList.add(catName[0]);
        	}
        }
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
	}
	
	public String result(List<String> inObj)
	{
		readExcelFile();
		
		String toHit = null;
		HashMap<Integer, String> tempMap = new HashMap<Integer, String>();
		
		
		int maxVal = -1;
		
		for(String str : inObj)
		{
			//getList is the priority list
			if(getList.contains(str))
			{
				int priority = getList.indexOf(str);
				tempMap.put(priority, str);
			} 
			
		}
		
		// after this for loop, hashmap will have something like
		//23 - child1
		//55 - adult4
		//61 - senior2
		
		for(int val : tempMap.keySet())
		{
			if(val > maxVal)
			{
				maxVal = val;
			}
		}
		// maxVal = 61 after this
		
		if(maxVal != -1)
		{
			toHit = tempMap.get(maxVal);	
		}
		return toHit;
	}
}
