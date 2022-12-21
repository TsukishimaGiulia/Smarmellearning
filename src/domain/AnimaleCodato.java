package domain;

import java.util.Date;

public abstract class AnimaleCodato extends Animale {

    private double lunghezzaCoda;

    public AnimaleCodato(String nome, String ciboPref, int eta, Date dataEntrata, double peso, double altezza, double lunghezzaCoda) {
        super(nome, ciboPref, eta, dataEntrata, peso, altezza);
        this.lunghezzaCoda = lunghezzaCoda;
    }

    public double getLunghezzaCoda() {
        return lunghezzaCoda;
    }

    public void setLunghezzaCoda(double lunghezzaCoda) {
        this.lunghezzaCoda = lunghezzaCoda;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString() +
                ", lunghezzaCoda=" + lunghezzaCoda;
    }
}
