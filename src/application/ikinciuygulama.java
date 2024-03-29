package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ikinciuygulama {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anc1;

    @FXML
    private Button btnhesapla;

    @FXML
    private Button btntemizle;

    @FXML
    private Label lblsonuc;

    @FXML
    private Label lblsoru;

    @FXML
    private TextField textx;

    @FXML
    private TextField texty;

    @FXML
    void btnhesapla(ActionEvent event) {
       double x=Double.parseDouble(textx.getText());
       double y=Double.parseDouble(texty.getText());
      
       double sonuc=Math.sin(x)+Math.cos(y);
       lblsonuc.setText("sin("+x+")+cos("+y+") =" + sonuc );
       
       
       lblsonuc.setText("" + sonuc );
       lblsonuc.setText(String.valueOf(sonuc));
       
    }

    @FXML
    void btntemizle(ActionEvent event) {
      lblsonuc.setText("...");
      textx.clear();
      texty.clear();
    }

    @FXML
    void btnx(ActionEvent event) {

    }

    @FXML
    void btny(ActionEvent event) {

    }

    @FXML
    void initialize() {
      
    }

}
