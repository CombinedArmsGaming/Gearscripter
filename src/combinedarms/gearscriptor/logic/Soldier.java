package combinedarms.gearscriptor.logic;

import com.google.common.collect.Multimap;

//Represents a soldier with gear, contains methods responsible for calling data access functionality to load or save the soldier in a database
public class Soldier
{
	private String name;
	private String faction;
	private Weapon primary, launcher, secondary;
	private Multimap<String, KeyCountPair> uniform, vest, backpack;
	private String headgear, facewear;
	private Weapon binocular;
	private AncillaryEquipment ancillaryEquipment;
	
	public Soldier(String name, String faction, Weapon primary, Weapon launcher, Weapon secondary,
			Multimap<String, KeyCountPair> uniform, Multimap<String, KeyCountPair> vest,
			Multimap<String, KeyCountPair> backpack, String headgear, String facewear, Weapon binocular,
			AncillaryEquipment ancillaryEquipment)
	{
		super();
		this.name = name;
		this.faction = faction;
		this.primary = primary;
		this.launcher = launcher;
		this.secondary = secondary;
		this.uniform = uniform;
		this.vest = vest;
		this.backpack = backpack;
		this.headgear = headgear;
		this.facewear = facewear;
		this.binocular = binocular;
		this.ancillaryEquipment = ancillaryEquipment;
	}
	
	//Calls the data access commit to database functionality
	public void commitToDatabase()
	{
		//TODO
	}
	
	//Calls the data access remove from database functionality
	public void removeFromDatabase()
	{
		//TODO
	}
	
	//Calls the data access update in database functionality
	public void updateInDatabse()
	{
		//TODO
	}
	
	@Override
	public String toString()
	{
		return "Soldier [name=" + name + ", faction=" + faction + ", primary=" + primary + ", launcher=" + launcher
				+ ", secondary=" + secondary + ", uniform=" + uniform + ", vest=" + vest + ", backpack=" + backpack
				+ ", headgear=" + headgear + ", facewear=" + facewear + ", binocular=" + binocular
				+ ", ancillaryEquipment=" + ancillaryEquipment + "]";
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

	public Weapon getPrimary()
	{
		return primary;
	}

	public void setPrimary(Weapon primary)
	{
		this.primary = primary;
	}

	public Weapon getLauncher()
	{
		return launcher;
	}

	public void setLauncher(Weapon launcher)
	{
		this.launcher = launcher;
	}

	public Weapon getSecondary()
	{
		return secondary;
	}

	public void setSecondary(Weapon secondary)
	{
		this.secondary = secondary;
	}

	public Multimap<String, KeyCountPair> getUniform()
	{
		return uniform;
	}

	public void setUniform(Multimap<String, KeyCountPair> uniform)
	{
		this.uniform = uniform;
	}

	public Multimap<String, KeyCountPair> getVest()
	{
		return vest;
	}

	public void setVest(Multimap<String, KeyCountPair> vest)
	{
		this.vest = vest;
	}

	public Multimap<String, KeyCountPair> getBackpack()
	{
		return backpack;
	}

	public void setBackpack(Multimap<String, KeyCountPair> backpack)
	{
		this.backpack = backpack;
	}

	public String getHeadgear()
	{
		return headgear;
	}

	public void setHeadgear(String headgear)
	{
		this.headgear = headgear;
	}

	public String getFacewear()
	{
		return facewear;
	}

	public void setFacewear(String facewear)
	{
		this.facewear = facewear;
	}

	public Weapon getBinocular()
	{
		return binocular;
	}

	public void setBinocular(Weapon binocular)
	{
		this.binocular = binocular;
	}

	public AncillaryEquipment getAncillaryEquipment()
	{
		return ancillaryEquipment;
	}

	public void setAncillaryEquipment(AncillaryEquipment ancillaryEquipment)
	{
		this.ancillaryEquipment = ancillaryEquipment;
	}	
}
