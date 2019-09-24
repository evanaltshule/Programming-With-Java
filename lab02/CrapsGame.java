import java.util.Scanner;
import java.util.Random;

public class CrapsGame{
	private int rolls;
	private CrapsMetricsMonitor monitor;

	public CrapsGame(CrapsMetricsMonitor monitor){
		this.monitor = monitor;
		rolls = 0;
	}

	public int getRolls(){
		return rolls;
	}

	public void resetRolls(){
		rolls = 0;
	}


	public boolean playGame(){
		Random generator = new Random();
		boolean stillRolling = true;
		int die1 = generator.nextInt(6) + 1;
		int die2 = generator.nextInt(6) + 1;
		int result = die1 + die2;
		rolls++;
		System.out.println("Rolled a " + result);
		if(result == 7 || result == 11){
			System.out.println("*****Natural! You win!*****");
			monitor.incrementNaturalCount();
			return true;
		}
		else if(result == 2 || result == 3 || result == 12){
			System.out.println("*****Craps! You loose.*****");
			monitor.incrementCrapsCount();
			return false;
		}
		int target = result;
		while(stillRolling){
			die1 = generator.nextInt(6) + 1;
			die2 = generator.nextInt(6) + 1;
			result = die1 + die2;
			rolls++;
			System.out.println("Rolled a " + result);
			if(result == target){
				System.out.println("*****Rolled the point! You win!*****");
				monitor.setMaxRolls(rolls);
				return true;
			}
			if(result == 7){
				System.out.println("*****Crap out! You loose.*****");
				monitor.setMaxRolls(rolls);
				return false;
			}
		}
		return true;
	}
}