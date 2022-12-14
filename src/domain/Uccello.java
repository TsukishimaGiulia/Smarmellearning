package domain;

import java.util.Date;

public class Uccello extends Animale {
    private double aperturaAlare;

    public Uccello(String nome, String ciboPref, int eta, Date dataEntrata, double peso, double altezza, double aperturaAlare) {
        super(nome, ciboPref, eta, dataEntrata, peso, altezza);
        this.aperturaAlare = aperturaAlare;
    }

    public double getAperturaAlare() {
        return aperturaAlare;
    }

    public void setAperturaAlare(double aperturaAlare) {
        this.aperturaAlare = aperturaAlare;
    }
}
