package combinedarms.gearscriptor.logic;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AceArmouryCodeParser
{
	public static void main(String[] args) throws IOException
	{
		String input = Files.lines(Paths.get("./src/combinedarms/gearscriptor/tests/AceArmouryParsingTestFile.txt"), Charset.defaultCharset())
				.map(Object::toString)
		        .collect(Collectors.joining(""));
		
		/*Arrays.stream(input.replaceAll("\\s", "").replaceAll(",", ",").replaceAll("\\]", "").replaceAll("\"", "")
				.split("\\[")).forEach((test) -> 
				{
					if(!test.isEmpty())
						System.out.println(test);
				});*/
		
		parseObjects(input, "");
	}
	
	public static void parseObjects(String input, String indent)
	{
		ArrayList<String> aceObjectList = new ArrayList<>();
		int leftBrackets = 0;
		int rightBrackets = 0;
		boolean inObject = false;
		int start = 0;
		
		input = input.replaceAll("\\s", "");
		
		for(int i = 1; i < input.length() - 1; i++)
		{
			
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
				aceObjectList.add(indent + input.substring(start, i+1));
				start = 0;
				leftBrackets = 0;
				rightBrackets = 0;
				inObject = false;
			}
		}
		
		for(int i = 0; i < aceObjectList.size(); i++)
		{
			switch (i)
			{
				case 0:  
			}
		}
		
		/*aceObjectList.forEach((aceObject) -> 
		{
			String displayObject = aceObject;
			String futherIndent = indent + "   ";
			System.out.println(indent + displayObject);
			parseObjects(aceObject, futherIndent);
		});*/
	}

	public static List<String> seperateAceObjects(String input)
	{
		ArrayList<String> list = new ArrayList<>();
		return list;
	}
}
