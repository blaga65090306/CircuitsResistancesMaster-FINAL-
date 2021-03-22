package ca.cegepjonquiere.simulohmatique;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pour construire votre circuit veuillez procéder comme suit:\n" +
                "\nPour OUVRIR un circuit en SÉRIE --> (\n" +
                "Pour OUVRIR un circuit en PARALLÈLE --> [\n" +
                "Pour FERMER un circuit en SÉRIE --> )\n" +
                "Pour FERMER un circuit en PARALLÈLE --> ]\n" +
                "\nN'oubliez pas de séparer CHAQUES caractères par un ESPACE" +
                "\nPour vous aider --> Code couleur résisteur: (NBROJVbMGLAo)\n" +
                "\nVeuillez créer vos circuits avec vos résisteurs --> ");

        Scanner sc = new Scanner(System.in);
        String choixUtilisateur = sc.nextLine();
        AbstractCircuit circuit = FabriqueCircuit.fabriquerCircuit(choixUtilisateur);

        System.out.println("\nVeuillez entrer une tension en volts --> ");
        double choixUtilisateurTension = sc.nextInt();
        circuit.mettreSousTension(choixUtilisateurTension);

        System.out.println(circuit);

        sc.close();
    }
}
