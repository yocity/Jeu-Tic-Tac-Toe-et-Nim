package games.plays;

import java.util.Random;

import games.genericgames.Nim;
import games.players.Player;
import games.players.NegamaxPlayer;

public class DemoNim {
    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.println("Vous devez fournir deux arguments");
            System.out.println("Exemple d'utilisation : java -cp ../build/ games.plays.DemoNim 20 5");
            return;
        }

        int n = 0;
        int k = 0;

        try {
            n = Integer.parseInt(args[0]); 
            k = Integer.parseInt(args[1]);

            if (n <= 0 || k <= 0) {
                throw new IllegalArgumentException("Les valeurs des arguments doivent être positives");
            }

        } catch (NumberFormatException e) {
            System.out.println("Les arguments doivent être des entiers");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Bonjour à tous, on va jouer au Nim");
        System.out.println();

        Random rand = new Random(123);

        Player player1 = new NegamaxPlayer();
        Player player2 = new NegamaxPlayer();
        Nim game = new Nim(n, k, player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
    }
}
