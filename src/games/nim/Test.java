package games.nim;
import gamestests.nim.NimTests;

public class Test {

	public static void main(String[] args) {

		boolean ok = true;
		NimTests nimTester = new NimTests();
		ok = ok && nimTester.testGetInitialNbMatches();
		ok = ok && nimTester.testGetCurrentNbMatches();
		ok = ok && nimTester.testGetCurrentPlayer();
		ok = ok && nimTester.testRemoveMatches();
		ok = ok && nimTester.testIsValid();
		ok = ok && nimTester.testIsOver();
		ok = ok && nimTester.testGetWinner();
		System.out.println(ok ? "All tests OK" : "At least one test KO");
	}

}

/*
javac -d ../build games/nim/Demo.java
java -cp ../build/ games.nim.Demo
javac -d ../build -cp ../lib/gamestests.jar games/nim/Test.java
java -cp ../build/:../lib/gamestests.jar games.nim.Test
javadoc -d ../docs games/nim/Nim.java  -cp ../lib/gamestests.jar
*/
