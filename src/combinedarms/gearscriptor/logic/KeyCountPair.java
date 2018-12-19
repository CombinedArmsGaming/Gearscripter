package combinedarms.gearscriptor.logic;

public class KeyCountPair
{
	private String key;
	private int count;
	
	public KeyCountPair(String key, int count)
	{
		this.setKey(key);
		this.setCount(count);
	}
	

	@Override
	public String toString()
	{
		return "KeyCountPair [key=" + key + ", count=" + count + "]";
	}


	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}
}
