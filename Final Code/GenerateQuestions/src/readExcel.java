


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class readExcel 
{
	
	ArrayList<options> objLis = new ArrayList<options>();
	
	//file location
	String file = "/Users/srishti/Desktop/Code/codeFiles/ex2.csv";
	
	public void readFile()
	{
			String line = "";
			String splitBy = ",";
	        try 
	        {
	        	BufferedReader br = new BufferedReader(new FileReader(file));
	        	int i = 0;
	        	while ((line = br.readLine()) != null)
	        	{
	        		if(i == 0)
	        		{
	        			i++;
	        			continue;
	        		}
	        		//catname contains all values from a single line
	        		String[] catName = line.split(splitBy);
	        		createList(catName); 
	        	}
	        	// at the end of while loop we will have all the values of each row as objects in the object list(objLis)
	        	br.close();
	        }
	        catch (Exception ex) 
	        {
	        	ex.printStackTrace();
	        }
	        
			//printing priority before answering questions -- code under test
			System.out.println("printing priority before answering questions");
			printLis();
			
			//method to sort the list by answering questions
			sortList();
			System.out.println("Priorities decided. Your car is ready for autonomous driving.");
			System.out.println();
			
			//printing priority after answering questions -- code under test
			System.out.println("printing priority after answering questions");
			printLis();
	}
	
	public void printLis()
	{
		for(int i = 0; i < objLis.size(); i++)
		{
			System.out.print(objLis.get(i).getCatName());
			if(i != objLis.size() - 1)
			{
				System.out.print(" ----> ");	
			}
		}
		System.out.println();
	}
	
	public void createList(String[] row)
	{
		boolean isAnimate = false;
		boolean isHuman = false;
		String gender = null;
		int age = -1;
		float height = -1;
		float weight = -1;
		boolean isWild = false;
		boolean isVehicle = false;
		String category = null;
		String categoryName = null;
		
		if(row[0] != null)
		{
			isAnimate = Boolean.parseBoolean(row[0].toString());
		}
		if(row[1] != null)
		{
			isHuman = Boolean.parseBoolean(row[0].toString());
		}
		if(row[2] != null)
		{
			gender = row[2].toString();
		}
		if(row[3] != null)
		{
			age = Integer.parseInt(row[3]);
		}
		if(row[4] != null)
		{
			height = Float.parseFloat(row[4].toString());
		}
		if(row[5] != null)
		{
			weight = Float.parseFloat(row[5].toString());
		}
		if(row[6] != null)
		{
			isWild = Boolean.parseBoolean(row[6].toString());
		}
		if(row[7] != null)
		{
			isVehicle = Boolean.parseBoolean(row[7].toString());
		}
		if(row[8] != null)
		{
			category = row[8].toString();
		}
		if(row[9] != null)
		{
			categoryName = row[9].toString();
		}
		//creating object of an entire row and storing in objLis
		options tempOpt = new options(isAnimate, isHuman, gender, age, height, weight, isWild, isVehicle, category, categoryName);
		
		objLis.add(tempOpt);
	}
	
	
	public void sortList()
	{
		int p_index;
		for(int i = 0; i < objLis.size() - 1; i++)
		{
			p_index = i;
			for(int j = i+1; j < objLis.size(); j++)
			{
				//if first parameter has higher priority than second, then the following if condition is true
				if(compareOptions(objLis.get(j), objLis.get(p_index)))
				{
					options tempObj = objLis.get(p_index);
					objLis.set(p_index, objLis.get(j));
					objLis.set(j, tempObj);
				}
			}
		}
	}
	
	public boolean compareOptions(options o1, options o2)
	{
		System.out.println("********************* NEW QUESTION ********************");
		
		System.out.println("Which amongst the two choices is your priority?\n");
		
		System.out.println("CHOICE 1: ");
		System.out.println("Category: " + o1.getCategory());
		System.out.println("Category Attributes: ");
		System.out.println("Is the object animate? " + o1.getIsAnimate());
		System.out.println("Is the object a human being? " + o1.getIsHuman());
		System.out.println("What's the gender? " + o1.getGender());
		System.out.println("What's the age? " + o1.getAge());
		System.out.println("What's the height? " + o1.getHeight());
		System.out.println("What's the weight? " + o1.getWeight());
		System.out.println("Is it a wild animal? " + o1.getIsWild());
		System.out.println("Is it a vehicle? " + o1.getIsVehicle());
		//System.out.println("isAnimate: " + o1.getIsAnimate());
		
		System.out.println("");
		
		System.out.println("CHOICE 2: ");
		System.out.println("Category: " + o2.getCategory());
		System.out.println("Category Attributes: ");
		System.out.println("Is the object animate? " + o2.getIsAnimate());
		System.out.println("Is the object a human being? " + o2.getIsHuman());
		System.out.println("What's the gender? " + o2.getGender());
		System.out.println("What's the age? " + o2.getAge());
		System.out.println("What's the height? " + o2.getHeight());
		System.out.println("What's the weight? " + o2.getWeight());
		System.out.println("Is it a wild animal? " + o2.getIsWild());
		System.out.println("Is it a vehicle? " + o2.getIsVehicle());
		
		
		System.out.println();
		System.out.println("Press 1 for choice 1 or Press 2 for choice 2.");
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		if(input == 1)
		{
			System.out.println("**********************END QUESTION*********************");
			System.out.println("");
			return true;
		}
		
		System.out.println("**********************END QUESTION*********************");
		System.out.println("");
		return false;
	}
	
}
