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
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {

        System.out.println(
                "Pour construire votre circuit veuillez procéder comme suit: \n" +
                "  |       |       |       |      |      |      |      |    \n" +
                "  V       V       V       V      V      V      V      V    \n" +

                "\nPour " + ANSI_GREEN + "OUVRIR" + ANSI_RESET + " un circuit en" + ANSI_BLUE + " SÉRIE" + ANSI_RESET + " --> (" +
                "\nPour " + ANSI_GREEN + "OUVRIR" + ANSI_RESET + " un circuit en" + ANSI_YELLOW + " PARALLÈLE" + ANSI_RESET + " --> [" +
                "\nPour " + ANSI_RED + "FERMER" + ANSI_RESET + " un circuit en" + ANSI_BLUE + " SÉRIE" + ANSI_RESET + " --> )" +
                "\nPour " + ANSI_RED + "FERMER" + ANSI_RESET + " un circuit en" + ANSI_YELLOW+ " PARALLÈLE" + ANSI_RESET + " --> ]\n" +

                "\nN'oubliez pas de séparer " + ANSI_PURPLE + "CHAQUE" + ANSI_RESET + " caractère par un" + ANSI_CYAN + " ESPACE" + ANSI_RESET +
                "\nPour vous aider --> Code couleur résisteur: " + ANSI_GREEN_BACKGROUND + "(NBROJVbMGLAo)" + ANSI_RESET +
                "\n" + ANSI_PURPLE_BACKGROUND + "Exemple" + ANSI_RESET + ": [ GNRo ( VNRo BNRo ) RNRo ]\n" +

                "\nVeuillez créer vos circuits avec vos résisteurs\n" +
                "|       |       |       |       |      |      |\n" +
                "V       V       V       V       V      V      V" );

        Scanner sc = new Scanner(System.in);

        try (sc) {
            String choixUtilisateur = sc.nextLine();
            AbstractCircuit circuit = FabriqueCircuit.fabriquerCircuit(choixUtilisateur);
            System.out.print("\nVeuillez entrer une tension en volts --> ");
            double choixUtilisateurTension = sc.nextInt();
            circuit.mettreSousTension(choixUtilisateurTension);
            System.out.println(circuit);
        } catch (IllegalArgumentException e) { // C'est tannant je ne suis pas capable
            System.out.println(e.getMessage());// de faire imprimer "le circuit est vide veuillez entrer des résistances"
                                               // lorsque le circuit est ouvert mais ne contient aucun composants
        }
    }
}
