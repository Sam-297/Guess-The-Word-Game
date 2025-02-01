package game;

import java.util.Random;

public class Words {
	
	private String[] randomWords = {
            "elephant", "happiness", "penguin", "butterfly", "rainbow",
            "mountain", "sunshine", "chocolate", "whisper", "fireworks"
        };
	
	private String selectedWord;
	private Random random = new Random();
	private char[] letters;
	
	public Words() {
		selectedWord = randomWords[random.nextInt(randomWords.length)];
		letters = new char[selectedWord.length()];
		
	}
	
	public String toString() {
		StringBuilder text = new StringBuilder();
		
		for (char letter:letters) {
			text.append(letter == '\u0000'? '-' : letter);
			text.append(' ');
		}
		return text.toString();
	}

	public boolean guess(char letter) {
		
		boolean guessedRight = false;
		
		for (int i = 0; i <selectedWord.length(); i++) {
			if(letter == selectedWord.charAt(i)) {
				letters[i] = letter;
				guessedRight = true;
			}
		}
		return guessedRight;
	}

	public boolean isGuessedRight() {
		for(char i:letters) {
			if (i == '\u0000')
				return false;
		}
		return true;
	}
	
	public String correctWord(){
		return selectedWord;
	}
}
