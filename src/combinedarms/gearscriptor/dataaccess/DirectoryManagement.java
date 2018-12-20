package combinedarms.gearscriptor.dataaccess;

import java.io.File;
import java.util.ArrayList;

public class DirectoryManagement {
	
	public static void main(String Args[]) {
		findMissions("C:\\Users\\Jonathan\\Documents\\Arma 3 - Other Profiles\\Baird,");
	}
	
	public static ArrayList<String> findMissions(String intialProfilePath) {
		File[] files = new File(intialProfilePath).listFiles();
		ArrayList<String> missionList = new ArrayList<String>();
		showFiles(files, missionList);
		return missionList;
	}
	
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
}
