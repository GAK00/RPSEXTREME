package rps.model;

import java.util.ArrayList;

public class Items
{

	private static ArrayList<ThrowableItem> items = new ArrayList<ThrowableItem>();
	private static ArrayList<String> names = new ArrayList<String>();

	public static void AddItem(ThrowableItem item)
	{
		if (!names.contains(item.getName()))
		{
			items.add(item);
			names.add(item.getName());
		}
	}

	public static void AddItem(String name, String[] wins)
	{
		if (!names.contains(name))
		{
			items.add(new ThrowableItem(wins, name));
			names.add(name);
		}
	}

	public static ThrowableItem getItem(String name) throws Exception
	{
		name = name.trim();
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		int indexOfItem = items.size();
		for (int index = 0; index < items.size(); index++)
		{
			if (names.get(index).equals(name))
			{
				indexOfItem = index;
				break;
			}
		}
		if (indexOfItem != items.size())
		{
			return items.get(indexOfItem);
		} else
		{
			throw new Exception();
		}
	}

	public static ArrayList<ThrowableItem> getAllItems()
	{
		return items;
	}

	public static ArrayList<String> getAllNames()
	{
		return names;
	}

}
