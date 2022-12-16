package main;

import domain.*;
import domain.Animale;
import utility.Utility;

import java.util.function.Predicate;

public class Main {

    // Deve essere possibile effettuare le seguenti interrogazioni al sistema:
    // 1. per ogni specie, ricerca dell'esemplare più alto e più basso
    // 2. per ogni specie, ricerca dell'esemplare più pesante e più leggero
    // 3. per gli animali dotati di coda, l'esemplare con la coda più lunga di tutto lo zoo nel complesso
    // 4. per gli animali dotati di ali, l'esemplare con la maggiore apertura alare

    public static void main(String[] args) {

        Predicate<Animale> specieLeone = animale -> animale instanceof Leone;
        //prendiTigri
        Predicate<Animale> specieTigre = animale -> animale instanceof Tigre;
        //prendiAquile
        Predicate<Animale> specieAquila = animale -> animale instanceof Aquila;


        Predicate<Animale> specieOrso = animale -> animale instanceof Orso;

        System.out.println("\n\nElenco animali:");
        for(Animale a : Utility.caricaAnimali())
            System.out.println(a);

        System.out.println("\n\nOrsi più pesanti: ");
        for(Animale a : Utility.animaliPiuPesanti(specieOrso))
            System.out.println(a.toString());


        System.out.println("\n\nLeoni più bassi:");
        for(Animale a : Utility.animaliPiuBassi(specieLeone))
            System.out.println(a.toString());


        System.out.println("\n\nTigri più alte:");
        for(Animale a : Utility.animaliPiuAlti(specieTigre))
            System.out.println(a.toString());

        System.out.println("\n\nAquile più alte:");
        for(Animale a : Utility.animaliPiuAlti(specieAquila))
            System.out.println(a.toString());


        System.out.println("\n\nAnimali con coda più lunga:");
        for(AnimaleCodato a : Utility.animaliCodaMax())
            System.out.println(a.toString());


        System.out.println("\n\nAnimali con maggiore apertura alare:");
        for(AnimaleAlato a :Utility.animaliAperturaAlareMax())
            System.out.println(a.toString());
    }
}