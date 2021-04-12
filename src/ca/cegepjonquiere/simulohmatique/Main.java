package ca.cegepjonquiere.simulohmatique;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("""
                Pour construire votre circuit veuillez procéder comme suit:

                Pour OUVRIR un circuit en SÉRIE --> (
                Pour OUVRIR un circuit en PARALLÈLE --> [
                Pour FERMER un circuit en SÉRIE --> )
                Pour FERMER un circuit en PARALLÈLE --> ]

                N'oubliez pas de séparer CHAQUES caractères par un ESPACE
                Pour vous aider --> Code couleur résisteur: (NBROJVbMGLAo)

                Veuillez créer vos circuits avec vos résisteurs -->\s""");

        Scanner sc = new Scanner(System.in);
        String choixUtilisateur = sc.nextLine();

        try {
            AbstractCircuit circuit = FabriqueCircuit.fabriquerCircuit(choixUtilisateur);
            System.out.println("\nVeuillez entrer une tension en volts --> ");
            double choixUtilisateurTension = sc.nextInt();
            circuit.mettreSousTension(choixUtilisateurTension);
            System.out.println(circuit);
        }  catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }  finally {
            if (sc != null){
            sc.close();
            }
        }
    }
}
