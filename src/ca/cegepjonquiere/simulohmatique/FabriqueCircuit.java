package ca.cegepjonquiere.simulohmatique;

import java.util.Stack;

public class FabriqueCircuit {

    public static AbstractCircuit fabriquerCircuit(String description) throws IllegalArgumentException {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("\nVotre circuit ne concorde pas... Il manque une parenthèse ou un crochet.");
        AbstractCircuit p = null;
        Stack<AbstractCircuit> pileSousCircuit = new Stack<>();
        Stack<Character> delim = new Stack<>();
        String[] sousCircuit = description.split(" ");
        for (String s : sousCircuit) {
            switch (s) {
                case "(" -> {
                    delim.push('(');
                    CircuitSerie cs1 = new CircuitSerie();
                    if (!pileSousCircuit.empty()) {
                        pileSousCircuit.peek().ajouterComposant(cs1);
                    }
                    pileSousCircuit.push(cs1);
                }
                case ")" -> {
                    p = pileSousCircuit.pop();
                    if (p.empty()){
                        throw new IllegalArgumentException("\nVotre circuit est ouvert, il n'a aucun composants et le courant n'y circule pas... Veuillez entrez des composants dans votre circuit.");
                    }
                    if (delim.empty() || delim.pop() != '(') {
                        throw illegalArgumentException;
                    }
                }
                case "[" -> {
                    delim.push('[');
                    CircuitParallele cp1 = new CircuitParallele();
                    if (!pileSousCircuit.empty()) {
                        pileSousCircuit.peek().ajouterComposant(cp1);
                    }
                    pileSousCircuit.push(cp1);
                }
                case "]" -> {
                    p = pileSousCircuit.pop();
                    if (p.empty()){
                        throw new IllegalArgumentException("\nVotre circuit est ouvert, il n'a aucun composants et le courant n'y circule pas... Veuillez entrez des composants dans votre circuit.");
                    }
                    if (delim.empty() || delim.pop() != '[') {
                        throw illegalArgumentException;
                    }
                }
                default -> {
                    Resistor r = FabriqueResistor.fabriquerResistor(s);
                    if (r != null) {
                        pileSousCircuit.peek().ajouterComposant(r);
                    } else {
                        throw illegalArgumentException;
                    }
                }
            }

        }
        if (!delim.empty()) {
            throw illegalArgumentException;
        }
        return p;
    }
}

