package combinedarms.gearscriptor.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/* Inputs checkedAgainst: String of a JSON file with version info, String localVersionPath: This is the path of the local version JSON file
 * Local JSON file should be "./src/combinedarms/gearscriptor/logic/version.json" unless changed at somepoint
 * 
 * This class checks the local version in "./src/combinedarms/gearscriptor/tests/version.json" against the string provided. 
 *You can call retrieveVersion() as well in order to get the version from online to check against.
 *It outputs a boolean based on whether or not the getMajorMinorFromRelease are identical.
 *
 * Example of calling this class
 * try {
 *			System.out.println(UpdateChecker.checkForUpdate(retrieveVersion()));
 *		} catch (Exception e) {
 *			// TODO Auto-generated catch block
 *			e.printStackTrace();
 *		}
 * 
 * This will print out "true" if both Major and Minor versions match from local and the checked against version files.
 * No idea why it needs the try catch block just let Baird know if its an issue. 
 */

public class UpdateChecker {
	
	/* Compares the online and local versions*/
	public static boolean checkForUpdate(String checkedAgainst, String localVersionPath) throws JsonSyntaxException, Exception {
		boolean isUpToDate = false;
		Reader reader = new FileReader(localVersionPath);
		Gson gson = new Gson();
		Version[] versionLocal = gson.fromJson(reader, Version[].class);
		Version[] versionOnline = gson.fromJson(checkedAgainst, Version[].class);
		
	
		
		if(versionLocal[0].getMajorMinorFromRelease().equals(versionOnline[0].getMajorMinorFromRelease())) {
			isUpToDate = true;
		}	
		
		return isUpToDate;
	}
	
	
	/*Retrieves string of json file from http://combinedarms.co.uk/gearscripter/gslicense.json*/
	public static String retrieveVersion() throws Exception{
		BufferedReader reader = null;
		
		try {
			URL url = new URL("http://combinedarms.co.uk/gearscripter/gslicense.json");
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			
			while ((read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}
			
			return buffer.toString();
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
	}
}
