package ca.cegepjonquiere.simulohmatique;

import java.util.Scanner;

public class Main {

    private static final String Parallele = "P" ;
    private static final String Serie = "S";

    public static void main(String[] args) {

        System.out.println("Pour construire votre circuit veuillez procéder comme suit:\nPour débuter un circuit en série --> '('\nPour débuter un circuit en parallèle --> '['\n" +
                "Pour fermer un circuit en série --> ')'\nPour fermer un circuit en parallèle --> ']'\nN'oubliez pas de séparer chaque caractères par un espace");

        Scanner sc = new Scanner(System.in);
        String choixUtilisateur = sc.nextLine();
        AbstractCircuit circuit = FabriqueCircuit.fabriquerCircuit(choixUtilisateur);

        System.out.println("\nEntrez une tension en volts");
        double choixUtilisateurTension = sc.nextInt();
        circuit.mettreSousTension(choixUtilisateurTension);

        System.out.println(circuit);

        sc.close();
    }
}
