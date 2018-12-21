package combinedarms.gearscriptor.logic.dataobject;

public class Soldier
{
	private String name;
	private String faction;
	private Loadout loadout;
	private String biCode;
	
	public Soldier(String name, String faction, Loadout loadlout)
	{
		super();
		this.name = name;
		this.faction = faction;
		this.loadout = loadlout;
		this.biCode = "";
	}
	
	public Soldier(String name, String faction, String biCode)
	{
		super();
		this.name = name;
		this.faction = faction;
		this.loadout = null;
		this.biCode = biCode;
	}

	@Override
	public String toString()
	{
		return "Soldier [name=" + name + ", faction=" + faction + ", loadlout=" + loadout + ", biCode=" + biCode + "]";
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFaction()
	{
		return faction;
	}

	public void setFaction(String faction)
	{
		this.faction = faction;
	}

	public Loadout getLoadout()
	{
		return loadout;
	}

	public void setLoadout(Loadout loadlout)
	{
		this.loadout = loadlout;
	}

	public String getBiCode()
	{
		return biCode;
	}

	public void setBiCode(String biCode)
	{
		this.biCode = biCode;
	}
	
}
