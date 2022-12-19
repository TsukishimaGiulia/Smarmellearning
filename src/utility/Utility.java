package utility;

import domain.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utility {

    public static Predicate<Animale> specieCodata = animale -> animale instanceof AnimaleCodato;

    public static Predicate<Animale> specieAlata = animale -> animale instanceof AnimaleAlato;

    public static List<Animale> caricaAnimali(){
        List<Animale> animali = new ArrayList<Animale>();

        Animale l1 = new Leone("gino", "croccantini", 10, new Date(2020,10,10), 100, 50, 20);
        Animale l2 = new Leone("kimba", "croccantini", 2, new Date(2022,10,10), 10, 15, 10);
        Animale l3 = new Leone("simba", "croccantini", 12, new Date(2018,10,10), 106.4, 60, 30);
        Animale l4 = new Leone("pyroar", "baccananas", 10, new Date(2019,10,10), 100, 40, 40);

        animali.add(l1);
        animali.add(l2);
        animali.add(l3);
        animali.add(l4);

        Animale t1 = new Tigre("torakiki", "frittelle", 8, new Date(2020,02,10), 30, 40, 25);
        Animale t2 = new Tigre("raffaello", "cinghiale", 7, new Date(2016,8,20), 27.2, 40, 20);
        Animale t3 = new Tigre("dora", "pizza", 2, new Date(2020,9,15), 10, 15, 17);

        animali.add(t1);
        animali.add(t2);
        animali.add(t3);

        Animale a1 = new Aquila("leonardo", "pizza", 7, new Date(2016,8,20), 25.7, 37, 32);
        Animale a2 = new Aquila("nomeACaso", "coniglio", 5, new Date(2019,10,20), 30.4, 30, 40);

        animali.add(a1);
        animali.add(a2);

        return animali;
    }

    public static List<Animale> getSpecie(Predicate<Animale> specieAnimale){
        List<Animale> ris = new ArrayList<>();
        for(Animale a : caricaAnimali())
            if(specieAnimale.test(a))
                ris.add(a);
        return ris;
    }

    public static Map<String,List<? extends Animale>> caricaAnimali2(){
        List<Animale> animali = new ArrayList<Animale>();
        List<AnimaleCodato> animaliCodati = new ArrayList<>();
        List<AnimaleAlato> animaliAlati = new ArrayList<>();
        List<Leone> leoni = new ArrayList<Leone>();
        List<Tigre> tigri = new ArrayList<Tigre>();
        List<Aquila> aquile = new ArrayList<Aquila>();
        Map<String, List<? extends Animale>> ris = new HashMap<>();

        Leone l1 = new Leone("gino", "croccantini", 10, new Date(2020,10,10), 100, 50, 20);
        Leone l2 = new Leone("kimba", "croccantini", 2, new Date(2022,10,10), 10, 15, 10);
        Leone l3 = new Leone("simba", "croccantini", 12, new Date(2018,10,10), 106.4, 60, 30);
        Leone l4 = new Leone("pyroar", "baccananas", 10, new Date(2019,10,10), 100, 40, 40);

        leoni.add(l1);
        leoni.add(l2);
        leoni.add(l3);
        leoni.add(l4);
//        animali.add(l1);
//        animali.add(l2);
//        animali.add(l3);
//        animali.add(l4);
        animaliCodati.addAll(leoni);
        animali.addAll(leoni);

        Tigre t1 = new Tigre("torakiki", "frittelle", 8, new Date(2020,02,10), 30, 40, 25);
        Tigre t2 = new Tigre("raffaello", "cinghiale", 7, new Date(2016,8,20), 27.2, 40, 20);
        Tigre t3 = new Tigre("dora", "pizza", 2, new Date(2020,9,15), 10, 15, 17);

        tigri.add(t1);
        tigri.add(t2);
        tigri.add(t3);
//        animali.add(t1);
//        animali.add(t2);

        animaliCodati.addAll(tigri);
        animali.addAll(tigri);

        Aquila a1 = new Aquila("leonardo", "pizza", 7, new Date(2016,8,20), 25.7, 37, 32);
        Aquila a2 = new Aquila("nomeACaso", "coniglio", 5, new Date(2019,10,20), 30.4, 30, 40);

        aquile.add(a1);
        aquile.add(a2);
        animaliAlati.addAll(aquile);
        animali.addAll(aquile);
//        animali.add(a1);
//        animali.add(a2);

        ris.put("animali", animali);
        ris.put("alati", animaliAlati);
        ris.put("codati", animaliCodati);
        ris.put("leoni", leoni);
        ris.put("tigri", tigri);
        ris.put("aquile", aquile);

        return ris;
    }


    // 1. ALTEZZA
    public static List<Animale> animaliPiuAlti2(String animali){
        List<Animale> ris = new ArrayList<>();
        double max= 0;

        //troviamo il max
        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getAltezza()>max)
                max=a.getAltezza();
        }

        //aggiungiamo al set tutti gli animali (di quella specie) per cui peso = max;
        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getAltezza()==max)
                ris.add(a);
        }

        return ris;
    }

    public static List<Animale> animaliPiuBassi(Predicate<Animale>specieAnimale){
        List<Animale> ris = new ArrayList<>();
        double min= Double.MAX_VALUE;
        List<Animale> animali = getSpecie(specieAnimale);

        for(Animale a : animali){
            if(a.getAltezza()<min)
                min=a.getAltezza();
        }

        for(Animale a : animali){
            if(a.getAltezza()==min)
                ris.add(a);
        }

        return ris;
    }

    public static List<Animale> animaliPiuBassi2(String animali){
        List<Animale> ris = new ArrayList<>();
        double min= Double.MAX_VALUE;

        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getAltezza()<min)
                min=a.getAltezza();
        }

        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getAltezza()==min)
                ris.add(a);
        }

        return ris;
    }

    // 2. PESO
    public static List<Animale> animaliPiuPesanti(Predicate<Animale>specieAnimale){
        List<Animale> ris = new ArrayList<>();
        double max= 0;
        List<Animale> animali = getSpecie(specieAnimale);

        for(Animale a : animali){
            if(a.getPeso()>max)
                max=a.getPeso();
        }

        for(Animale a : animali){
            if(a.getPeso()==max)
                ris.add(a);
        }

        return ris;
    }

    public static List<Animale> animaliPiuPesanti2(String animali){
        List<Animale> ris = new ArrayList<>();
        double max= 0;

        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getPeso()>max)
                max=a.getPeso();
        }

        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getPeso()==max)
                ris.add(a);
        }

        return ris;
    }

    public static List<Animale> animaliPiuLeggeri(Predicate<Animale> specieAnimale){
        List<Animale> ris = new ArrayList<>();
        List<Animale> animali = getSpecie(specieAnimale);
        double min = Double.MAX_VALUE;

        for(Animale a : animali){
            if(a.getPeso()<min)
                min=a.getPeso();
        }

        for(Animale a : animali){
            if(a.getPeso()==min)
                ris.add(a);
        }

        return ris;
    }

    public static List<Animale> animaliPiuLeggeri2(String animali){
        List<Animale> ris = new ArrayList<>();
        double min = Double.MAX_VALUE;

        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getPeso()<min)
                min=a.getPeso();
        }

        for(Animale a : caricaAnimali2().get(animali)){
            if(a.getPeso()==min)
                ris.add(a);
        }

        return ris;
    }

    // 3. CODA PIU' LUNGA
    public static List<AnimaleCodato> animaliCodaMax(){
        List<AnimaleCodato> ris = new ArrayList<>();
        double max = 0;

        for(Animale a : getSpecie(specieCodata)){
            AnimaleCodato ac = (AnimaleCodato)a;
            if(ac.getLunghezzaCoda()>max){
                ris.clear();
                ris.add(ac);
                max = ac.getLunghezzaCoda();
            } else if (ac.getLunghezzaCoda()==max) {
                ris.add(ac);
            }
        }
    return ris;

    }

    public static List<AnimaleCodato> animaliCodaMax2(){
        List<AnimaleCodato> ris = new ArrayList<>();
        double max = 0;
        List<? extends Animale> acs = caricaAnimali2().get("codati");

        for(AnimaleCodato ac : acs){
            if(ac.getLunghezzaCoda()>max){
                ris.clear();
                ris.add(ac);
                max = ac.getLunghezzaCoda();
            } else if (ac.getLunghezzaCoda()==max) {
                ris.add(ac);
            }
        }
        return ris;

    }

    // 4. APERTURA ALARE MAGGIORE
    public static List<AnimaleAlato> animaliAperturaAlareMax(){
        List<AnimaleAlato> ris = new ArrayList<>();
        double max = 0;

        for(Animale a : getSpecie(specieAlata)){
            AnimaleAlato ac = (AnimaleAlato)a;
            if(ac.getAperturaAlare()>max){
                ris.clear();
                ris.add(ac);
                max = ac.getAperturaAlare();
            } else if (ac.getAperturaAlare()==max) {
                ris.add(ac);
            }
        }
        return ris;
    }


}
