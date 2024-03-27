package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anc1;

    @FXML
    private Button btnTemizle;

    @FXML
    private Button btnhesapla;

    @FXML
    private Label lblsoru;

    @FXML
    private TextField textsonuc;

    @FXML
    private TextField txtdeger;

    @FXML
    void btnhesapla(ActionEvent event) {
    	 double x;
    	 x=Double.parseDouble(txtdeger.getText()); //x i tanmımla 
    	 
    	 double sonuc=(x*x)+4*x+4;
    	 
    	 textsonuc.setText(String.valueOf(sonuc) +" ");
    	 

    }

    @FXML
    void btntemizle(ActionEvent event) {
    	textsonuc.setText("");  //silmeyi gösterir 
    	txtdeger.setText("");

    }

    @FXML
    void initialize() {
       
    }

}
