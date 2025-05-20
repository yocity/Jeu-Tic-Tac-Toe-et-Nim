package games.players;

import java.util.List;
import java.util.Random;

import games.genericgames.Game;

public class RandomPlayer implements Player {
    private Random random;

    public RandomPlayer(Random random) {
        this.random = new Random();
    }

    @Override
    public int chooseMove(Game game) {
        List<Integer> validMoves = game.validMoves();
    
        if (validMoves.isEmpty()) {
            System.out.println("Aucun coup valide disponible.");
            return -1;
        }
    
        int chosenMove;
        do {
            int randomIndex = random.nextInt(validMoves.size());
            chosenMove = validMoves.get(randomIndex);
            
        } while (!validMoves.contains(chosenMove));
    
        return chosenMove;
    }
    
    @Override
    public String toString() {
        return "Joueur aléatoire n°" + this.hashCode();
    }
}

