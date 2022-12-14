package domain;

import java.util.Date;

public class Carnivoro extends Animale {

    private double lunghezzaCoda;

    public Carnivoro(String nome, String ciboPref, int eta, Date dataEntrata, double peso, double altezza, double lunghezzaCoda) {
        super(nome, ciboPref, eta, dataEntrata, peso, altezza);
        this.lunghezzaCoda = lunghezzaCoda;
    }

    public double getLunghezzaCoda() {
        return lunghezzaCoda;
    }

    public void setLunghezzaCoda(double lunghezzaCoda) {
        this.lunghezzaCoda = lunghezzaCoda;
    }
}
