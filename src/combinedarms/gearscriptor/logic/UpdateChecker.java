package combinedarms.gearscriptor.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import com.google.gson.Gson;

public class UpdateChecker {
	
	public static void main(String Args[]) {
	/*	try (Reader reader = new FileReader("./src/combinedarms/gearscriptor/logic/version.json"))
        {
            Gson gson = new Gson();
            Version[] version = gson.fromJson(reader, Version[].class);
            System.out.println(version[0].getMajorMinorFromRelease());
        }
        catch
        (Exception e)
        {
            System.out.println(e.getStackTrace().toString());
        }*/
		
		try {
			System.out.println(checkForUpdate(retrieveVersion()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/* Compares the online and local versions*/
	public static boolean checkForUpdate(String onlineVersion) throws FileNotFoundException {
		boolean isUpToDate = false;
		Reader reader = new FileReader("./src/combinedarms/gearscriptor/logic/version.json");
		Gson gson = new Gson();
		Version[] versionLocal = gson.fromJson(reader, Version[].class);
		Version[] versionOnline = gson.fromJson(onlineVersion, Version[].class);
		
	
		
		if(versionLocal[0].getMajorMinorFromRelease().equals(versionOnline[0].getMajorMinorFromRelease())) {
			isUpToDate = true;
		}	
		
		return isUpToDate;
	}
	
	
	/*Retrieves string of json file from http://combinedarms.co.uk/gearscripter/gslicense.json */
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
