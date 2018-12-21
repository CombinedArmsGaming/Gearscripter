package combinedarms.gearscriptor.logic.inputparsing;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class AceArmouryCodeParser
{
	//Entry point, takes in an ACE armoury export and returns a Loadout object
	public static Loadout generateLoadoutFromAceExport(String input)
	{
		ArrayList<String> initialAceObjects = unpackAceObjects(input);
		initialAceObjects = formatInputForEmpties(initialAceObjects);
		ArrayList<ArrayList<String>> allEquipment = new ArrayList<ArrayList<String>>();
		initialAceObjects.forEach((aceObject) -> allEquipment.add(unpackAceObjectsIntoComponents(aceObject)));

		return new Loadout
				(
					generateWeaponFromAceExport(allEquipment.get(0)),
					generateWeaponFromAceExport(allEquipment.get(1)),
					generateWeaponFromAceExport(allEquipment.get(2)),
					generateContainerFromAceExport(allEquipment.get(3)),
					generateContainerFromAceExport(allEquipment.get(4)),
					generateContainerFromAceExport(allEquipment.get(5)),
					allEquipment.get(6).get(0),
					allEquipment.get(6).get(1),
					generateWeaponFromAceExport(allEquipment.get(7)),
					generateAncillariesFromAceExport(allEquipment.get(8))
				);
	}
	
	//Cycles through list and depending on object calls various cleaning methods
	private static ArrayList<String> formatInputForEmpties(ArrayList<String> input)
	{
		for(int i = 0; i < input.size(); i++)
		{
			String aceObject = input.get(i);
			if(i == 0||i == 1||i == 2||i == 7)
			{
				aceObject = (aceObject.charAt(1) == ']')? setAceWeaponToDefault() : curateEmptiesInAceObject(aceObject);
			}
			else 
			if(i == 3||i == 4||i == 5)
			{
				aceObject = (aceObject.charAt(1) == ']')? setAceContainerToDefault() : curateEmptiesInAceObject(aceObject);
			}
			else
			if(i == 6)
			{
				aceObject = (input.contains("\"\",\"\"")? setFloatingStringsToDefault() : curtateEmptiesInFreeFloatingStrings(aceObject));
			}
			input.set(i, aceObject);
		}
		
		return input;
	}
	
	//replaces empty free floating strings with empty
	private static String curtateEmptiesInFreeFloatingStrings(String input)
	{		
		String[] splitInput = input.split(",");
		for(String fFString : splitInput)
		{
			if(fFString.contains("\"\""))
				fFString = "\"empty\"";
		}
		
		input = splitInput[0] + "," + splitInput[1];
		
		return input;
	}
	
	//Create empties for every empty sub object to maintain order
	private static String curateEmptiesInAceObject(String input)
	{
		for(int i = 1; i < input.length() - 1; i++)
		{
			if(input.charAt(i) == '[' && input.charAt(i + 1) == ']')
			{
				input = input.substring(0, i + 1) + "\"empty\",0" + input.substring(i + 1, input.length());
			}
		}		
		return input;
	}
	
	//sets default for headgear/facegear (which aren't in an ace object
	private static String setFloatingStringsToDefault()
	{
		return "\"empty\",\"empty\"";
	}
	
	//Sets default weapon aceObject
	private static String setAceWeaponToDefault()
	{
		return "[\"empty\",\"empty\",\"empty\",\"empty\",[\"empty\",0],[\"empty\",0],\"empty\"]";
	}	
	
	//Sets default container aceObject
	private static String setAceContainerToDefault()
	{
		return "[\"empty\",[\"empty\",0]]";
	}
	
	//Returns an Ancillaries object(contains map, gps, radio etc.) from the unpacked String that represents it
	private static AncillaryEquipment generateAncillariesFromAceExport(ArrayList<String> input)
	{
		return new AncillaryEquipment
		(
			input.get(0),
			input.get(1),
			input.get(2),
			input.get(3),
			input.get(4),
			input.get(5)
		);
	}
	
	//Returns a container object(uniform, vest, backpack) from the unpacked String that represents it
	private static Multimap<String, KeyCountTriple> generateContainerFromAceExport(ArrayList<String> input)
	{
		Multimap<String, KeyCountTriple> container = ArrayListMultimap.create();
		String key = input.get(0);
		String previous = "";
		int count = 0;
		int countRounds = 0;
		for(int i = 1; i < input.size(); i++)
		{
			String entry = input.get(i);
			if(entry != key)
			{				
				if(!isInteger(entry))
				{
					if(previous != "")
					{
						container.put(key, new KeyCountTriple(previous, count, countRounds));
						previous = "";
						count = 0;
						countRounds = 0;
					}
					previous = entry;
				}
				else
				{
					if(count == 0)
					{
						count = Integer.parseInt(entry);
					}
					else
					{
						countRounds = Integer.parseInt(entry);
					}
				}
				if(i == input.size() - 1)
				{
					container.put(key, new KeyCountTriple(previous, count, countRounds));
				}
			}
		}
		
		return container;
	}
	
	//Checks if a string can be converted into an integer
	private static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    if (str.isEmpty()) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (str.length() == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}
	
	//Returns a weapon object(primary, launcher, secondary, binoculars) from the unpacked String that represents it
	private static Weapon generateWeaponFromAceExport(ArrayList<String> input)
	{
		return new Weapon
		(	
			input.get(0),
			input.get(1),
			input.get(2),
			input.get(3),
			input.get(4),
			input.get(6),		
			input.get(8),
			Integer.parseInt(input.get(5)),
			Integer.parseInt(input.get(7))
		);
	}
	
	//Breaks down each Ace Object into each component part
	private static ArrayList<String> unpackAceObjectsIntoComponents(String input)
	{
		input = input.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");		
		return new ArrayList<>(Arrays.asList(input.split(",")));
	}
	
	//Takes the initial ACE input and breaks it down into initial objects (Primary, Launcher, Weapon, Vest etc.)
	//Takes in the input from the ACE armoury export and will first remove the initial [] and then for each
	//full set of []s it will unpack that into a String. Also has the commaCounting functionality to get
	//the Headwear and Facewear which sit outside of the normal [] object structure.
	private static ArrayList<String> unpackAceObjects(String input)
	{
		int start = 0;
		int leftBrackets = 0;
		int rightBrackets = 0;
		boolean inObject = false;
		ArrayList<String> aceObjectList = new ArrayList<>();
		
		input = input.substring(1, input.length()-1);
		
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == '"' && input.charAt(i + 1) == '"')
			{
				input = input.substring(0, i + 1) + "empty" + input.substring(i + 1, input.length());
			}
			
			if(input.charAt(i) == '[')
			{
				if(!inObject)
					start = i;
				inObject = true;
				leftBrackets++;
			}
			
			if(input.charAt(i) == ']')
				rightBrackets++;
			
			if(leftBrackets == rightBrackets && inObject)
			{
				aceObjectList.add(input.substring(start, i + 1));
				start = 0;
				leftBrackets = 0;
				rightBrackets = 0;
				inObject = false;
				if(input.length() > i + 2)
				{
					if(input.charAt(i + 2) == '"')
					{
						start = i + 2;
						int commaCounter = start;
						int commas = 0;
						while(commas < 2)
						{
							commaCounter++;
							if(input.charAt(commaCounter) == ',')
							{
								commas++;
							}
						}
						aceObjectList.add(input.substring(start, commaCounter));
						start = 0;
					}
				}
			}
		}
		return aceObjectList;
	}
}
