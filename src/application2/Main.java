package application2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // StageİslemlerıForm2.fxml dosyasını yükle
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("TableView.fxml"));
            
            // Bir sahne oluştur ve root'u içine yerleştir, boyutları 500x500
            Scene scene = new Scene(root, 500, 500);
            
            // application.css dosyasını sahneye ekle
            scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());

            
            // Sahneyi primaryStage'e ayarla ve göster
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
