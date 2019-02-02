package combinedarms.gearscriptor.logic.dataobject;

import java.util.ArrayList;

//Represents ancillary equipment like maps and radios, can be loaded in as a list or each individual item depending on whether 
//it's the Bi input or ACE input
public class AncillaryEquipment
{
	private String map, gpsTerminal, radio, compass, watch, nvgs;
	private ArrayList<String> equipment = new ArrayList<String>();
	
	public AncillaryEquipment(String map, String gpsTerminal, String radio, String compass, String watch, String nvgs)
	{
		this.setCompass(compass);
		this.setGpsTerminal(gpsTerminal);
		this.setMap(map);
		this.setNvgs(nvgs);
		this.setRadio(radio);
		this.setWatch(watch);
		this.addItemsToEquipmentList();
	}
	
	public AncillaryEquipment(ArrayList<String> equipment)
	{
		this.setEquipment(equipment);
	}
	 
	//Takes the input and adds it to the equipment list
	public void addItemsToEquipmentList()
	{
		equipment.add(this.getMap());
		equipment.add(this.getGpsTerminal());
		equipment.add(this.getRadio());
		equipment.add(this.getCompass());
		equipment.add(this.getWatch());
		equipment.add(this.getNvgs());
	}

	@Override
	public String toString()
	{
		return "AncillaryEquipment [map=" + map + ", gpsTerminal=" + gpsTerminal + ", radio=" + radio + ", compass="
				+ compass + ", watch=" + watch + ", nvgs=" + nvgs + "]";
	}
	
	public ArrayList<String> getEquipment()
	{
		return this.equipment;
	}
	
	public void setEquipment(ArrayList<String> equipment)
	{
		this.equipment = equipment;
	}

	public String getMap()
	{
		return map;
	}

	public void setMap(String map)
	{
		this.map = map;
	}

	public String getGpsTerminal()
	{
		return gpsTerminal;
	}

	public void setGpsTerminal(String gpsTerminal)
	{
		this.gpsTerminal = gpsTerminal;
	}

	public String getRadio()
	{
		return radio;
	}

	public void setRadio(String radio)
	{
		this.radio = radio;
	}

	public String getCompass()
	{
		return compass;
	}

	public void setCompass(String compass)
	{
		this.compass = compass;
	}

	public String getWatch()
	{
		return watch;
	}

	public void setWatch(String watch)
	{
		this.watch = watch;
	}

	public String getNvgs()
	{
		return nvgs;
	}

	public void setNvgs(String nvgs)
	{
		this.nvgs = nvgs;
	}
}
