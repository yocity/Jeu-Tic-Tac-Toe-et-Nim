package games.genericgames;

import games.players.Player;

public abstract class AbstractGame implements Game{

    protected Player joueur1;
    protected Player joueur2;
    protected Player joueur_courant;

    public AbstractGame(Player joueur1, Player joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueur_courant = joueur1;
    }

    protected abstract void doExecute(int coup);

    public void execute(int coup){
        doExecute(coup);
        this.joueur_courant = joueur_courant.equals(joueur1) ? joueur2 : joueur1;
    }

    public Player getCurrentPlayer(){
        return joueur_courant;
    }    
}
