import java.util.Scanner;

public class CrapsMetricsMonitor{
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int maxRolls;
	private int naturalCount;
	private int crapsCount;
	private int maxWinStreak;
	private int maxLoseStreak;
	private int maxBalance;
	private int gamesWhenMax;

	public CrapsMetricsMonitor(){
		gamesPlayed = 0;
		gamesWon = 0;
		gamesLost = 0;
		maxRolls = 1;
		naturalCount = 0;
		crapsCount = 0;
		maxWinStreak = 0;
		maxLoseStreak = 0;
		maxBalance = 0;
		gamesWhenMax = 0;
	}

	//getters
	public int getGamesPlayed(){
		return gamesPlayed;
	}

	public int getGamesWon(){
		return gamesWon;
	}

	public int getGamesLost(){
		return gamesLost;
	}

	public int getMaxRolls(){
		return maxRolls;
	}

	public int getNaturalCount(){
		return naturalCount;
	}

	public int getCrapsCount(){
		return crapsCount;
	}

	public int getMaxWinStreak(){
		return maxWinStreak;
	}

	public int getMaxLoseStreak(){
		return maxLoseStreak;
	}

	public int getMaxBalance(){
		return maxBalance;
	}

	public int getGamesWhenMax(){
		return gamesWhenMax;
	}

	//setters
	public void incrementGamesPlayed(){
		gamesPlayed++;
	}

	public void incrementGamesWon(){
		gamesWon++;
	}

	public void incrementGamesLost(){
		gamesLost++;
	}

	public void setMaxRolls(int currentRoll){
		if(currentRoll > maxRolls){
			maxRolls = currentRoll;
			}
	}

	public void setMaxWinStreak(int currentWinStreak){
		if(currentWinStreak > maxWinStreak){
			maxWinStreak = currentWinStreak;
		}
	}

	public void setMaxLoseStreak(int currentLoseStreak){
		if(currentLoseStreak > maxLoseStreak){
			maxLoseStreak = currentLoseStreak;
		}
	}

	public void incrementNaturalCount(){
		naturalCount++;
	}

	public void incrementCrapsCount(){
		crapsCount++;
	}

	public boolean setMaxBalance(int currentBalance){
		if(currentBalance > maxBalance){
			maxBalance = currentBalance;
			return true;
		}
		return false;
	}


	public void setGamesWhenMax(int gamesWhenMax){
		this.gamesWhenMax = gamesWhenMax;
	}

	public void printStatistics(){
		System.out.println("*****************************");
		System.out.println("*** SIMULATION STATISTICS ***");
		System.out.println("*****************************");
		System.out.println("Games played: " +  gamesPlayed);
		System.out.println("Games won: "+ gamesWon);
		System.out.println("Games lost: " + gamesLost);
		System.out.println("Maximum rolls in a single game: " + maxRolls);
		System.out.println("Natural Count: " + naturalCount);
		System.out.println("Craps count: " + crapsCount);
		System.out.println("Maximum winning streak: " + maxWinStreak);
		System.out.println("Maximum loosing streak: " + maxLoseStreak);
		System.out.println("Maximum balance: " + maxBalance + " during game " + gamesWhenMax);

	}
	
}