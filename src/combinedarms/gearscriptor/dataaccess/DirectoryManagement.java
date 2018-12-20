package combinedarms.gearscriptor.dataaccess;

import java.io.File;
import java.util.ArrayList;

public class DirectoryManagement {
	/* This class has one method that should be called from outside of it and thats findMissions.
	 * findMissions returns an ArrayList<String> that contains the full file path for every mission.sqm folder in the supplied initialProfilePath
	 * initialProfilePath should always be the users arma 3 profile that they are currently using
	 * 
	 */
	
	public static void main(String Args[]) {
		System.out.println(findMissions("C:\\Users\\Jonathan\\Documents\\Arma 3 - Other Profiles\\Baird,"));
		System.out.println(showMissionFolders(findMissions("C:\\Users\\Jonathan\\Documents\\Arma 3 - Other Profiles\\Baird,")));
	}
	
	//Starts of and returns the missionList ArrayList
	public static ArrayList<String> findMissions(String intialProfilePath) {
		File[] files = new File(intialProfilePath).listFiles();
		ArrayList<String> missionList = new ArrayList<String>();
		showFiles(files, missionList);
		return missionList;
	}
	//Recursively itterates through all files given in files
	public static ArrayList<String> showFiles(File[] files, ArrayList<String> missionList) {
		for (File file : files) {
			if (file.isDirectory()) {
				showFiles(file.listFiles(), missionList);
			} else if(file.getName().equals("mission.sqm")){
				missionList.add(file.getPath());
			}
		}
		return missionList;
	}
	
	public static ArrayList<String> showMissionFolders(ArrayList<String> missionList) {
		for (int i = 0; i < missionList.size(); i++) {
			StringBuilder sb = new StringBuilder(missionList.get(i));
			for(int j = (missionList.get(i).length()-1); j > (missionList.get(i).length()-13); j--) {
				sb.deleteCharAt(j);
			}
			missionList.set(i, sb.toString());
		}
		return missionList;
	}
}
