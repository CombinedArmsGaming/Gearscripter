package combinedarms.gearscriptor.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonSyntaxException;

import combinedarms.gearscriptor.logic.UpdateChecker;

class UpdateCheckerTests
{

	@Test
	void retrieveVersionTests() throws Exception
	{
		assertTrue(UpdateChecker.retrieveVersion().contains("\"majorVersion\": \"0\","));
		assertTrue(UpdateChecker.retrieveVersion().contains("\"minorVersion\": \"1\","));
		assertFalse(UpdateChecker.retrieveVersion().contains("Failures"));
	}
	
	@Test
	void checkForUpdateTests() throws JsonSyntaxException, Exception {
		assertTrue(UpdateChecker.checkForUpdate(UpdateChecker.retrieveVersion() , "./src/combinedarms/gearscriptor/tests/version.json"));
		//This assert false claim uses 0 for both value and since that should never happen this should always return false.
		assertFalse(UpdateChecker.checkForUpdate("[{\"releaseInfo\": {\"majorVersion\": \"0\",\"minorVersion\": \"0\",\"releaseUrl\": \"https://github.com/CombinedArmsGaming/Gearscripter/releases\"},\"licenseInfo\": {\"licenseType\": \"GPL-3.0\",\"licenseUrl\": \"https://github.com/CombinedArmsGaming/Gearscripter/blob/master/LICENSE\"}}]" , "./src/combinedarms/gearscriptor/tests/version.json"));
		
	}

}
