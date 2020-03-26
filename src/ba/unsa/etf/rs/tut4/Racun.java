package ba.unsa.etf.rs.tut4;


import java.util.ArrayList;

public class Racun {
    private Artikal noviArtikal;
    private double kolicina;
    private ArrayList<Artikal> sviArtikli = new ArrayList<>();
    private ArrayList<Double> kolicinaArtikala = new ArrayList<>();

    public void dodajStavku (Artikal noviArtikal, double kolicina){
        this.noviArtikal = noviArtikal;
        this.kolicina = kolicina;
        sviArtikli.add(noviArtikal);
        kolicinaArtikala.add(kolicina);
    }

    public double ukupanIznos (){
        double racun = 0;
        for(int i=0 ; i<sviArtikli.size(); i++) {
             racun = racun + sviArtikli.get(i).getCijena() * kolicinaArtikala.get(i);
        }
        return racun;
    }
}
