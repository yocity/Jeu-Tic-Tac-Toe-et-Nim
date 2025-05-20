package games.plays;
import java.util.Random;
import java.util.Scanner;

import games.genericgames.TicTacToe;
import games.players.Human;
import games.players.NegamaxPlayer;
import games.players.Player;
import games.players.RandomPlayer;

public class DemoTicTacToe {
    public static void main(String[] args) {
        System.out.println("Bonjour à tous, on va jouer au Tactactoe");
        System.out.println();
        Random rand = new Random(123);
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Human("Moi", scanner);
        //Player player1 =new RandomPlayer(rand);
        Player player2 = new NegamaxPlayer();
        TicTacToe game = new TicTacToe(player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();
    }
}

