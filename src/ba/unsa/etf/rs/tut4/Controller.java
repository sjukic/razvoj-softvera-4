package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {
    public TextArea uzimaArtikle;
    public TextArea ispisArtikala;

    public void dodajArtikle(ActionEvent actionEvent) {
        String sviArtikli = uzimaArtikle.getText();
        ArrayList<Artikal> listaArtikala = new ArrayList<>();
        for (String artikal: sviArtikli.split("\n")) {
            listaArtikala.add(new Artikal(artikal));
        }
        Artikal.izbaciDuplikate(listaArtikala);

        for(int i=0; i<listaArtikala.size(); i++){
            ispisArtikala.appendText(listaArtikala.get(i).toString() + "\n");
        }

    }
}
