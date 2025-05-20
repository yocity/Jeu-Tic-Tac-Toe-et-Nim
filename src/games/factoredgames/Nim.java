package games.factoredgames;

public class Nim extends AbstractGame{

    private int nbAllumettesInitial;
    private int nbAllumettesMax;
    private int nb_courant;

    public Nim(int nbAllumettesInitial, int nbAllumettesMax, String joueur1, String joueur2) {
        super(joueur1, joueur2);
        this.nbAllumettesInitial = nbAllumettesInitial;
        this.nbAllumettesMax = nbAllumettesMax;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
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
    public String getWinner() {
        return isOver() ? (this.joueur_courant.equals(this.joueur1) ? this.joueur1 : this.joueur2) : null;
    }

}
