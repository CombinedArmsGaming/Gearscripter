package combinedarms.gearscriptor.dataaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DirectoryManagement {
	/* This class has two methods that should be called from outside of it, findMissions and .
	 * findMissions returns an ArrayList<String> that contains the full file path for every mission.sqm folder in the supplied initialProfilePath
	 * initialProfilePath should always be the users arma 3 profile that they are currently using
	 * 
	 */
	
	
	//Starts of and returns the missionList ArrayList
	public static ArrayList<String> findMissions(String intialProfilePath) {
		ArrayList<String> missionList = new ArrayList<String>();
		File[] files = new File(intialProfilePath).listFiles();
		showFiles(files, missionList);
		return missionList;
	}
	
	//Recursively itterates through all files given in files and returns a filled ArrayList with each mission.sqm path
	public static ArrayList<String> showFiles(File[] files, ArrayList<String> missionList) {
		try {
		
		for (File file : files) {
			if (file.isDirectory()) {
				showFiles(file.listFiles(), missionList);
			} else if(file.getName().equals("mission.sqm")){
				missionList.add(file.getPath());
			}
		}
		
		return missionList;
		
		} catch (Exception e){
			return null;
		}
	}
	
	//Strips the last 12 chars from the given strings in the provided ArrayList<String>
	public static ArrayList<String> showMissionFolders(ArrayList<String> missionList) {
		
		
		if(missionList.size() > 0) {
			
			for (int i = 0; i < missionList.size(); i++) {
				StringBuilder sb = new StringBuilder(missionList.get(i));
				//Handles exceptions when given index is less than 13 chars, which should never happen, and avoids an out of bounds exception
				if(missionList.get(i).length() > 13) {
				
					for(int j = (missionList.get(i).length()-1); j > (missionList.get(i).length()-13); j--) {
						sb.deleteCharAt(j);
				
					}
					
				}
				missionList.set(i, sb.toString());
			}
			return missionList;
		} else {
			return null;
		}
	}
}
