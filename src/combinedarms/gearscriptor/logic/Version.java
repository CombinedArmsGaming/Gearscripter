package combinedarms.gearscriptor.logic;

public class Version {
	private ReleaseInfo releaseinfo;
	private LicenseInfo licenseinfo;
	
	public Version() {
		
	}

	public ReleaseInfo getReleaseinfo() {
		return releaseinfo;
	}

	public void setReleaseinfo(ReleaseInfo releaseinfo) {
		this.releaseinfo = releaseinfo;
	}

	public LicenseInfo getLicenseinfo() {
		return licenseinfo;
	}

	public void setLicenseinfo(LicenseInfo licenseinfo) {
		this.licenseinfo = licenseinfo;
	}
	
	public String getMajorMinorFromRelease(){
	    return this.getReleaseinfo().getMajorversion() + "." + this.getReleaseinfo().getMinorversion();
	}
	
}
