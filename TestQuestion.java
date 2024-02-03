/*
 * Test Question:
 * Let’s say you were asked to build a system for processing temperatures to detect whether someone was showing signs of infection.
A fever is one of the signs of infection. The system in question has several thousand patients and their temperatures are taken every hour. 
Over the course of the day a person’s temperature fluctuates as much as 1 degree in response to activity, and not everyone starts out at the 
same temperature. 
Some individuals are warmer than others, and it can vary as much 1 degree from person to person. In addition, how you take a temperature 
impacts the result, also by 1 degree. 
You can take it by ear, mouth, armpit, etc. You can also take temperatures in Celsius or Fahrenheit, and if you are serious about your 
temperatures, Kelvin. 
Design a class that represents a temperature
 */

public class Temp {

  /*Summary:
	How we take temp changes
	(Activity) How the user was prior(such as running) changes
	Taking temp with C or F or K can change it
	Take temp every hour
	And not everyone is at the same temp
  */

private double userTemp = 0;
private TempType type;
private Temp.TempLocation.LOC loc;
private String activity;
	
	public Temp(TempType type, TempLocation loc, String activity, double userTemp) {
		this.type = type;
//		this.loc = loc;
		this.activity = activity;
		this.userTemp = userTemp;
	}

	public boolean hasTemp() {
		int offset = 0;
		if(type.equals(TempType.Type.Celsius)) {
			if(userTemp >= 38) {
				return true;
			}
			
		}else if(type.equals(TempType.Type.Fahrenheit)) {
			if(userTemp >= 100) {
				return true;
			}
		}else if(type.equals(TempType.Type.Kelvin)) {
			if(userTemp >= 10) {
				return true;
			}
		}
		return false;
	}
	
	
	class TempType{
		enum Type {
			Celsius,
			Fahrenheit,
			Kelvin
		}
	}
	class TempLocation{
		enum LOC {
			ARM,
			ARMPIT,
			MOUTH,
			EAR
		}
		//mouth +1
		//ear 0
		//arm -2
	}
}
