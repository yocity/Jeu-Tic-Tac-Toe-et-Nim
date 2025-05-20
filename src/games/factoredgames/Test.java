package games.factoredgames;

import gamestests.factoredgames.AbstractGameTests;
import gamestests.factoredgames.NimTests;
import gamestests.factoredgames.TicTacToeTests;

public class Test {

	public static void main(String[] args) {

		boolean ok = true;

		AbstractGameTests abstractGameTester = new AbstractGameTests();
		ok = ok && abstractGameTester.testGetCurrentPlayer();
		ok = ok && abstractGameTester.testExecute();

		NimTests nimTester = new NimTests();
		ok = ok && nimTester.testExtends();
		ok = ok && nimTester.testGetCurrentPlayer();
		ok = ok && nimTester.testExecute();
		ok = ok && nimTester.testIsValid();
		ok = ok && nimTester.testIsOver();
		ok = ok && nimTester.testGetWinner();
		
		TicTacToeTests ticTacToeTester = new TicTacToeTests();
		ok = ok && ticTacToeTester.testExtends();
		ok = ok && ticTacToeTester.testGetCurrentPlayer();
		ok = ok && ticTacToeTester.testExecuteAndIsValid();
		ok = ok && ticTacToeTester.testWins();
		ok = ok && ticTacToeTester.testGetWinner();
		ok = ok && ticTacToeTester.testIsOver();

		System.out.println(ok ? "All tests OK" : "At least one test KO");
	}

}

/*
javac -d ../build games/factoredgames/DemoNim.java
javac -d ../build games/factoredgames/DemoTicTacToe.java
javac -d ../build -cp ../lib/gamestests.jar games/factoredgames/Test.java
java -cp ../build/ games.factoredgames.DemoNim
java -cp ../build/ games.factoredgames.DemoTicTacToe
java -cp ../build/:../lib/gamestests.jar games.factoredgames.Test

javadoc -d ../docs games/factoredgames/Nim.java games/factoredgames/TicTacToe.java games/factoredgames/AbstractGame.java  -cp ../lib/gamestests.jar
*/

