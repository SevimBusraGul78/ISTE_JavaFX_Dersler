package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class btnTextField {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnhesapla;

    @FXML
    private Label lbl1;

    @FXML
    private Label lblarac1;

    @FXML
    private Label lblarac2;

    @FXML
    private Label lblmesafe;

    @FXML
    private Label lblsüre;

    @FXML
    private TextField textarac1;

    @FXML
    private TextField textsonuc;

    @FXML
    private Button tmzlebutton;

    @FXML
    private TextField txtarac2;

    @FXML
    private TextField txtsüre;

    @FXML
    void btnhesapla_click(ActionEvent event) {
    	 double hiz1, hiz2, sure;
         hiz1 = Double.parseDouble(textarac1.getText());
         hiz2 = Double.parseDouble(txtarac2.getText());
         sure = Double.parseDouble(txtsüre.getText());
         double sonuc = (hiz1 - hiz2) * sure;

         if (sonuc < 0) {
             sonuc = Math.abs(sonuc);
         }

         textsonuc.setText(String.valueOf(sonuc));
    }

    @FXML
    void tmzlebutton_click(ActionEvent event) {
    	textsonuc.setText("");
    	textarac1.setText("");
    	txtarac2.clear();
    	textsonuc.setText("");
    }

    
}
