package games.genericgames;

import gamestests.genericgames.AbstractGameTests;
import gamestests.genericgames.NimTests;
import gamestests.genericgames.TicTacToeTests;

public class Test {

	public static void main(String[] args) {

		boolean ok = true;

		AbstractGameTests abstractGameTester =new AbstractGameTests();
		ok = ok && abstractGameTester.testGetCurrentPlayer();
		ok = ok && abstractGameTester.testExecute();
		
		NimTests nimTester =new NimTests();
		ok = ok && nimTester.testGetInitialNbMatches();
		ok = ok && nimTester.testGetCurrentNbMatches();
		ok = ok && nimTester.testGetCurrentPlayer();
		ok = ok && nimTester.testExecute();
		ok = ok && nimTester.testIsValid();
		ok = ok && nimTester.testValidMoves();
		ok = ok && nimTester.testIsOver();
		ok = ok && nimTester.testGetWinner();
		ok = ok && nimTester.testCopy();
		
		TicTacToeTests ticTacToeTester =new TicTacToeTests();
		ok = ok && ticTacToeTester.testGetCurrentPlayer();
		ok = ok && ticTacToeTester.testExecuteAndIsValid();
		ok = ok && ticTacToeTester.testValidMoves(); 
		ok = ok && ticTacToeTester.testWins(); // si wins() est implementee
		ok = ok && ticTacToeTester.testGetWinner();
		ok = ok && ticTacToeTester.testIsOver();
		ok = ok && ticTacToeTester.testCopy();
		
		System.out.println(ok ? "All tests OK" : "At least one test KO");
	}

}

/*
javac -d ../build games/genericgames/Nim.java
javac -d ../build games/genericgames/TicTacToe.java
javac -d ../build -cp ../lib/gamestests.jar games/genericgames/Test.java
java -cp ../build/:../lib/gamestests.jar games.genericgames.Test

javadoc -d ../docs games/genericgames/Nim.java games/genericgames/TicTacToe.java games/genericgames/AbstractGame.java -cp ../lib/gamestests.jar
*/

