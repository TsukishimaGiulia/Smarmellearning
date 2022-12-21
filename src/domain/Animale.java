package domain;

import java.time.LocalDate;
import java.util.Date;

public abstract class Animale {

    private String nome;
    private String ciboPref;
    private int eta;
    private Date dataEntrata;
    private double peso;
    private double altezza;

    public Animale(String nome, String ciboPref, int eta, Date dataEntrata, double peso, double altezza) {
        this.nome = nome;
        this.ciboPref = ciboPref;
        this.eta = eta;
        this.dataEntrata = dataEntrata;
        this.peso = peso;
        this.altezza = altezza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCiboPref() {
        return ciboPref;
    }

    public void setCiboPref(String ciboPref) {
        this.ciboPref = ciboPref;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Date getDataEntrata() {
        return dataEntrata;
    }

    public void setDataEntrata(Date dataEntrata) {
        this.dataEntrata = dataEntrata;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return "nome: " + nome +
                ", ciboPref: " + ciboPref +
                ", eta: " + eta +
                ", peso: " + peso +
                ", altezza: " + altezza;
    }
}
