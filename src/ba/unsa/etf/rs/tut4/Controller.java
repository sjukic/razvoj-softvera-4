package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public TextArea uzimaArtikle;

    public void dodajArtikle(ActionEvent actionEvent) {
        String sviArtikli = uzimaArtikle.getText();
        ArrayList<Artikal> listaArtikala = new ArrayList<>();
        for (String artikal: sviArtikli.split("\n")) {
            listaArtikala.add(new Artikal(artikal));
        }
        Artikal.izbaciDuplikate(listaArtikala);
        System.out.println(listaArtikala);
        System.out.println(listaArtikala.size());
    }
}
