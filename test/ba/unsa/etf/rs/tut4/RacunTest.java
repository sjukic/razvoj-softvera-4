package ba.unsa.etf.rs.tut4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    @Test
    void test1() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("JAJ", "Jaje", 0.25), 5);
        assertEquals(3.45, r.ukupanIznos());
    }

    @Test
    void testPrazno() {
        Racun r = new Racun();
        assertEquals(0, r.ukupanIznos());
    }

    //Test tutorijal 4

    @Test
    void testMetodeGetSviArtikli(){
        Racun novi = new Racun();
        novi.dodajStavku(new Artikal("HB01", "Hljeb", 0.9),5);
        novi.dodajStavku(new Artikal("HB02,Mlijeko,1.5"),4);
        novi.dodajStavku(new Artikal("HB03,Sir,6.5"),2);
        novi.dodajStavku(new Artikal("HB04,Banana,2.35"),1);
        assertEquals(novi.getSviArtikli().size(),4);
    }

    @Test
    void testMetodeGetSviArtikli1(){
        Racun novi = new Racun();
        novi.dodajStavku(new Artikal("HB01", "Hljeb", 0.9),5);
        novi.dodajStavku(new Artikal("HB02,Mlijeko,1.5"),4);
        novi.dodajStavku(new Artikal("HB03,Sir,6.5"),2);
        novi.dodajStavku(new Artikal("HB04,Banana,2.35"),1);
        novi.dodajStavku(new Artikal("HB05,Kivi,3.55"),1);
        novi.dodajStavku(new Artikal("HB06,Olovka,2.50"),2);
        assertEquals(novi.getSviArtikli().size(),6);
    }
    @Test
    void testMetodeGetSviArtikli2(){
        Racun novi = new Racun();
        novi.dodajStavku(new Artikal("HB01", "Hljeb", 0.9),5);
        novi.dodajStavku(new Artikal("HB02,Mlijeko,1.5"),4);
        novi.dodajStavku(new Artikal("HB03,Sir,6.5"),2);
        novi.dodajStavku(new Artikal("HB04,Banana,2.35"),1);
        novi.dodajStavku(new Artikal("HB05,Kivi,3.55"),1);
        novi.dodajStavku(new Artikal("HB06,Olovka,2.50"),2);
        assertEquals(novi.getSviArtikli().get(3),new Artikal("HB04,Banana,2.35"));
        assertEquals(novi.getSviArtikli().get(5).getNaziv(),"Olovka");
    }

    @Test
    void testKolicinaArtikla(){
        Racun novi = new Racun();
        novi.dodajStavku(new Artikal("HB01", "Hljeb", 0.9),5);
        novi.dodajStavku(new Artikal("HB02,Mlijeko,1.5"),4);
        novi.dodajStavku(new Artikal("HB03,Sir,6.5"),2);
        novi.dodajStavku(new Artikal("HB04,Banana,2.35"),1);
        novi.dodajStavku(new Artikal("HB05,Kivi,3.55"),1);
        novi.dodajStavku(new Artikal("HB06,Olovka,2.50"),2);
        assertEquals(novi.getKolicinaArtikala().get(0),5);
        assertEquals(novi.getKolicinaArtikala().get(3),1);
    }

    @Test
    void testUkupanIznos1(){
        Racun novi = new Racun();
        novi.dodajStavku(new Artikal("HB01", "Hljeb", 0.9),5);
        novi.dodajStavku(new Artikal("HB02,Mlijeko,1.5"),4);
        novi.dodajStavku(new Artikal("HB03,Sir,6.5"),2);
        assertEquals(23.50,novi.ukupanIznos());
    }
}