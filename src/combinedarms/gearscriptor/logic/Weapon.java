package combinedarms.gearscriptor.logic;

public class Weapon
{
	private String weapon, muzzle, flashLaser, optic, firstMagazine, secondMagazine, bipod;
	private int firstRoundCount, secondRoundCount;

	public Weapon(String weapon, String muzzle, String flashLaser, String optic, String firstMagazine,
			String secondMagazine, String bipod, int firstRoundCount, int secondRoundCount)
	{
		super();
		this.weapon = weapon;
		this.muzzle = muzzle;
		this.flashLaser = flashLaser;
		this.optic = optic;
		this.firstMagazine = firstMagazine;
		this.secondMagazine = secondMagazine;
		this.bipod = bipod;
		this.firstRoundCount = firstRoundCount;
		this.secondRoundCount = secondRoundCount;
	}

	@Override
	public String toString()
	{
		return "Weapon [weapon=" + weapon + ", muzzle=" + muzzle + ", flashLaser=" + flashLaser + ", optic=" + optic
				+ ", firstMagazine=" + firstMagazine + ", secondMagazine=" + secondMagazine + ", bipod=" + bipod
				+ ", firstRoundCount=" + firstRoundCount + ", secondRoundCount=" + secondRoundCount + "]";
	}

	public String getWeapon()
	{
		return weapon;
	}

	public void setWeapon(String weapon)
	{
		this.weapon = weapon;
	}

	public String getMuzzle()
	{
		return muzzle;
	}

	public void setMuzzle(String muzzle)
	{
		this.muzzle = muzzle;
	}

	public String getFlashLaser()
	{
		return flashLaser;
	}

	public void setFlashLaser(String flashLaser)
	{
		this.flashLaser = flashLaser;
	}

	public String getOptic()
	{
		return optic;
	}

	public void setOptic(String optic)
	{
		this.optic = optic;
	}

	public String getFirstMagazine()
	{
		return firstMagazine;
	}

	public void setFirstMagazine(String firstMagazine)
	{
		this.firstMagazine = firstMagazine;
	}

	public String getSecondMagazine()
	{
		return secondMagazine;
	}

	public void setSecondMagazine(String secondMagazine)
	{
		this.secondMagazine = secondMagazine;
	}

	public String getBipod()
	{
		return bipod;
	}

	public void setBipod(String bipod)
	{
		this.bipod = bipod;
	}

	public int getFirstRoundCount()
	{
		return firstRoundCount;
	}

	public void setFirstRoundCount(int firstRoundCount)
	{
		this.firstRoundCount = firstRoundCount;
	}

	public int getSecondRoundCount()
	{
		return secondRoundCount;
	}

	public void setSecondRoundCount(int secondRoundCount)
	{
		this.secondRoundCount = secondRoundCount;
	}
}
