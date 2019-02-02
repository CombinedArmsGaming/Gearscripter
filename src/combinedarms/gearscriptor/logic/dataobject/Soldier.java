package combinedarms.gearscriptor.logic.dataobject;

import combinedarms.gearscriptor.logic.inputparsing.AceArmouryCodeParser;
import combinedarms.gearscriptor.logic.inputparsing.BiArmouryCodeGenerator;
import combinedarms.gearscriptor.logic.inputparsing.BiArmouryCodeParser;

public class Soldier
{
	private String name;
	private String faction;
	private Loadout loadout;
	private String biCode;
	private String aceCode;
	private boolean isBi;
	
	//Generated from the AceArmouryCodeParser (set aceMarker to null in call, it's not used, just there so we can overload the
	//constructor
	public Soldier(String name, String faction, String aceCode, String aceMarker)
	{
		super();
		this.name = name;
		this.faction = faction;
		this.loadout = this.buildLoadoutFromAce(aceCode);
		this.biCode = "";
		this.isBi = false;
	}
	
	//Generated From the BiCode
	public Soldier(String name, String faction, String biCode)
	{
		super();
		this.name = name;
		this.faction = faction;
		this.biCode = biCode;
		this.loadout = this.buildLoadoutFromBi(biCode);
		this.aceCode = "";
		this.isBi = true;
	}
	
	//Builds bi code from current loadout
	public void buildBiCode()
	{
		this.setBiCode(BiArmouryCodeGenerator.generateBiCodeFromLoadout(this.getLoadout()));
	}
	
	//Builds loadout from the bi input
	public Loadout buildLoadoutFromBi(String biCode)
	{
		return BiArmouryCodeParser.generateLoadoutFromBiExport(biCode);
	}
	
	public Loadout buildLoadoutFromAce(String aceCode)
	{
		return AceArmouryCodeParser.generateLoadoutFromAceExport(aceCode);
	}
	
	//Stores soldier in DB, calls into the Data Access layer
	public void storeSoldierInDB()
	{
		//TODO
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

	public String getAceCode()
	{
		return aceCode;
	}

	public void setAceCode(String aceCode)
	{
		this.aceCode = aceCode;
	}

	public boolean isBi()
	{
		return isBi;
	}

	public void setBi(boolean isBi)
	{
		this.isBi = isBi;
	}
	
}
