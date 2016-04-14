package test;

/*
 * the point of this class is to show a few different ways we can make a die.
 * Ill make this class have a specified number of sides and we can just have slight variations of it for
 * bigger dice. Ill also have 2 different ways we can make it and ill just comment 1 out. not sure which 
 * way is better so we can figure that out.
 * The other die class ill make will just be a die with no size specification so itll take parameters each time.
 */

import java.util.Random;

public class Die6 {
	
	private static Random random = new Random();
	
	public Die6() {
	}
	
	/**
	 * basic roll die method that gets a random number 1-6 and spits it out
	 * @return the result of a random roll from 1-6
	 */
	public int roll() {
		return random.nextInt(6) + 1;
	}
	
	/**
	 * a more complex roll method that we may need depending on the mechanics we end up deciding to use.
	 * rolls the number of dice that you tell it to and returns the largest result of those rolls.
	 * (can also be changed to smallest depending on what we want or we can just make 2 seperate methods)
	 * @param numberOfDice the number of dice to roll
	 * @return the largest(?) of the rolls
	 */
	public int roll(int numberOfDice) {
		int[] results = new int[numberOfDice];
		int largest = 0;
		for (int i = 0; i < numberOfDice; i++) {
			results[i] = roll();
			if (i == 0 || results[i] > largest) {
				largest = results[i];
			}
		}
		return largest;
	}
	
	/**
	 * this method roll the number of dice specified and returns the sum of the top "x" dice
	 * alternatively if were only ever going to want the top 3 dice of any roll than we eliminate the "x" param
	 * and this method becomes much more efficient. again we could also make a different method called rollTop3
	 * or something
	 * can be changed to take bottom x if needed
	 * @param numberOfDice number of dice to be rolled
	 * @param x how many of the top dice to be added to sum
	 * @return the sum of the top x dice
	 */
	public int roll(int numberOfDice, int x) {
		int sum = 0;
		if (x > numberOfDice || numberOfDice == 1) {
			System.out.println("you messed up.");
		} else if (numberOfDice == x) {
			for (int i = 0; i < numberOfDice; i++) {
				sum+=roll();
			}
		} else {
			int[] results = new int[numberOfDice];
			int[] top = new int[x];
			for (int i = 0; i < numberOfDice; i++) {
				results[i] = roll();
			}
			top[0] = results[0];
			for (int i = 0; i < numberOfDice; i++) {
				for (int j = 0; j < x; j++) {
					if (results[i] > top[j]) {
						for (int k = x-1; k > j; k--) {
							top[k] = top[k-1];
						}
						top[j] = results[i];
						break;
					}
				}
			}
			for (int i = 0; i < x; i++) {
				sum+=top[i];
			}
		}
		return sum;
	}
	
}
