package games.plays;

import gamestests.plays.OrchestratorTests;

public class Test {

	public static void main(String[] args) {

		boolean ok = true;

		OrchestratorTests tester = new OrchestratorTests();// Change argument to true in next call to reactivate printing
		ok = ok && tester.testPlay(true);
		
		System.out.println(ok ? "All tests OK" : "At least one test KO");
	}

}

/*
javac -d ../build games/plays/DemoNim.java
javac -d ../build games/plays/DemoTicTacToe.java
javac -d ../build -cp ../lib/gamestests.jar games/plays/Test.java
java -cp ../build/ games.plays.DemoNim
java -cp ../build/ games.plays.DemoTicTacToe
java -cp ../build/:../lib/gamestests.jar games.plays.Test

javadoc -d ../docs games/plays/Orchestrator.java  -cp ../lib/gamestests.jar
*/

