package main.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import main.java.controller.GameController.Event;
import main.java.model.Player;

public class ConsoleView implements IView{
	
	public final static String MENU = "-=[ Game of Chance MENU ]=-\n" +
									"1 - Play the pick a number game\n" +
									"2 - Play the No Match Dealer game\n" +
									"3 - Play the Find the Ace game\n" +
									"4 - View current high score\n" +
									"5 - Change your user Name\n" +
									"6 - Reset your account at 100 credits\n" +
									"7 - Quit\n";
	public final static String REGISTER = "-=-=-{ NEW PLAYER REGISTRATION }-=-=-\n" +
										"Enter your Name:";
	
	public final static String INVALID_CHOICE = "This is an invalid selection of choice";
	
	public final static String PickANumberGameRules = 	"\n###### Pick a Number ######\n"+
														"This game costs 10 credits to play. Simply pick a number\n"+
														"beetween 1 and 20, and if you pick the winning number, you\n"+
														"will win the jackpot of 100 credits!\n\n";
	
	PrintStream out;
	BufferedReader in;
	
	public ConsoleView(PrintStream out,BufferedReader in){
		this.out = out;
		this.in = in;
	}

	public void showMenu() {
		out.println(MENU);
	}

	public Event getUserEvent() throws IOException{
		Event event = null;
		int choice = 0;

		while(event == null){
			choice = in.read();
			if (choice == 1) event = Event.PlayPickNumer;
			if (choice == 2) event = Event.PlayNoMatchDealer;
			if (choice == 3) event = Event.PlayFindAce;
			if (choice == 4) event = Event.ViewHighscore;
			if (choice == 5) event = Event.ChangeName;
			if (choice == 6) event = Event.Reset;
			if (choice == 7) event = Event.Quit;
			else out.println(INVALID_CHOICE);
		}
	
		return event;
	}

	public Player registerPlayer() {
		out.println(REGISTER);
		String name = "";
		try {
			name = getName();
		} catch (IOException e) {
			name = "InvalidInputExceptionName";	// If userinput fails give dully-name (requirements-definition)
		}
		out.println("Welcome to the Game of Chance" + name +"\n" +
					"You have been given"+ Player.defaultCredits +" credits.\n");
		return new Player(name);
	}
	
	public String getName() throws IOException{
		String name = in.readLine();
		return name;
	}

	public void showHighScore(int highscore) {
		out.println("\n===================| HIGHSCORE |====================\n" +
					"You currently have the high score of" + highscore +" credits!\n");
	}

	public void showPickANumberGameRules() {
		out.println(PickANumberGameRules);
	}

	public int getNumberBetween(int from, int until) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void showResult(boolean won, int winningNumber) {
		// TODO Auto-generated method stub
		
	}
	
	

}
