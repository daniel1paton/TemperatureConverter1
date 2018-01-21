import java.util.Scanner;

public class Temperature {
	
	private float temp;
	private char scale;	
	
	public Temperature(float initialTemp)
	{
		temp = initialTemp;
		scale = 'C';	
	}

	public Temperature(char initialScale)
	{
		temp = 0;
		setScale(initialScale);
	}
	
	public Temperature(float initialTemp, char initialScale)
	{	
		temp = initialTemp;
		setScale(initialScale);
	}
	
	public Temperature()
	{
		temp = 0;
		scale = 'C';
	}
	
	//Returns temperature in celsius.
	public float getTempInCelsius()
	{
		//Don't convert if already in Celsius
		if(scale == 'C')
		{
			return temp;
		}
		
			else
		{	float celsius;
			celsius = (((temp -32) * 5)/9);
			return celsius;	
		}
	}
	
	//Returns temperature in fahrenheit.
	public float getTempInFahrenheit()
	{
		if(scale == 'F')
		{
			return temp;
		}
		else 
		{
			return (temp * 9/5) + 32;//Fahrenheit	
		}
	}
	
	public float getTemp()
	{
		return temp;
	}
	
	public void setTemp(float initialTemp)
	{
	   temp = initialTemp;
	}
	
	public char getScale()
	{
		return scale;
	}	
	
	public void setScale(char initialScale)
	{
		if ((initialScale == 'C') || (initialScale == 'F'))
		{
			scale = initialScale;
		}
	}
	
	public void setTempWithScale(float initialTemp, char initialScale)
	{
	}
	
	private float getSameTemperature(Temperature tempObj)
	{
		if(getScale() == 'C')
		{
			return tempObj.getTempInCelsius();
		}
		else
		{
			return tempObj.getTempInFahrenheit();
		}
	}
	
	//Compares a celsius temperature to a fahrenheit temperature
	public boolean isEqual(Temperature tempObj)
	{
		return this.getTemp() == getSameTemperature(tempObj);
	}
	
	public boolean isGreaterThan(Temperature tempObj)
	{
		return getTemp() > getSameTemperature(tempObj);
	}
	
	public boolean isLessThan(Temperature tempObj)
	{
		return getTemp() < getSameTemperature(tempObj);
	}
	
	public String ToString()
	{
		return getTemp() + " " + getScale();
	}
	
	
	public static void compare(Temperature one, Temperature two) 
	{
		if (one.isEqual(two))
			{		
				System.out.println(one.ToString() + " is equal to " + two.ToString());
			}
		
		if (one.isGreaterThan(two))
			{		
				System.out.println(one.ToString() + " is greater than " + two.ToString());
			}
		
		if (one.isLessThan(two))
			{		
				System.out.println(one.ToString() + " is less than " + two.ToString());
			}

	}
	
	
	public static void main (String args[]) {
		Temperature myTemp = new Temperature();
		Temperature newTemp1 = new Temperature(0, 'C');
		Temperature newTemp2 = new Temperature(32, 'F');
		Temperature newTemp3 = new Temperature(-40, 'C');
		Temperature newTemp4 = new Temperature(-40, 'F');
		Temperature newTemp5 = new Temperature(100, 'C');
		Temperature newTemp6 = new Temperature(212, 'F');
		
		System.out.println(myTemp.ToString());   //Test default constructor		
		System.out.println(newTemp1.ToString()); //Test temperature constructor
		System.out.println(newTemp2.ToString()); //Test scale constructor
		System.out.println(newTemp3.ToString()); //Test temperature and scale constructor
		System.out.println(newTemp4.ToString());	
		
		//Testing compare method.
		compare(newTemp1, newTemp2);
		compare(newTemp3, newTemp4);
		compare(newTemp5, newTemp6);
		compare(newTemp2, newTemp5);
		compare(newTemp5, newTemp2);
	}
}	




