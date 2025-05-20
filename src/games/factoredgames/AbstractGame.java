package games.factoredgames;

public abstract class AbstractGame{

    protected String joueur1;
    protected String joueur2;
    protected String joueur_courant;

    public AbstractGame(String joueur1, String joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueur_courant = joueur1;
    }

    protected abstract void doExecute(int coup);

    public void execute(int coup){
        doExecute(coup);
        this.joueur_courant = joueur_courant.equals(joueur1) ? joueur2 : joueur1;
    }

    public String getCurrentPlayer(){
        return joueur_courant;
    }    
}
