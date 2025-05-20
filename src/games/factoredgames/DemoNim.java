package games.factoredgames;
import java.util.Scanner;

public class DemoNim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonjour à tous, on va jouer au Nim");

        System.out.println("Vous devez choisir un nombre de matchs, un nombre de matchs à enlever et le nom de joueur 1 et 2 pour jouer");

        int nbObjets = 0;
        int maxRetirer = 0;

        try {
            System.out.println("Entrez le nombre total d'allumettes");
            nbObjets = scanner.nextInt();

            System.out.println("Entrez le nombre maximum d'allumettes à enlever en une fois");
            maxRetirer = scanner.nextInt();

            if (nbObjets <= 0 || maxRetirer <= 0) {
                throw new IllegalArgumentException("Les valeurs des arguments doivent être positives");
            }

        } catch (NumberFormatException e) {
            System.out.println("Les arguments doivent être des entiers");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

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

        Nim nim = new Nim(nbObjets, maxRetirer, j1, j2);

        while (!nim.isOver()) {
            System.out.println(nim.situationToString());

            System.out.println("C'est au tour de " + nim.getCurrentPlayer() + " de jouer.");

            System.out.println("Quel est le nombre d'allumettes à enlever ?");
            int nb_allumettes = scanner.nextInt();

            nim.execute(nb_allumettes);
        }

        System.out.println("Le gagnant est " + nim.getWinner() + " !");

        scanner.close();
    }
}
