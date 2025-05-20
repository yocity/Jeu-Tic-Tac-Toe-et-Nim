package games.tictactoe;
import gamestests.tictactoe.TicTacToeTests;

public class Test {

	public static void main(String[] args) {

		boolean ok = true;
		TicTacToeTests ticTacToeTester=new TicTacToeTests();
		ok = ok && ticTacToeTester.testGetCurrentPlayer();
		ok = ok && ticTacToeTester.testExecuteAndIsValid();
		ok = ok && ticTacToeTester.testGetWinner();
		ok = ok && ticTacToeTester.testIsOver();
		ok = ok && ticTacToeTester.testWins();

		System.out.println(ok ? "All tests OK" : "At least one test KO");
	}

}

/*
javac -d ../build games/tictactoe/Demo.java
java -cp ../build/ games.tictactoe.Demo
javac -d ../build -cp ../lib/gamestests.jar games/tictactoe/Test.java
java -cp ../build/:../lib/gamestests.jar games.tictactoe.Test
javadoc -d ../docs games/tictactoe/Demo.java -cp ../lib/gamestests.jar
*/
