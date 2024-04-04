package yedincihafta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FormUygulama2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelformveri;
    
    public void VeriAl(String icerik) {
    	labelformveri.setText("Transfer edilen değer:" + icerik);
    }

    @FXML
    void initialize() {
        assert labelformveri != null : "fx:id=\"labelformveri\" was not injected: check your FXML file 'FormUygulama2.fxml'.";

    }

}




