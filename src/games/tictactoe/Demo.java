package games.tictactoe;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonjour à tous, on va jouer au Tactactoe");

        System.out.println("Vous devez entrez le nom des deux joueurs pour jouer");
        String j1, j2;

        while (true) {

            System.out.println("Nom du joueur 1");
            j1 = scanner.next();

            System.out.println("Nom du joueur 2");
            j2 = scanner.next();

            if (j1.equals(j2)) {
                System.out.println("Les deux joueurs ne peuvent pas avoir le meme nom");
            }
            else{
                break;
            }
            
        }
        
        TicTacToe tikTacToe = new TicTacToe(j1, j2);

        while (!tikTacToe.isOver()) {
            System.out.println(tikTacToe.situationToString());

            System.out.println("C'est au tour de " + tikTacToe.getCurrentPlayer() + " de jouer.");

            System.out.println("entre la ligne");
            int ligne = scanner.nextInt();

            System.out.println("entre la colonne");
            int colonne = scanner.nextInt();

            tikTacToe.execute(ligne, colonne);
        }
        System.out.println("Vainqueur: "+tikTacToe.getWinner());
        System.out.println("\n");
        System.out.println(tikTacToe.situationToString());
        scanner.close();
    }
}
