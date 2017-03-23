package rps.model;

import java.text.DecimalFormat;

public class Game
{
	private int wins;
	private int losses;
	private int games;
	private CpuPlayer cpu;
	
	public Game()
	{
		wins = 0;
		losses = 0;
		games = 0;
		cpu = new CpuPlayer();
	}
	
	public String play(ThrowableItem playerItem)
	{
		ThrowableItem cpuItem = cpu.getThrow();
		String prefix = "The player's " + playerItem.getName();
		String suffix = "the cpu's " + cpuItem.getName();
		String results = "";
		if(playerItem.doesWin(cpuItem))
		{
			results = prefix + " beats " + suffix;
			wins++;
		}
		else if(playerItem.doesLose(cpuItem))
		{
			results = prefix + " is destroyed by " + suffix;
			losses++;
		}
		else
		{
			results = prefix +" ties " + suffix;
		}
		games ++;
		return results;
		
	}
	
	public String getScore()
	{
		if(wins == 0)
		{
			return "none";
		}
		else
		{
		return DecimalFormat.getPercentInstance().format((double)wins/(wins+losses));
		}
	}

}
