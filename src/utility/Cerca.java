package utility;

import domain.*;

import java.util.*;

public class Cerca {

    // carico specie singole

    public static List<Leone> caricaLeoni(){
        List<Leone> leoni = new ArrayList<Leone>();

        Leone l1 = new Leone("gino", "croccantini", 10, new Date(2020,10,10), 100, 50, 20);
        Leone l2 = new Leone("kimba", "croccantini", 2, new Date(2022,10,10), 10, 15, 10);
        Leone l3 = new Leone("simba", "croccantini", 12, new Date(2018,10,10), 106.4, 60, 30);
        Leone l4 = new Leone("pyroar", "baccananas", 10, new Date(2019,10,10), 100, 40, 40);

        leoni.add(l1);
        leoni.add(l2);
        leoni.add(l3);
        leoni.add(l4);

        return leoni;
    }

    public static List<Tigre> caricaTigri(){
        List<Tigre> tigri = new ArrayList<Tigre>();

        Tigre t1 = new Tigre("torakiki", "frittelle", 8, new Date(2020,02,10), 30, 40, 25);
        Tigre t2 = new Tigre("raffaello", "pizza", 7, new Date(2016,8,20), 27.2, 40, 20);
        Tigre t3 = new Tigre("donatello", "pizza", 2, new Date(2020,9,15), 10, 15, 17);

        tigri.add(t1);
        tigri.add(t2);
        tigri.add(t3);

        return tigri;
    }

    public static List<Aquila> caricaAquile() {
        List<Aquila> aquile = new ArrayList<Aquila>();

        Aquila a1 = new Aquila("leonardo", "pizza", 7, new Date(2016,8,20), 25.7, 37, 32);
        Aquila a2 = new Aquila("nomeACaso", "coniglio", 5, new Date(2019,10,20), 30.4, 30, 40);

        aquile.add(a1);
        aquile.add(a2);

        return aquile;
    }

    // raggruppo specie codate/alate
    // [E' un po' scocciante dover creare i gruppi e la mappa manualmente"]
    public static List<AnimaleCodato> codati(){
        List<AnimaleCodato> ris = new ArrayList<>();

        ris.addAll(caricaLeoni());
        ris.addAll(caricaTigri());

        return ris;
    }

    public static List<AnimaleAlato> alati(){
        List<AnimaleAlato> ris = new ArrayList<>();
        ris.addAll(caricaAquile());
        return ris;
    }

    // Mappa per permettere la scelta della specie. Problema (nel branch prova): anche se il generic di List extends Animale, ritorna come se fosse una lista di Animale, quindi se invece sono Codati, non riesce ad accedere alle proprietà specifiche: per questo sotto ho dovuto usare direttamente un List<AnimaleCodato>
    public static Map<String,List<? extends Animale>> mappaAnimali(){
        List<Animale> animali = new ArrayList<Animale>();
        Map<String, List<? extends Animale>> ris = new HashMap<>();

        animali.addAll(codati());
        animali.addAll(alati());

        ris.put("animali", animali);
        ris.put("alati", alati());
        ris.put("codati", codati());
        ris.put("leoni", caricaLeoni());
        ris.put("tigri", caricaTigri());
        ris.put("aquile", caricaAquile());

        return ris;
    }


    // 1. ALTEZZA
    public static List<Animale> animaliPiuAlti(String animali){
        List<Animale> ris = new ArrayList<>();
        double max= 0;

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getAltezza()>max)
                max=a.getAltezza();
        }

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getAltezza()==max)
                ris.add(a);
        }

        return ris;
    }

    public static List<Animale> animaliPiuBassi(String animali){
        List<Animale> ris = new ArrayList<>();
        double min= Double.MAX_VALUE;

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getAltezza()<min)
                min=a.getAltezza();
        }

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getAltezza()==min)
                ris.add(a);
        }

        return ris;
    }

    // 2. PESO

    public static List<Animale> animaliPiuPesanti(String animali){
        List<Animale> ris = new ArrayList<>();
        double max= 0;

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getPeso()>max)
                max=a.getPeso();
        }

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getPeso()==max)
                ris.add(a);
        }

        return ris;
    }


    public static List<Animale> animaliPiuLeggeri(String animali){
        List<Animale> ris = new ArrayList<>();
        double min = Double.MAX_VALUE;

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getPeso()<min)
                min=a.getPeso();
        }

        for(Animale a : mappaAnimali().get(animali)){
            if(a.getPeso()==min)
                ris.add(a);
        }

        return ris;
    }

    // 3. CODA PIU' LUNGA

    public static List<AnimaleCodato> animaliCodaMax(){
        List<AnimaleCodato> ris = new ArrayList<>();
        List<AnimaleCodato> animaliCodati = codati();   // 'sta cosa mi disturba: se volessi avere i leoni con coda max (fra i leoni)?
        double max = 0;

        for(AnimaleCodato ac : animaliCodati){
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
        List<AnimaleAlato> animaliAlati = alati();

        double max = 0;

        for(AnimaleAlato aa : animaliAlati){
            if(aa.getAperturaAlare()>max){
                ris.clear();
                ris.add(aa);
                max = aa.getAperturaAlare();
            } else if (aa.getAperturaAlare()==max) {
                ris.add(aa);
            }
        }
        return ris;
    }

}
