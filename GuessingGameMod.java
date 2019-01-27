import java.util.Scanner;

public class GuessingGameMod 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		/*guess #, not quite go lower - guess another number (until person guesses number)
		 10 guesses - for loop
		 
		 
		 
		 boolean method which tests if input is all digits or not (entered string); returns an int 
		 .nextInt returns run time error if user enters something not an int
		 loop makes sure only ints, uses that int
		 Integer.parseInt(String str);
		 String <- ___.nextLine();
		 INSTEAD OF ____.nextInt();
		 
		 (int) (Math.random()* options) + lowestValue;
		 */
		System.out.println("Welcome to the Guessing Game!");
		System.out.println("Type the number corresponding to the level you want to play - 1, 2, 3, 4.");
		int level = userInput.nextInt();
		//== TESTS MEMORY ADDRESS, NOT EQUALITY!
		if (level == 1)
		{
			levelPlay(1);
		}
		if (level == 2)
		{
			levelPlay(2);
		}
		if (level == 3)
		{
			levelPlay(3);
		}	
		if (level == 4)
		{
			levelPlay(4);
		}
		if (level < 4 || level < 1)
		{
			main(args);
		}
	}
	public static void levelPlay(int level)
	{
		if (level > 4)
		{
			repeatGame(4, Array.guessCounts);
		}
		int goalNum = (int) (Math.random()*Math.pow(10, level))+1;
		System.out.println("Welcome to level " + level + "! The random number is some number between 1 and " + Math.pow(10, level) + ". Good luck!");
		Scanner userInput = new Scanner(System.in);
		//goalNum = randomly generated number from 0 to 20
		
		for (int i = 0; i < Math.pow(10, level); i++)
		{
			System.out.println("Guess a number.");
			int userGuess = userInput.nextInt();
			if (userGuess < goalNum)
			{
				System.out.println("Not quite, go higher.");
			}
			else if (userGuess > goalNum)
			{
				System.out.println("Not quite, go lower.");
			}
			else if(userGuess == goalNum)
			{
				System.out.println("Congrats, you guessed right! It took you " + Array.guessCount + " guess(es) to guess the right number!");
				Array.guessCounts[level-1] = Array.guessCount;
				//printArr(Array.guessCounts);
				levelPlay(level+1);
			}
			Array.guessCount++;
		}
	}
	
	public static void repeatGame(int level, int[] guessArray)
	{
		System.out.println("Your guess counts for each round were: ");
		printArr(guessArray);
		System.out.println("Do you want to play again? Answer 'yes' or 'no'");
		Scanner answer = new Scanner(System.in);
		String userAnswer = answer.nextLine();
		if (userAnswer == "yes")
		{
			String[] args = null;
			main(args);
		}
		if (userAnswer == "no")
		{
			System.out.println("Thanks for playing!");
		}
		System.exit(0);
	}
	
	public static void printArr(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i] + ", ");
			if(i == arr.length - 1)
			{
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
	/*public static void intermediate(int level)
	{
		Random generator = new Random();
		int currentLevel = level;
		System.out.println("Welcome to level 2! The random number is some number between 1 and 100. Good luck!");
		Scanner userInputTwo = new Scanner(System.in);
		int guessCount = 0;
		int goalNum = generator.nextInt(100) + 1;
		//goalNum = randomly generated number from 0 to 20
		
		for (int i = 0; i < 10000000; i++)
		{
			System.out.println("Guess a number.");
			int userGuessTwo = userInputTwo.nextInt();
			if (userGuessTwo < goalNum)
			{
				System.out.println("Not quite, go higher.");
			}
			else if (userGuessTwo > goalNum)
			{
				System.out.println("Not quite, go lower.");
			}
			else if(userGuessTwo == goalNum)
			{
				System.out.println("Congrats, you guessed right! It took you " + guessCount + " guess(es)  to guess the right number!");
				Array.guessCounts[2] = guessCount;
				advanced(currentLevel++);
			}
			guessCount++;
		}
	}
	public static void advanced(int level)
	{
		Random generator = new Random();
		int currentLevel = level;
		System.out.println("Welcome to level 3! The random number is some number between 1 and 1,000. Good luck!");
		Scanner userInputThree = new Scanner(System.in);
		int guessCount = 0;
		int goalNum = generator.nextInt(1000) + 1;
		//goalNum = randomly generated number from 0 to 20
		
		for (int i = 0; i < 10000000; i++)
		{
			System.out.println("Guess a number.");
			int userGuessThree = userInputThree.nextInt();
			if (userGuessThree < goalNum)
			{
				System.out.println("Not quite, go higher.");
			}
			else if (userGuessThree > goalNum)
			{
				System.out.println("Not quite, go lower.");
			}
			else if(userGuessThree == goalNum)
			{
				System.out.println("Congrats, you guessed right! It took you " + guessCount + " guess(es) to guess the right number!");
				Array.guessCounts[3] = guessCount;
				expert(currentLevel++);
			}
			guessCount++;
			
		}
	}
	public static void expert(int level)
	{
		Random generator = new Random();
		int currentLevel = level;
		System.out.println("Welcome to the final level! The random number is some number between 1 and 10,000. Good luck!");
		Scanner userInputFour = new Scanner(System.in);
		int guessCount = 0;
		int goalNum = generator.nextInt(10000) + 1;
		//goalNum = randomly generated number from 0 to 20
	
		for (int i = 0; i < 10000000; i++)
		{
			System.out.println("Guess a number.");
			int userGuessFour = userInputFour.nextInt();
			if (userGuessFour < goalNum)
			{
				System.out.println("Not quite, go higher.");
			}
			else if (userGuessFour > goalNum)
			{
				System.out.println("Not quite, go lower.");
			}
			else if(userGuessFour == goalNum)
			{
				System.out.println("Congrats, you guessed right! It took you " + guessCount + " guess(es) to guess the right number!");
				Array.guessCounts[4] = guessCount;
				repeatGame(currentLevel, Array.guessCounts);
			}
			guessCount++;	
		}
	}
	*/
	
	
}

