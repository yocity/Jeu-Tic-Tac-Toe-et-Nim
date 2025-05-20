package games.players;

import gamestests.players.NegamaxPlayerTests;

public class TestNegamax {

	public static void main(String[] args) {

		boolean ok = true;

		NegamaxPlayerTests negamaxTester = new NegamaxPlayerTests();
		ok = ok && negamaxTester.testEvaluate();
		ok = ok && negamaxTester.testChooseMove(); 
		
		System.out.println(ok ? "All tests OK" : "At least one test KO");
	}

}

/*
javac -d ../build games/players/NegamaxPlayer.java
javac -d ../build -cp ../lib/gamestests.jar games/players/TestNegamax.java
java -cp ../build/:../lib/gamestests.jar games.players.TestNegamax

javadoc -d ../docs games/players/NegamaxPlayer.java  -cp ../lib/gamestests.jar
*/

