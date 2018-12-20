package combinedarms.gearscriptor.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import combinedarms.gearscriptor.dataaccess.DirectoryManagement;

public class DirectoryManagementTests {

	@Test
	void findMissionsTests() {
		ArrayList<String> expectedNull = new ArrayList<String>();
		ArrayList<String> expectedNotNull = new ArrayList<String>();
		
		assertEquals(expectedNull , DirectoryManagement.findMissions(""));
		assertEquals(expectedNull , DirectoryManagement.findMissions("s"));
		assertNotNull(DirectoryManagement.findMissions("./src//combinedarms//gearscriptor//tests//mission.sqm"));
		
		
	}
	
	@Test
	void showFilesTests() {
		//Only called by findMissions() and needs and as such is covered by tests done in findMisisonsTests()
	}
	
	@Test
	void showMissionFoldersTests() {
		ArrayList<String> expectedTooShort = new ArrayList<String>();
		ArrayList<String> expectedNotNull = new ArrayList<String>();
		ArrayList<String> expectedNull = new ArrayList<String>();
		expectedNotNull.add("./src/combinedarms/gearscriptor/tests/mission.sqm");
		expectedTooShort.add("aa");
		
		assertNull(DirectoryManagement.showMissionFolders(expectedNull));
		assertEquals(expectedTooShort,DirectoryManagement.showMissionFolders(expectedTooShort));
		assertNotNull(DirectoryManagement.showMissionFolders(expectedNotNull));
		
	}
	
}
