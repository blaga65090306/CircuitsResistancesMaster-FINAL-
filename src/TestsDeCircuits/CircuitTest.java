package TestsDeCircuits;


import ca.cegepjonquiere.simulohmatique.AbstractCircuit;
import ca.cegepjonquiere.simulohmatique.CircuitParallele;
import ca.cegepjonquiere.simulohmatique.CircuitSerie;
import ca.cegepjonquiere.simulohmatique.Resistor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CircuitTest {

    private Resistor[] res;

    @Test
    public void serieTest() {
        CircuitSerie p1 = new CircuitSerie();
        for (Resistor r : res)
            p1.ajouterComposant(r);

        p1.mettreSousTension(24);

        assertEquals(29, p1.calculerResistance(), 0.1);
        assertEquals(0.827, p1.calculerCourant(), 0.1);
        assertEquals(24, p1.calculerTension(), 0.1);
    }

    //C'est mon test de circuit en serie
    @Test
    public void serieTest2(){
        CircuitSerie cs1 = new CircuitSerie();
        for (Resistor r : res)
            cs1.ajouterComposant(r);

        cs1.mettreSousTension(9);

        assertEquals(29, cs1.calculerResistance(), 0.1);
        assertEquals(0.31, cs1.calculerCourant(), 0.1);
        assertEquals(9, cs1.calculerTension(),0.1);
    }

    @Test
    public void circuitXTest(){
    Resistor rA = new Resistor();
    rA.setResistance(10);
    Resistor rB = new Resistor();
    rB.setResistance(30);
    Resistor rC = new Resistor();
    rC.setResistance(40);
    Resistor rD = new Resistor();
    rD.setResistance(30);
    Resistor rE = new Resistor();
    rE.setResistance(50);
    Resistor rF = new Resistor();
    rF.setResistance(75);
    Resistor rG = new Resistor();
    rG.setResistance(150);
    Resistor rH = new Resistor();
    rH.setResistance(30);
    AbstractCircuit circuit = new CircuitSerie();
    circuit.ajouterComposant(rA);
    circuit.ajouterComposant(rB);
    AbstractCircuit circuit1 = new CircuitParallele();
    circuit1.ajouterComposant(rC);
    circuit1.ajouterComposant(circuit);
    AbstractCircuit circuit2 = new CircuitSerie();
    circuit2.ajouterComposant(rD);
    circuit2.ajouterComposant(circuit1);
    AbstractCircuit circuit3 = new CircuitParallele();
    circuit3.ajouterComposant(rE);
    circuit3.ajouterComposant(circuit2);
    AbstractCircuit circuit4 = new CircuitSerie();
    circuit4.ajouterComposant(rF);
    circuit4.ajouterComposant(circuit3);
    AbstractCircuit circuit5 = new CircuitParallele();
    circuit5.ajouterComposant(rG);
    circuit5.ajouterComposant(circuit4);
    AbstractCircuit circuit6 = new CircuitSerie();
    circuit6.ajouterComposant(rH);
    circuit6.ajouterComposant(circuit5);

    circuit6.mettreSousTension(600);
    assertEquals(90, circuit6.calculerResistance(), 0.1);
    assertEquals(20/3, circuit6.calculerCourant(), 0.1);
    assertEquals(600, circuit6.calculerTension(), 0.1);




    }

    @Test
    public void mixteTest(){
        Resistor r1 = new Resistor();
        r1.setResistance(5);
        Resistor r2 = new Resistor();
        r2.setResistance(8);
        Resistor r3 = new Resistor();
        r3.setResistance(8);
        Resistor r4 = new Resistor();
        r4.setResistance(6);
        AbstractCircuit circuit = new CircuitParallele();
        circuit.ajouterComposant(r2);
        circuit.ajouterComposant(r3);
        AbstractCircuit circuit2 = new CircuitSerie();
        circuit2.ajouterComposant(r1);
        circuit2.ajouterComposant(circuit);
        circuit2.ajouterComposant(r4);

        circuit2.mettreSousTension(60);
        assertEquals(15, circuit2.calculerResistance(), 0.1);
        assertEquals(4, circuit2.calculerCourant(), 0.1);
        assertEquals(60, circuit2.calculerTension(), 0.1);
    }

    @Test
    public void paralleleTest() {
        CircuitParallele p1 = new CircuitParallele();
        for (Resistor r : res)
            p1.ajouterComposant(r);

        p1.mettreSousTension(120);

        assertEquals(1.518, p1.calculerResistance(), 0.1);
        assertEquals(79.05, p1.calculerCourant(), 0.1);
        assertEquals(120, p1.calculerTension(), 0.1);
    }

    @BeforeEach
    public void setUpResistors() {
        res = new Resistor[4];
        res[0] = new Resistor();
        res[0].setResistance(5);
        res[1] = new Resistor();
        res[1].setResistance(4);
        res[2] = new Resistor();
        res[2].setResistance(12);
        res[3] = new Resistor();
        res[3].setResistance(8);
    }
}
