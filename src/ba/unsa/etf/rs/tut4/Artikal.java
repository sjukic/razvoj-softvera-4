package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal(){
    }
    public Artikal(String sifra, String naziv, double cijena){
        setSifra(sifra);
        setNaziv(naziv);
        setCijena(cijena);
    }

    public Artikal(String recenica){
        String[] atributi = recenica.split(",");
        setSifra(atributi[0]);
        setNaziv(atributi[1]);
        setCijena(Double.parseDouble(atributi[2]));
    }
    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setSifra(String sifra) {
        if (sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra = sifra;
    }

    public void setNaziv(String naziv) {
        if (naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        this.naziv = naziv;
    }

    public void setCijena(double cijena) {
        if(cijena <= 0) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return this.sifra + "," + this.naziv + "," + this.cijena;
    }

    public static void izbaciDuplikate(ArrayList<Artikal> artikli){
        for(int i=0 ; i < artikli.size(); i++){
            for (int j=i+1; j < artikli.size(); j++){
                if(artikli.get(i).equals(artikli.get(j))){
                    artikli.remove(j);
                    j--;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o){
        Artikal artikal = (Artikal)o;
        if (this.sifra.equals(((Artikal) o).sifra) && this.naziv.equals(((Artikal) o).naziv) && this.cijena == ((Artikal) o).cijena)
            return true;
        return false;
    }
}
