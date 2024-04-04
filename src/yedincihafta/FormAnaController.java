package yedincihafta;

import java.awt.image.AbstractMultiResolutionImage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormAnaController {

    @FXML
    private AnchorPane anchor_sağ;

    @FXML
    private AnchorPane anchhorTüm;

    @FXML
    private AnchorPane anchor_sol;

    @FXML
    private Button btn_dış_click1;

    @FXML
    private Button btn_ic_click;

    @FXML
    private Button btnmenü;

    // This method is triggered when btn_dış_click1 is clicked
    @FXML
    void btndış(ActionEvent event) {
        try {
            // Load the FormUygulama2.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormUygulama2.fxml"));

            // Load the pane from the FXMLLoader
            AnchorPane pane1 = (AnchorPane) loader.load();

            // Create a new stage
            Stage stage1 = new Stage();

            // Create a new scene with the loaded pane
            Scene scene = new Scene(pane1);

            // Add application1.css to the scene
            scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());

            // Set the scene to the stage and show the stage
            stage1.setScene(scene);
            stage1.show();

            // Pass data to FormUygulama2Controller
            FormUygulama2Controller nesne = loader.getController();
            nesne.VeriAl("Merhbaaaa");

            // Optional: Set an icon for the new stage
            stage1.getIcons().add(new Image(getClass().getResourceAsStream("resim.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btniç(ActionEvent event) {
        // Code for btniç action, if needed
    	try {
			AnchorPane panel=(AnchorPane) FXMLLoader.load(getClass().getResource("FormUygulama2.Fxml"));
			anchor_sağ.getChildren().setAll(panel); 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void btnmenü(ActionEvent event) {
    	try {
			AnchorPane panel=(AnchorPane) FXMLLoader.load(getClass().getResource("FormUygulama1.Fxml"));
			anchor_sol.getChildren().setAll(panel); 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void trnsptDışForm(ActionEvent event) {
        // Code for trnsptDışForm action, if needed
    	try {
    		Stage stage1=new Stage();
        	AnchorPane panel=(AnchorPane) FXMLLoader.load(getClass().getResource("FormUygulama1.Fxml"));
		    Scene scene1=new Scene(panel);
		    //Formun trasparanlığını ayarlama 
		    
		    stage1.setScene(scene1);
		    stage1.setOpacity(0.8);
		    stage1.setTitle("merhaba iste");
            stage1.centerOnScreen();
            
            
            stage1.initStyle(StageStyle.DECORATED); //varsayılan
            stage1.initStyle(StageStyle.UNDECORATED);//varsayılan 
            stage1.initStyle(StageStyle.TRANSPARENT);//menu tuşları olmadan 
            stage1.initStyle(StageStyle.UNIFIED);//menu tuşları yok 
            stage1.initStyle(StageStyle.UTILITY);//sadece kapama
            
           // stage1.getIcons().add(new Image("resim.jpg"));
            stage1.getIcons().add(new Image(getClass().getResourceAsStream("resim.jpg")));
            stage1.show();
            
            
            stage1.setFullScreen(true);
            
    	 
    	} catch (Exception e) {
			e.printStackTrace();
		}
    
    	
    	
    }

    @FXML
    void initialize() {
        // Initialization code, if needed
    }
}
