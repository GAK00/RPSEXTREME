package rps.model;

import java.util.ArrayList;

public class CpuPlayer
{
	private ThrowableItem thrown;
	private ArrayList<ThrowableItem> items;
	public CpuPlayer()
	{
		items = new ArrayList<ThrowableItem>(Items.getAllItems());
		thrown = null;
	}
	
	public void update()
	{
		items.clear();
		items.addAll(Items.getAllItems());
	}
	
	private void selectItem()
	{
		int rand = (int) (Math.random()*items.size());
		thrown = items.get(rand);
	}
	public ThrowableItem getThrow()
	{
		selectItem();
		return thrown;
	}

}
