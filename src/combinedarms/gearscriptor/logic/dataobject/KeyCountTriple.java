package combinedarms.gearscriptor.logic.dataobject;

public class KeyCountTriple
{
	private String key;
	private int countNumber, countRounds;
	
	public KeyCountTriple(String key, int countNumber, int countRounds)
	{
		super();
		this.key = key;
		this.countNumber = countNumber;
		this.countRounds = countRounds;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public void setKey(String key)
	{
		this.key = key;
	}
	
	public int getCountNumber()
	{
		return countNumber;
	}
	
	public void setCountNumber(int countNumber)
	{
		this.countNumber = countNumber;
	}
	
	public int getCountRounds()
	{
		return countRounds;
	}
	
	public void setCountRounds(int countRounds)
	{
		this.countRounds = countRounds;
	}
	
	@Override
	public String toString()
	{
		return "KeyCountTriple [key=" + key + ", countNumber=" + countNumber + ", countRounds=" + countRounds + "]";
	}
	
	
}
