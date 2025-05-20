package games.players;

import gamestests.players.HumanTests; 
import gamestests.players.RandomPlayerTests;

public class Test {

	public static void main(String[] args) {

		boolean ok = true;

		HumanTests humanTester =new HumanTests();// Change argument to true in next call to reactivate printing
		ok = ok && humanTester.testChooseMove(true);
		
		RandomPlayerTests randomTester =new RandomPlayerTests();
		ok = ok && randomTester.testChooseMove();
        
        	System.out.println(ok ? "All tests OK" : "At least one test KO");
	}

}

/*
javac -d ../build games/players/Human.java
javac -d ../build games/players/RandomPlayer.java
javac -d ../build -cp ../lib/gamestests.jar games/players/Test.java
java -cp ../build/:../lib/gamestests.jar games.players.Test

javadoc -d ../docs games/players/Human.java games/players/RandomPlayer.java  -cp ../lib/gamestests.jar
*/

