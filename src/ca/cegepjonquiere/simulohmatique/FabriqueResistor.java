package ca.cegepjonquiere.simulohmatique;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FabriqueResistor {

    enum CodeCouleurResistor {
        N(0, 1, 0),
        B(1, 10, 0.01),
        R(2, 100, 0.02),
        O(3, 1000, 0.03),
        J(4, 10000, 0.04),
        V(5, 100000, 0.005),
        b(6, 1000000, 0.0025),
        M(7, 10000000, 0.001),
        G(8, 100000000, 0.0005),
        L(9, 1000000000, 0),
        A(0, 0.01, 0.1),
        o(0, 0.1, 0.05);

        private final int valeur;
        private final double multiplicateur;
        private final double tolerance;

        CodeCouleurResistor(int valeur, double multiplicateur, double tolerance) {
            this.valeur = valeur;
            this.multiplicateur = multiplicateur;
            this.tolerance = tolerance;
        }

    }

    public static Resistor fabriquerResistor(String couleurs) {
        if(couleurs == null){
            return null;
        }
        Pattern CodeOhm = Pattern.compile("[NBROJVbMGL][NBROJVbMGLAo]{2,3}[BROJVbMGAo]");
        Matcher CodeResistor = CodeOhm.matcher(couleurs);

        if (!CodeResistor.matches()) {
            return null;
        }
        Resistor r = new Resistor();
        if (couleurs.length() == 5) {
            CodeCouleurResistor premiereCouleur = CodeCouleurResistor.valueOf(couleurs.substring(0, 1));
            CodeCouleurResistor deuxiemeCouleur = CodeCouleurResistor.valueOf(couleurs.substring(1, 2));
            CodeCouleurResistor troisiemeCouleur = CodeCouleurResistor.valueOf(couleurs.substring(2, 3));
            CodeCouleurResistor quatriemeCouleur = CodeCouleurResistor.valueOf(couleurs.substring(3, 4));
            CodeCouleurResistor cinquiemeCouleur = CodeCouleurResistor.valueOf(couleurs.substring(4, 5));
            double resistance = 0;
            resistance += premiereCouleur.valeur * 100;
            resistance += deuxiemeCouleur.valeur * 10;
            resistance += troisiemeCouleur.valeur;
            resistance *= quatriemeCouleur.multiplicateur;
            r.setResistance(resistance);
            r.setTolerance(cinquiemeCouleur.tolerance);
        }
        if (couleurs.length() == 4) {
            CodeCouleurResistor premiereCouleur = CodeCouleurResistor.valueOf(couleurs.substring(0, 1));
            CodeCouleurResistor deuxiemeCouleur = CodeCouleurResistor.valueOf(couleurs.substring(1, 2));
            CodeCouleurResistor troisiemeCouleur = CodeCouleurResistor.valueOf(couleurs.substring(2, 3));
            CodeCouleurResistor quatriemeCouleur = CodeCouleurResistor.valueOf(couleurs.substring(3, 4));
            double resistance = 0;
            resistance += premiereCouleur.valeur * 10;
            resistance += deuxiemeCouleur.valeur;
            resistance *= troisiemeCouleur.multiplicateur;
            r.setResistance(resistance);
            r.setTolerance(quatriemeCouleur.tolerance);
        }
        return r;
    }
}




