package rps.model;

import java.lang.reflect.Constructor;
import java.net.URL;

public class ThrowableItem
{
	private String[] wins;
	private String name;

	public ThrowableItem(String[] wins, String name)
	{
		name = name.trim();
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		for (int index = 0; index < wins.length; index++)
		{
			String win = wins[index];
			win = win.trim();
			win = win.toLowerCase();
			win = win.substring(0, 1).toUpperCase() + win.substring(1);
			wins[index] = win;
		}
		this.name = name;
		this.wins = wins;
	}

	public boolean doesWin(ThrowableItem opponent)
	{
		for (String name : this.wins)
		{
			if (name.equals(opponent.getName()))
			{
				return true;
			}
		}
		return false;
	}

	public boolean doesTie(ThrowableItem opponent)
	{
		return opponent.getName().equals(name);
	}

	public boolean doesLose(ThrowableItem opponent)
	{
		if (!doesTie(opponent))
		{
			return !doesWin(opponent);
		} else
		{
			return false;
		}

	}

	public String getName()
	{
		return name;
	}

	public void addWins(String[] newWins)
	{
		String[] updated = new String[newWins.length + wins.length];
		for (int index = 0; index < wins.length; index++)
		{
			updated[index] = wins[index];
		}
		for (int index = wins.length; index < updated.length; index++)
		{
			updated[index] = newWins[index];
		}
		wins = newWins;
	}

	public void setWins(String[] wins)
	{
		this.wins = wins;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
