package ba.unsa.etf.rs.tut4;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;
import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        stage.setTitle("Kasa");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();
        stage.toFront();
    }
    @Test
    void provjeraPostaojanjaTextAreaKodUnosenjaArtikala(FxRobot robot){
        boolean txtAreaUnosenjaTeksta = robot.lookup("#uzimaArtikle").tryQuery().isPresent();
        assertNotNull(txtAreaUnosenjaTeksta);
    }
    @Test
    void provjeraPostaojanjaTextAreaKodIspisaArtikala(FxRobot robot){
        boolean txtAreaIspisTeksta = robot.lookup("#ispisArtikala").tryQuery().isPresent();
        assertNotNull(txtAreaIspisTeksta);
    }
    @Test
    void provjeraPostaojanjaTextAreaKodIspisaAktuelnogRacuna(FxRobot robot){
        boolean txtAreaIspisAktuelnogRacuna = robot.lookup("#ispisAktuelnogRacuna").tryQuery().isPresent();
        assertNotNull(txtAreaIspisAktuelnogRacuna);
    }
    @Test
    void provjeraPostaojanjaSpinnera(FxRobot robot){
        Spinner spiner = robot.lookup("#spinnerKolicina").queryAs(Spinner.class);
        assertNotNull(spiner);
    }
    @Test
    void provjeraPostaojanjaChoiseBoxa(FxRobot robot){
        ChoiceBox choisebox = robot.lookup("#padajucaLista").queryAs(ChoiceBox.class);
        assertNotNull(choisebox);
    }
    @Test
    void provjeraUnosaArtikala(FxRobot robot){
        TextArea txtAreaIspisTeksta = robot.lookup("#ispisArtikala").queryAs(TextArea.class);
        robot.clickOn("#uzimaArtikle");
        robot.write("HB01,Hljeb,0.9\nHB02,Mlijeko,1.5\nHB03,Sir,6.5\n");
        robot.clickOn("#buttonZaDodavanjeArtikala");
        assertEquals("HB01,Hljeb,0.9\nHB02,Mlijeko,1.5\nHB03,Sir,6.5\n",txtAreaIspisTeksta.getText());
    }
    @Test
    void provjeraUnosaArtikalaSaIzbacivanjemDuplikata(FxRobot robot){
        TextArea txtAreaIspisTeksta = robot.lookup("#ispisArtikala").queryAs(TextArea.class);
        robot.clickOn("#uzimaArtikle");
        robot.write("HB01,Hljeb,0.9\nHB02,Mlijeko,1.5\nHB03,Sir,6.5\nHB01,Hljeb,0.9\nHB02,Mlijeko,1.5\nHB03,Sir,6.5\nHB03,Sir,6.5\nHB03,Sir,6.5\n");
        robot.clickOn("#buttonZaDodavanjeArtikala");
        assertEquals("HB01,Hljeb,0.9\nHB02,Mlijeko,1.5\nHB03,Sir,6.5\n",txtAreaIspisTeksta.getText());
    }
    @Test
    void provjeraComboBoxaPosjedujeLiParametar(FxRobot robot){
        TextArea txtAreaIspisTeksta = robot.lookup("#ispisArtikala").queryAs(TextArea.class);
        robot.clickOn("#uzimaArtikle");
        robot.write("HB01,Hljeb,0.9\nHB02,Mlijeko,1.5\nHB03,Sir,6.5\n");
        robot.clickOn("#buttonZaDodavanjeArtikala");
        robot.clickOn(("#karticaRacun"));
        ChoiceBox choiseBox = robot.lookup("#padajucaLista").queryAs(ChoiceBox.class);
        Platform.runLater(()->choiseBox.show());
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("HB02");
        assertEquals("HB02", choiseBox.getValue().toString());
    }
    @Test
    void provjeraIspisaRacuna(FxRobot robot){
        TextArea txtAreaIspisTeksta = robot.lookup("#ispisArtikala").queryAs(TextArea.class);
        robot.clickOn("#uzimaArtikle");
        robot.write("HB01,Hljeb,0.9\nHB02,Mlijeko,1.5\nHB03,Sir,6.5\n");
        robot.clickOn("#buttonZaDodavanjeArtikala");
        robot.clickOn(("#karticaRacun"));
        ChoiceBox choiseBox = robot.lookup("#padajucaLista").queryAs(ChoiceBox.class);
        Platform.runLater(()->choiseBox.show());
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("HB02");
        robot.clickOn("#spinnerKolicina");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.CONTROL).release(KeyCode.A);
        robot.write("5");
        robot.clickOn("#buttonZaIspisRacuna");
        TextArea txtAreaIspisRacuna = robot.lookup("#ispisAktuelnogRacuna").queryAs(TextArea.class);
        assertEquals("HB02         5.0  1,50\nUKUPNO          7,50", txtAreaIspisRacuna.getText());
    }
}