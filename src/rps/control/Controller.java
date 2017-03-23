package rps.control;

import java.util.Scanner;

import rps.model.Items;
import rps.model.Game;
import rps.model.ThrowableItem;

public class Controller
{
	private boolean keepGoing;
	private boolean hasPlayed;
	private Scanner scan;
	private Game game;

	public Controller()
	{
		keepGoing = true;
		hasPlayed = false;
		scan = new Scanner(System.in);
		Items.AddItem("Rock", new String[]{"lizard","Scissors","Wizard","SpiderMan"});
		Items.AddItem("Paper", new String[]{"Rock","Spock","Gun","BatMan"});
		Items.AddItem("Scissors", new String[]{"Paper","Lizard","Wizard","SpiderMan"});
		Items.AddItem("Spock", new String[]{"Rock","Scissors","SpiderMan","Wizard"});
		Items.AddItem("Lizard", new String[]{"Paper","Spock","Batman","Gun"});
		Items.AddItem("Wizard", new String[]{"Gun","Lizard","Batman","Paper"});
		Items.AddItem("Batman", new String[]{"Spiderman","Spock","Rock","Scissors"});
		Items.AddItem("Spiderman", new String[]{"Paper","Gun","Lizard","Wizard"});
		Items.AddItem("Gun", new String[]{"Rock","Spock","Batman","Scissors"});
		
		
		game = new Game();

	}

	public void start()
	{
		while (keepGoing)
		{
			hasPlayed = false;
			while (!hasPlayed)
			{

				try
				{
					String names = "";
					for(int index = 0; index< Items.getAllItems().size();index++)
					{
						if(index!=0)
						{
							names += ", ";
						}
						names += Items.getAllNames().get(index);
					}
					System.out.println("Please enter only one of the following:\n"+names);
					System.out.println(game.play(Items.getItem(scan.nextLine())));
					System.out.println("You have won " + game.getScore() + " of your games");
					hasPlayed = true;
				} catch (Exception e)
				{
					System.out.println("invalid input");
				}

			}
			keepGoing = continueDialog();

		}
	}

	private boolean continueDialog()
	{
		System.out.println("continue? y/n");
		String response = scan.nextLine();
		if (response.equalsIgnoreCase("n") || response.toLowerCase().contains("no"))
		{
			return false;
		} else if (response.equalsIgnoreCase("y") || response.toLowerCase().contains("yes"))
		{
			return true;
		} else
		{
			System.out.println("invalid input");
			return continueDialog();
		}

	}
}
