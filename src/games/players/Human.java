package games.players;

import java.util.List;
import java.util.Scanner;

import games.genericgames.Game;

public class Human implements Player {
    private String name;
    private Scanner scanner;
    
    public Human(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
    }

    @Override
    public int chooseMove(Game game) {
        List<Integer> validMoves = game.validMoves();
        System.out.println("Les coups valides sont : " + validMoves);

        int chosenMove;
        do {
            System.out.print(name + ", choisissez un coup parmi les coups valides : ");
            chosenMove = scanner.nextInt();

            if (!validMoves.contains(chosenMove)) {
                System.out.println("Coup invalide. Veuillez choisir un coup valide.");
            }
        } while (!validMoves.contains(chosenMove));

        return chosenMove;
    }

    @Override
    public String toString() {
        return name;
    }
}
