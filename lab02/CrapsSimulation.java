import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class CrapsSimulation{
	private CrapsGame crapsGame;
	private CrapsMetricsMonitor crapsMM;
	private Scanner s;
	private String username;
	private String replay;
	private boolean legalName;
	private int balance;
	private int bet;
	private int winStreak;
	private int loseStreak;

	public CrapsSimulation(){
		crapsMM = new CrapsMetricsMonitor();
		crapsGame = new CrapsGame(crapsMM);
		s = new Scanner(System.in);
		username = "";
		legalName = true;
		balance = 0;
		bet = 0;
		winStreak = 0;
		loseStreak = 0;
	}

	public void resetCrapsSimulation(){
		crapsMM = new CrapsMetricsMonitor();
		crapsGame = new CrapsGame(crapsMM);
		s = new Scanner(System.in);
		username = "";
		legalName = true; 
		balance = 0;
		bet = 0;
		winStreak = 0;
		loseStreak = 0;
	}

	public void start(){
		s = new Scanner(System.in);
		System.out.print("Welcome to SimCraps! Enter your username: ");
		username = s.nextLine();
		for(int i = 0; i < username.length(); i++){
			if(Character.isWhitespace(username.charAt(i))){
				legalName = false;
			}
		}
		while(legalName == false){
			s = new Scanner(System.in);
			System.out.println("Illegal username. Please don't use whitespaces.");
			System.out.print("Enter your username: ");
			username = s.nextLine();
			legalName = true;
			for(int i = 0; i < username.length(); i++){
				if(Character.isWhitespace(username.charAt(i))){
					legalName = false;
				}
			}
		}
		
		System.out.println("Hello " + username + '!');
		s = new Scanner(System.in);
		System.out.print("Enter the amount of money you will bring to the table: ");
		balance = Integer.parseInt(s.nextLine());
		crapsMM.setMaxBalance(balance);
		s = new Scanner(System.in);
		System.out.print("Enter the bet amount between $1 and $" + balance + ": ");
		bet = Integer.parseInt(s.nextLine());

		while(bet < 1 || bet > balance){
			s = new Scanner(System.in);
			System.out.print("Invalid bet! ");
			System.out.print("Enter the bet amount between $1 and $" + balance + ": ");
			bet = Integer.parseInt(s.nextLine());
		}
		System.out.println(username + " bets $" + bet);
		boolean gameResult = crapsGame.playGame();
		crapsGame.resetRolls();
		crapsMM.incrementGamesPlayed();
		if(gameResult == true){
			crapsMM.incrementGamesWon();
			winStreak++;
			crapsMM.setMaxWinStreak(winStreak);
			loseStreak = 0;
			balance += bet;
		}
		if(gameResult == false){
			crapsMM.incrementGamesLost();
			loseStreak++;
			crapsMM.setMaxLoseStreak(loseStreak);
			winStreak = 0;
			balance -= bet;
		}

		while(balance > 0){
			if(bet > balance){
				bet = balance;
			}
			if(crapsMM.setMaxBalance(balance)){
				crapsMM.setGamesWhenMax(crapsMM.getGamesPlayed());
			}
			System.out.println(username + "'s balance: " + balance + ". Playing a new game...");
			System.out.println(username + " bets $" + bet);
		boolean resultOfGame= crapsGame.playGame();
		crapsGame.resetRolls();
		crapsMM.incrementGamesPlayed();
		if(resultOfGame == true){
			crapsMM.incrementGamesWon();
			winStreak++;
			crapsMM.setMaxWinStreak(winStreak);
			loseStreak = 0;
			balance += bet;
		}
		if(resultOfGame == false){
			crapsMM.incrementGamesLost();
			loseStreak++;
			crapsMM.setMaxLoseStreak(loseStreak);
			winStreak = 0;
			balance -= bet;
		}

		}
		crapsMM.printStatistics();
		s = new Scanner(System.in);
		System.out.print("Replay? Enter 'y' or 'n': ");
		replay = s.nextLine();
		char replayAsChar = replay.charAt(0);
		if(replayAsChar == 'y'){
			resetCrapsSimulation();
			start();
		}

	}


}