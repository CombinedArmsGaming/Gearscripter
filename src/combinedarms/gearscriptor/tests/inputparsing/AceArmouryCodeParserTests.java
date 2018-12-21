package combinedarms.gearscriptor.tests.inputparsing;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import combinedarms.gearscriptor.logic.inputparsing.AceArmouryCodeParser;
import combinedarms.gearscriptor.logic.inputparsing.KeyCountTriple;
import combinedarms.gearscriptor.logic.inputparsing.Loadout;

class AceArmouryCodeParserTests
{
	@Test
	void testGenerateLoadoutFromAceExportEmpty()
	{
		try
		{
			String input = Files.lines(Paths.get("./src/combinedarms/gearscriptor/tests/inputparsing/AceArmouryParsingTestFileEmpty.txt"), Charset.defaultCharset())
					.map(Object::toString)
			        .collect(Collectors.joining("")).replaceAll("\\s", "");
			
			Loadout loadout = AceArmouryCodeParser.generateLoadoutFromAceExport(input);
			
			assertEquals("empty", loadout.getFacewear());
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	void testGenerateLoadoutFromAceExportHalfFull()
	{
		try
		{
			String input = Files.lines(Paths.get("./src/combinedarms/gearscriptor/tests/inputparsing/AceArmouryParsingTestFileSemiFull.txt"), Charset.defaultCharset())
					.map(Object::toString)
			        .collect(Collectors.joining("")).replaceAll("\\s", "");
			
			Loadout loadout = AceArmouryCodeParser.generateLoadoutFromAceExport(input);
			ArrayList<KeyCountTriple> kVTS = new ArrayList<>(loadout.getVest().get("V_TacVest_gen_F"));
			
			assertEquals("Binocular", loadout.getBinocular().getWeapon());
			assertEquals(7, kVTS.get(1).getCountRounds());
			assertEquals(3, kVTS.get(1).getCountNumber());
			assertEquals("rhsusf_mag_7x45acp_MHP", kVTS.get(1).getKey());
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	void testGenerateLoadoutFromAceExportFull()
	{
		try
		{
			String input = Files.lines(Paths.get("./src/combinedarms/gearscriptor/tests/inputparsing/AceArmouryParsingTestFileFull.txt"), Charset.defaultCharset())
					.map(Object::toString)
			        .collect(Collectors.joining("")).replaceAll("\\s", "");
			
			Loadout loadout = AceArmouryCodeParser.generateLoadoutFromAceExport(input);
			
			assertEquals("hlc_rifle_g3sg1", loadout.getPrimary().getWeapon());
			assertEquals("rhsusf_ANPVS_15", loadout.getAncillaryEquipment().getNvgs());
			assertEquals("Laserbatteries", loadout.getBinocular().getFirstMagazine());
			assertEquals(1, loadout.getBinocular().getFirstRoundCount());
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
