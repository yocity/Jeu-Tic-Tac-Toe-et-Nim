package games.genericgames;

import java.util.ArrayList;
import java.util.List;

import games.players.Player;

public class TicTacToe extends AbstractGame{
    
    private String[][] jeu;

    public TicTacToe(Player joueur1, Player joueur2) {

        super(joueur1, joueur2);

        this.joueur_courant = joueur1;

        jeu = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jeu[i][j] = ".";
            }
        }
    }

    @Override
    public String situationToString() {
        String result = "  0 1 2\n";
    
        for (int i = 0; i < 3; i++) {
            result += i + " "; 
            for (int j = 0; j < 3; j++) {
                result += jeu[i][j];
                if (j < 2) {
                    result += " ";
                }
            }
            result += "\n";
        }
    
        return result;
    }    
    
    @Override
    public void doExecute(int coup){
        if(isValid(coup)){
            int ligne = coup / 3;
            int colonne = coup % 3;

            if(this.joueur_courant.equals(joueur1)){
                this.jeu[ligne][colonne] = "X";
            }
            else{
                this.jeu[ligne][colonne] = "O";
            }
        }
        else{
            System.out.println("Votre coup est invalide car le coup n'existe pas dans le tableau ou la case est occupe");
        }
    }

    public boolean isValid(int coup){
        int ligne = coup / 3;
        int colonne = coup % 3;
        return this.jeu[ligne][colonne].equals(".");
    }

    public boolean wins(Player joueur, int row, int column, int deltaRow, int deltaColumn) {
        if (row < 0 || column < 0 || 
            row + 2 * deltaRow < 0 || column + 2 * deltaColumn < 0 ||
            row + deltaRow >= jeu.length || column + deltaColumn >= jeu[0].length ||
            row + 2 * deltaRow >= jeu.length || column + 2 * deltaColumn >= jeu[0].length) {
            return false;
        }
    
        String j = joueur.equals(this.joueur1) ? "X" : "O";
    
        return jeu[row][column].equals(j) && 
               jeu[row + deltaRow][column + deltaColumn].equals(j) && 
               jeu[row + 2 * deltaRow][column + 2 * deltaColumn].equals(j);
    }

    public Player getWinner() {

        for (int i = 0; i < jeu.length; i++) {
            for (int j = 0; j < jeu[i].length; j++) {
                if (wins(this.joueur1, i, j, 0, 1)) return this.joueur1;
                if (wins(this.joueur2, i, j, 0, 1)) return this.joueur2;

                if (wins(this.joueur1, i, j, 1, 0)) return this.joueur1;
                if (wins(this.joueur2, i, j, 1, 0)) return this.joueur2;

                if (wins(this.joueur1, i, j, 1, 1)) return this.joueur1;
                if (wins(this.joueur2, i, j, 1, 1)) return this.joueur2;

                if (wins(this.joueur1, i, j, 1, -1)) return this.joueur1;
                if (wins(this.joueur2, i, j, 1, -1)) return this.joueur2;
            }
        }

        return null;
    }

    public boolean isOver() {
        if (getWinner() != null) {
            return true;
        }
        for (int i = 0; i < jeu.length; i++) {
            for (int j = 0; j < jeu[i].length; j++) {
                if (jeu[i][j].equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    @Override
    public List<Integer> validMoves(){
        List<Integer> coupValid = new ArrayList<>();

        for(int index=0; index<9; index++){
            int i = index / 3;
            int j = index % 3; 
            if (jeu[i][j].equals(".")) {
                coupValid.add(index);
            }
        }

        return coupValid;
    }

    @Override
    public String moveToString(int coup){
        int i = coup / 3;
        int j = coup % 3;

        return "Vous jouez la ligne "+i+" la colonne "+j;
    }

    @Override
    public Game copy() {
        TicTacToe res = new TicTacToe(this.joueur1, this.joueur2);

        String[][] jeuCopie = new String[3][3];
        for (int i = 0; i < this.jeu.length; i++) {
            for (int j = 0; j < this.jeu[i].length; j++) {
                jeuCopie[i][j] = this.jeu[i][j];
            }
        }

        res.jeu = jeuCopie;
        res.joueur1 = this.joueur1;
        res.joueur2 = this.joueur2;
        res.joueur_courant = this.joueur_courant;

        return res;
    }

    

}
