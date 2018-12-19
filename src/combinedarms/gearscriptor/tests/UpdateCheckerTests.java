package combinedarms.gearscriptor.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
