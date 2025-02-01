package game;

import java.util.Scanner;

public class GuessTheWord {
	
	private boolean play = true;
	private Words randomWord = new Words();
	private Scanner scanner = new Scanner(System.in);
	private int rounds = 10;
	private char lastRound;
	
	public void start() {
		do {
			showWord();
			getInput();
			checkInput();			
		}while(play);
	}
	
	void showWord() {
		System.out.println("You have "+rounds+" guesses left.");
		System.out.println(randomWord);
	}
	
	void getInput() {
		System.out.println("Enter a letter to guess the word: ");
		String userGuess = scanner.nextLine();
		lastRound = userGuess.charAt(0);
	}
	
	void checkInput() {
		boolean isGuessedRight = randomWord.guess(lastRound);
		if(isGuessedRight) {
			if (randomWord.isGuessedRight()) {
				System.out.println(randomWord);
				System.out.println("Congratulations! You guessed the word correctly.");
				play = false;
				}
		}
		else {
			rounds--;
		}
		if (rounds == 0) {
			System.out.println("Game Over! You lost.");
			System.out.println("The word was '"+randomWord.correctWord()+"'.");
			play = false;
		}
	}

	public void end() {
		scanner.close();
	}
}
