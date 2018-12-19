package combinedarms.gearscriptor.logic;

public class Version {
	private ReleaseInfo releaseInfo;
	private LicenseInfo licenseInfo;
	
	public Version() {
		
	}

	public ReleaseInfo getReleaseInfo() {
		return releaseInfo;
	}

	public void setReleaseinfo(ReleaseInfo releaseInfo) {
		this.releaseInfo = releaseInfo;
	}

	public LicenseInfo getLicenseinfo() {
		return licenseInfo;
	}

	public void setLicenseinfo(LicenseInfo licenseInfo) {
		this.licenseInfo = licenseInfo;
	}
	
	public String getMajorMinorFromRelease(){
	    return this.getReleaseInfo().getMajorVersion() + "." + this.getReleaseInfo().getMinorVersion();
	}
	
}
