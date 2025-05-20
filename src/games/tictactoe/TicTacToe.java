package games.tictactoe;

public class TicTacToe{
    
    private String joueur1;
    private String joueur2;
    private String[][] jeu;
    private String joueur_courant;

    public TicTacToe(String joueur1, String joueur2) {

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueur_courant = joueur1;

        jeu = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jeu[i][j] = ".";
            }
        }
    }

    public String getCurrentPlayer(){
        return this.joueur_courant;
    }

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
    
    public void execute(int ligne, int colonne){
        if(isValid(ligne, colonne)){
            if(this.joueur_courant.equals(joueur1)){
                this.jeu[ligne][colonne] = "X";
            }
            else{
                this.jeu[ligne][colonne] = "O";
            }

            if(this.joueur_courant.equals(this.joueur1)){
                this.joueur_courant = this.joueur2;
            }
            else{
                this.joueur_courant = this.joueur1;
            }
        }
        else{
            System.out.println("Votre coup est invalide car le coup n'existe pas dans le tableau ou la case est occupe");
        }
    }

    public boolean isValid(int ligne, int colonne){
        return this.jeu[ligne][colonne].equals(".");
    }

    public boolean wins(String joueur, int row, int column, int deltaRow, int deltaColumn) {
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

    public String getWinner() {

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
        System.out.println("Match Null");
        return true;
    }

}
