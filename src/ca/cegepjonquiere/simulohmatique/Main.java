package ca.cegepjonquiere.simulohmatique;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        System.out.println(
                "Pour construire votre circuit veuillez procéder comme suit:\n" +

                "\nPour " + ANSI_GREEN + "OUVRIR" + ANSI_RESET + " un circuit en" + ANSI_BLUE + " SÉRIE" + ANSI_RESET + " --> (" +
                "\nPour " + ANSI_GREEN + "OUVRIR" + ANSI_RESET + " un circuit en" + ANSI_YELLOW + " PARALLÈLE" + ANSI_RESET + " --> [" +
                "\nPour " + ANSI_RED + "FERMER" + ANSI_RESET + " un circuit en" + ANSI_BLUE + " SÉRIE" + ANSI_RESET + " --> )" +
                "\nPour " + ANSI_RED + "FERMER" + ANSI_RESET + " un circuit en" + ANSI_YELLOW+ " PARALLÈLE" + ANSI_RESET + " --> ]\n" +

                "\nN'oubliez pas de séparer " + ANSI_PURPLE + "CHAQUE" + ANSI_RESET + " caractère par un" + ANSI_CYAN + " ESPACE" + ANSI_RESET +
                "\nPour vous aider --> Code couleur résisteur: (NBROJVbMGLAo)\n" +

                "\nVeuillez créer vos circuits avec vos résisteurs -->\s");

        Scanner sc = new Scanner(System.in);

        try (sc) {
            String choixUtilisateur = sc.nextLine();
            AbstractCircuit circuit = FabriqueCircuit.fabriquerCircuit(choixUtilisateur);
            System.out.println("\nVeuillez entrer une tension en volts --> ");
            double choixUtilisateurTension = sc.nextInt();
            circuit.mettreSousTension(choixUtilisateurTension);
            System.out.println(circuit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
