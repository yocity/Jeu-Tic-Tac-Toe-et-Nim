package games.genericgames;

import java.util.ArrayList;
import java.util.List;

import games.players.Player;

public class Nim extends AbstractGame{

    private int nbAllumettesInitial;
    private int nbAllumettesMax;
    private int nb_courant;

    public Nim(int nbAllumettesInitial, int nbAllumettesMax, Player joueur1, Player joueur2) {
        super(joueur1, joueur2);
        this.nbAllumettesInitial = nbAllumettesInitial;
        this.nbAllumettesMax = nbAllumettesMax;
        this.joueur_courant = joueur1;
        this.nb_courant = nbAllumettesInitial;
    }

    public int getInitialNbMatches() {
        return this.nbAllumettesInitial;
    }

    public int getCurrentNbMatches() {
        return this.nb_courant;
    }

    public String situationToString() {
        return "Il reste " + this.nb_courant + " allumettes";
    }

    @Override 
    public void doExecute(int nb_allumettes){
        if(isValid(nb_allumettes)){
            this.nb_courant -= nb_allumettes;
        }
        else{
            System.out.println("Vous ne pouvez pas enlever plus d'allumettes que " + this.nbAllumettesMax);
        }
    }

    public boolean isValid(int nb_allumettes) {
        if(nb_allumettes > 0 && nb_allumettes <= this.nbAllumettesMax && nb_allumettes <= this.nb_courant){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isOver() {
        if(this.nb_courant == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public Player getWinner() {
        return isOver() ? (this.joueur_courant.equals(this.joueur1) ? this.joueur1 : this.joueur2) : null;
    }

    @Override
    public List<Integer> validMoves() {
        List<Integer> moves = new ArrayList<>();

        int maxMove = Math.min(this.nbAllumettesMax, nb_courant);

        for (int i = 1; i <= maxMove; i++) {
            moves.add(i);
        }

        return moves;
    }

    @Override
    public String moveToString(int coup){
        return "Vous avez enleve " + coup + " d'allumettes";
    }

    @Override
    public Game copy(){
        Nim res = new Nim(nbAllumettesInitial, nbAllumettesMax, joueur1, joueur2);
        res.nbAllumettesInitial = nbAllumettesInitial;
        res.nbAllumettesMax = nbAllumettesMax;
        res.joueur1 = super.joueur1;
        res.joueur2 = super.joueur2;
        res.nb_courant = nb_courant;
        res.joueur_courant = joueur_courant;
        return res;
    }

}
