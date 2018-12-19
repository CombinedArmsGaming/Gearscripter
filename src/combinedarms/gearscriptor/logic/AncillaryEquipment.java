package combinedarms.gearscriptor.logic;

public class AncillaryEquipment
{
	private String map, gpsTerminal, radio, compass, watch, nvgs;
	
	public AncillaryEquipment(String map, String gpsTerminal, String radio, String watch, String nvgs)
	{
		this.setCompass(nvgs);
		this.setGpsTerminal(gpsTerminal);
		this.setMap(map);
		this.setNvgs(nvgs);
		this.setRadio(radio);
		this.setWatch(watch);
	}

	@Override
	public String toString()
	{
		return "AncillaryEquipment [map=" + map + ", gpsTerminal=" + gpsTerminal + ", radio=" + radio + ", compass="
				+ compass + ", watch=" + watch + ", nvgs=" + nvgs + "]";
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
