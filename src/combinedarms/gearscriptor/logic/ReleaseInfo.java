package combinedarms.gearscriptor.logic;

public class ReleaseInfo {
	private String majorVersion;
	private String minorVersion;
	private String url;
	
	
	public ReleaseInfo() {
		
	}
	
	
	public String getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}

	public String getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
