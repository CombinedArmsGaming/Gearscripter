package combinedarms.gearscriptor.logic.dataobject;

import com.google.common.collect.Multimap;

//Represents a soldier with gear, contains methods responsible for calling data access functionality to load or save the soldier in a database
public class Loadout
{
	private Weapon primary, launcher, secondary;
	private Multimap<String, KeyCountTriple> uniform, vest, backpack;
	private String headgear, facewear;
	private Weapon binocular;
	private AncillaryEquipment ancillaryEquipment;
	
	public Loadout(Weapon primary, Weapon launcher, Weapon secondary,
			Multimap<String, KeyCountTriple> uniform, Multimap<String, KeyCountTriple> vest,
			Multimap<String, KeyCountTriple> backpack, String headgear, String facewear, Weapon binocular,
			AncillaryEquipment ancillaryEquipment)
	{
		super();
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

	@Override
	public String toString()
	{
		return "Loadout [primary=" + primary + ", launcher=" + launcher + ", secondary=" + secondary + ", uniform="
				+ uniform + ", vest=" + vest + ", backpack=" + backpack + ", headgear=" + headgear + ", facewear="
				+ facewear + ", binocular=" + binocular + ", ancillaryEquipment=" + ancillaryEquipment + "]";
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

	public Multimap<String, KeyCountTriple> getUniform()
	{
		return uniform;
	}

	public void setUniform(Multimap<String, KeyCountTriple> uniform)
	{
		this.uniform = uniform;
	}

	public Multimap<String, KeyCountTriple> getVest()
	{
		return vest;
	}

	public void setVest(Multimap<String, KeyCountTriple> vest)
	{
		this.vest = vest;
	}

	public Multimap<String, KeyCountTriple> getBackpack()
	{
		return backpack;
	}

	public void setBackpack(Multimap<String, KeyCountTriple> backpack)
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
