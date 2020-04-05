package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;


public class Controller {
    public TextArea uzimaArtikle;
    public TextArea ispisArtikala;

    public TextArea ispisAktuelnogRacuna;
    public Spinner spinnerKolicina;
    public ChoiceBox padajucaLista;
    public Button buttonZaDodavanjeArtikala;
    public Tab karticaRacun;
    public Button buttonZaIspisRacuna;

    private ArrayList<Artikal> listaArtikala = new ArrayList<>();
    private Racun sadasnjiRacun = new Racun();

    public void dodajArtikle(ActionEvent actionEvent) {
        String sviArtikli = uzimaArtikle.getText();
        for (String artikal: sviArtikli.split("\n")) {
            listaArtikala.add(new Artikal(artikal));
        }
        Artikal.izbaciDuplikate(listaArtikala);

        for(int i=0; i<listaArtikala.size(); i++){
            ispisArtikala.appendText(listaArtikala.get(i).toString() + "\n");
        }

        for(int i=0; i<listaArtikala.size(); i++){
            padajucaLista.getItems().add(listaArtikala.get(i).getSifra());
        }

    }

    public void dugmeArtikliRacun(ActionEvent actionEvent) {
        ispisAktuelnogRacuna.clear();
        for(int i=0; i<listaArtikala.size(); i++){
            if(listaArtikala.get(i).getSifra().equals(padajucaLista.getValue())){
                sadasnjiRacun.dodajStavku(listaArtikala.get(i),(Integer)spinnerKolicina.getValue());
            }
        }
        String string = new String();
        for(int i=0; i<sadasnjiRacun.getSviArtikli().size(); i++){
            string = string + String.format("%-12s %-4s %.2f\n",sadasnjiRacun.getSviArtikli().get(i).getSifra(),sadasnjiRacun.getKolicinaArtikala().get(i).toString(),sadasnjiRacun.getSviArtikli().get(i).getCijena());
        }
        string = string + String.format("UKUPNO %13.2f",sadasnjiRacun.ukupanIznos());
        ispisAktuelnogRacuna.setText(string);
    }
}
