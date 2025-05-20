package games.plays;

import games.genericgames.Game;
import games.players.Player;

public class Orchestrator {
    private Game game;

    public Orchestrator(Game game) {
        this.game = game;
    }

    public void play() {
        while (!game.isOver()) {
            System.out.println();

            System.out.println("C'est au joueur "+ game.getCurrentPlayer() + " de jouer");

            System.out.println();

            System.out.println(game.situationToString());

            Player joureur_courant = game.getCurrentPlayer();

            int move = joureur_courant.chooseMove(game);

            if (!game.isValid(move)) {
                System.out.println("Coup invalide. Veuillez choisir un coup valide.");
                continue;
            }
            
            System.out.println(game.moveToString(move));

            game.execute(move);
        }
        
        System.out.println();
        System.out.println(game.situationToString());
        System.out.println();

        if (game.isOver()) {
            Player winner = game.getWinner();
            if (winner != null) {
                System.out.println("Le gagnant est : " + winner.toString());
            } else {
                System.out.println("Match nul !");
            }
        }
    }
}
