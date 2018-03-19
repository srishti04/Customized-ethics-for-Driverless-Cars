
public class options 
{
	boolean isAnimate;
	boolean isHuman;
	String gender;
	int age;
	float height;
	float weight;
	boolean isWild;
	boolean isVehicle;
	
	String category;
	String catName;
	
	public options(boolean inAni, boolean inHum, String inGender, int inAge, float inHeight, float inWeight, boolean inWild, boolean inVeh, String inCat, String inCatName)
	{
		isAnimate = inAni;
		isHuman = inHum;
		gender = inGender;
		age = inAge;
		height = inHeight;
		weight = inWeight;
		isWild = inWild;
		isVehicle = inVeh;
		category = inCat;
		catName = inCatName;
	}
	
	public boolean getIsAnimate()
	{
		return isAnimate;
	}
	
	public boolean getIsHuman()
	{
		return isHuman;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public float getHeight()
	{
		return height;
	}
	
	public float getWeight()
	{
		return weight;
	}
	
	public boolean getIsWild()
	{
		return isWild;
	}
	
	public boolean getIsVehicle()
	{
		return isVehicle;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getCatName()
	{
		return catName;
	}			
}
