package combinedarms.gearscriptor.logic.inputparsing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import combinedarms.gearscriptor.logic.dataobject.Loadout;

/**
 * Logic not done, up for changing in future
 * @author Valh
 *
 */
public class BiArmouryCodeParser
{		
	public static void main(String[] args) throws IOException
	{
		String input = Files.lines(Paths.get("./src/combinedarms/gearscriptor/tests/inputparsing/BiArmouryParsingTestFileFull.txt"), Charset.defaultCharset())
				.map(Object::toString)
		        .collect(Collectors.joining(""));
		
		System.out.println(input);
		generateLoadoutFromBiExport(input);
	}
	
	public static Loadout generateLoadoutFromBiExport(String input)
	{
		HashSet<String> commands = fillCommandKeywords();
		commands.forEach(System.out::println);
		return null;
	}
	
	private static HashSet<String> fillCommandKeywords()
	{
		String[] commands = new String[] {"forceAddUniform",
										  "addItemToUniform",
										  "addVest",
										  "addItemToVest",
										  "addBackpack",
										  "addItemToBackpack",
										  "addHeadgear",
										  "addGoggles",
										  "addWeapon",
										  "addPrimaryWeaponItem",
										  };
		return new HashSet<String>(Arrays.asList(commands));
	}	
}