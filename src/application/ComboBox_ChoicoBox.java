package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ComboBox_ChoicoBox {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngetir;

    @FXML
    private AnchorPane button1;

    @FXML
    private ChoiceBox<String> choicpBox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label lblchoice;

    @FXML
    private Label lblcombo;

    @FXML
    private Label lblhesapla;

    @FXML
    private Label lbllist;

    @FXML
    private ListView<String> listVieW;

    @FXML
    private TextField txtdeger;

    @FXML
    void ComboBox(ActionEvent event) {
    	//comboBox.getItems().clear();
    	//comboBox.getItems().remove(2);
    	//comboBox.getItems().remove("deneme1");
    	
    	//liste,arraylist,observablelist,dizi ile silinebilir
    	lblhesapla.setText(comboBox.getSelectionModel().getSelectedItem()); //seçtiğimiz stringi labele yazar bunu da anla :(
    	
    	lblhesapla.setText(String.valueOf(comboBox.getSelectionModel().getSelectedIndex()));
    	
        System.out.println(comboBox.getItems().get(2));
        System.out.println(comboBox.getItems().indexOf("deneme1"));
        System.out.println(comboBox.getItems().lastIndexOf("deneme1"));
    }

    @FXML
    void button(ActionEvent event) {
    	
         
    	
    }

    @FXML
    void buttonGetir(ActionEvent event) {

    	comboBox.getItems().add(txtdeger.getText());  // yazdığın txtdeger comboBox içine gir
       
    	
    	
    	 ObservableList<String> icerik;  //teker teker değil liste şeklinde eklmek istiyorum..
    	
    	 ListView<String> listVieW = new ListView<>();
         icerik =listVieW.getSelectionModel().getSelectedItems();
         for(String i: icerik) {
        	 System.out.println(i);
         }
         
      ObservableList<Integer> indisler;  //teker teker değil liste şeklinde eklmek istiyorum..
         indisler = listVieW.getSelectionModel().getSelectedIndices();
        
         for(int i: indisler) {
        	 System.out.println(i);
         }
         //

    }
    @FXML
    void initialize() {
    	//comboBox.getItems().add(1,"iste");
    	comboBox.setPromptText("Deger Seciniz");
    	String[] dizi= { "deneme1","deneme2","deneme3"};
    	
    	
    	
    	comboBox.getItems().addAll(dizi);
    	 
    	//dizi,liste,arrayList,observable,olabilir
    	
    	ObservableList<String> dizi2=FXCollections.observableArrayList("deger1","deger2","deger3");  //!!! bu kısmı tekrar ett !!///  anlamadın 
    	 comboBox.getItems().addAll(dizi2);
    	 choicpBox.getItems().addAll(dizi2);
    	 choicpBox.getItems().addAll(dizi2);
    	 choicpBox.getItems().addAll(dizi2);
    	 
    	 
    	 comboBox.setVisibleRowCount(5); // 5 tane eleman gözüksün  && choiceboxda bu özellik yok 
    	
    	 listVieW.getItems().addAll(dizi2);
    	 
    	 listVieW.getSelectionModel().getSelectedItem();
    	 //seçili olan değeri alabiliriz
    	 
    	 listVieW.getSelectionModel().getSelectedIndex();
    	 //Seçili olan indisi getirebiliriz
    	 
    	 listVieW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //ctrl basarak coklu seçim 
    	 
    	 listVieW.getSelectionModel().getSelectedIndices();//Seçili olan indisleri bize getirir
    	 listVieW.getSelectionModel().getSelectedIndex();
    	 //ikisi liste olarak getirir
    	 
    	 
    	 listVieW.getSelectionModel().select(2); //2.indexi bize getir
    	 
    	 listVieW.getSelectionModel().selectAll(); //tüm indisi seç
    	 listVieW.getSelectionModel().selectFirst();
    	 listVieW.getSelectionModel().selectNext();//
    	 listVieW.getSelectionModel().selectPrevious();
    	 listVieW.getSelectionModel().selectRange(1,2);
    	 
    	 listVieW.getSelectionModel().clearSelection();//seçileni siler

    	 
}
}