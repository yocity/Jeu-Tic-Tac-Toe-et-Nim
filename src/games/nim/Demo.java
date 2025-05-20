package games.nim;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonjour à tous, on va jouer au Nim");

        System.out.println("Vous devez choisir un nombre de matchs, un nombre de matchs à enlever et le nom de joueur 1 et 2 pour jouer");

        System.out.println("Entrez le nombre total d'allumettes");
        int n = scanner.nextInt();

        System.out.println("Entrez le nombre maximum d'allumettes à enlever en une fois");
        int k = scanner.nextInt();

        System.out.println("Nom du joueur 1");
        String j1 = scanner.next();

        System.out.println("Nom du joueur 2");
        String j2 = scanner.next();

        Nim nim = new Nim(n, k, j1, j2);

        while (!nim.isOver()) {
            System.out.println(nim.situationToString());

            System.out.println("C'est au tour de " + nim.getCurrentPlayer() + " de jouer.");

            System.out.println("Quel est le nombre d'allumettes à enlever ?");
            int nb_allumettes = scanner.nextInt();

            nim.removeMatches(nb_allumettes);
        }

        System.out.println("Le gagnant est " + nim.getWinner() + " !");

        scanner.close();
    }
}
