package games.players;

import java.util.List;

import games.genericgames.Game;

public class NegamaxPlayer implements Player{
    
    public NegamaxPlayer(){}

    public int evaluate(Game situation) {
        Game copie = situation.copy();
    
        if (copie.getWinner() == copie.getCurrentPlayer()) {
            	return 1;
        } 
        else if (copie.getWinner() == null && copie.isOver()) {
            	return 0;
        } 
        else if (copie.getWinner() != null) {
           	return -1;
        }
        else{
            Integer res = null;
            List<Integer> coups = copie.validMoves();
            for (Integer coup : coups) {
                Game prochainEtat = copie.copy();
                prochainEtat.execute(coup);

                int v = -evaluate(prochainEtat);
            
                if (res == null || v > res) {
                    res = v;
                }
            }
            return res;
        }
    }
    
    @Override
    public int chooseMove(Game situation) {
        Integer meilleureValeur = null;
        Integer meilleurCoup = null;
    
        List<Integer> coups = situation.validMoves();
        for (Integer coup : coups) {
            Game copie = situation.copy();
            copie.execute(coup);
    
            int v = -evaluate(copie);
    
            if (meilleureValeur == null || v > meilleureValeur) {
                meilleureValeur = v;
                meilleurCoup = coup;
            }
        }
        return meilleurCoup;
    }
    
}
