package dokuzuncuhafta;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class tableViewController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnekle;

    @FXML
    private Button btngöster;

    @FXML
    private Button btnsecil;

    @FXML
    private Button btnsil;

    @FXML
    private Button btnyorum;

    @FXML
    private TableColumn<Kayitlar_X, Integer> id;

    @FXML
    private TableColumn<Kayitlar_X, Integer> islemler;

    @FXML
    private TableView<Kayitlar_X> kayıtlar_table;

    @FXML
    private TableColumn<Kayitlar_X, String> kuladi;

    @FXML
    private TableColumn<Kayitlar_X, Double> ortalmaa;

    @FXML
    private TableColumn<Kayitlar_X, Boolean> secili;

    @FXML
    private TableColumn<Kayitlar_X, Integer> sifre;

    @FXML
    private Button tbngüncelle;

    @FXML
    private TextField txtkul;

    @FXML
    private TextField txtsifre;

    @FXML
    private TableColumn<Kayitlar_X, String> yorum;

    
    ObservableList<Kayitlar_X> veriler;
    Button[] buttonlar=new Button[10];
    int buttonNumarasi=0;
     
    
    
    @FXML
    void btnekle(ActionEvent event) {
       veriler=FXCollections.observableArrayList();
       veriler.add(new Kayitlar_X(3,txtkul.getText(),Double.parseDouble(txtsifre.getText()),"Varsayılan",buttonlar[buttonNumarasi]));
       kayıtlar_table.getItems().addAll(veriler);
      
    
    }

    @FXML
    void btngünc(ActionEvent event) {
    	  Kayitlar_X kayitlar=new Kayitlar_X();
          if(kayıtlar_table.getSelectionModel().getSelectedIndex()!=-1){
        	  kayitlar=(Kayitlar_X) kayıtlar_table.getItems().get(kayıtlar_table.getSelectionModel().getSelectedIndex());
             //seçili olan indexi buraya eklemiş olduk 
        	int idm=kayitlar.getId();
        	//yeni kayitlar 
        	
        	Kayitlar_X kk=new Kayitlar_X(idm,txtkul.getText(),Double.parseDouble(txtsifre.getText()),"Güncellenmiş mesaj",buttonlar[idm]);
        	int sira=kayıtlar_table.getSelectionModel().getSelectedIndex();
        	kayıtlar_table.getItems().set(sira, kk);
          }
          
          else {
			System.out.println("Herhangi bbir kayıt seçili değil .... ");
		}
    }

    @FXML
    void btnsecilen(ActionEvent event) {
      
    }

    @FXML
    void btnsil(ActionEvent event) {
    	ObservableList<Kayitlar_X> seciKayitlar_Xs,tKayitlar_Xs;
    	tKayitlar_Xs=kayıtlar_table.getItems();
    	seciKayitlar_Xs=kayıtlar_table.getSelectionModel().getSelectedItems();
    	
    	seciKayitlar_Xs.forEach(tKayitlar_Xs::remove);
    	
    	
 
    }

    @FXML
    void btnyorum(ActionEvent event) {

    }

    @FXML
    void kayıtlar_table_clicked(MouseEvent event) {
    	
    	Kayitlar_X Kayitlar=new Kayitlar_X();
        Kayitlar=(Kayitlar_X) kayıtlar_table.getItems().get(kayıtlar_table.getSelectionModel().getSelectedIndex());
        
        txtkul.setText(Kayitlar.getKul_adi());
        txtsifre.setText(String.valueOf(Kayitlar.getOrtalama()));
        

    }
    @FXML
    void btngöster(ActionEvent event) {
          Kayitlar_X kayitlar=new Kayitlar_X();
          if(kayıtlar_table.getSelectionModel().getSelectedIndex()!=-1){
        	  kayitlar=(Kayitlar_X) kayıtlar_table.getItems().get(kayıtlar_table.getSelectionModel().getSelectedIndex());
             //seçili olan indexi buraya eklemiş olduk 
        	  System.out.println("Seçilen Kullanici "+kayitlar.getKul_adi()+" \n" + "Ortalama= "+kayitlar.getOrtalama()+"\n"+"ID: "+kayitlar.getId() );
          }
          
          else {
			System.out.println("Herhangi bbir kayıt seçili değil .... ");
		}
          
    }

    @FXML
    void initialize() {
      
  for (int i = 0; i < buttonlar.length; i++) {
	  buttonlar[i]=new Button();
	  buttonlar[i].setId("button"+i);
	  buttonlar[i].setOnAction(this::ButtonOlayi);//tıklama olayı atama
	 

}
 
  //tableView veri girme 
  veriler=FXCollections.observableArrayList();
  veriler.add(new Kayitlar_X(1,"admin",0.5,"Mesaj 1",buttonlar[buttonNumarasi]));
  buttonNumarasi++;
  veriler.add(new Kayitlar_X(2,"user",0.10,"Mesaj 2",buttonlar[buttonNumarasi]));
  buttonNumarasi++;
  veriler.add(new Kayitlar_X(3,"users2",0.25,"Mesaj 3",buttonlar[buttonNumarasi]));
  buttonNumarasi++;
	
  //1.id tabelecolumn 
  //2.id kayirlar_x içerisindeki yapı 
  id.setCellValueFactory(new PropertyValueFactory<>("id"));
  kuladi.setCellValueFactory(new PropertyValueFactory<>("kul_adi"));
  ortalmaa.setCellValueFactory(new PropertyValueFactory<>("ortalama"));
  secili.setCellValueFactory(new PropertyValueFactory<>("onay"));
  islemler.setCellValueFactory(new PropertyValueFactory<>("button"));
  yorum.setCellValueFactory(new PropertyValueFactory<>("metinkutusu"));
  
  kayıtlar_table.setItems(veriler);
  
    }
    @FXML
    void ButtonOlayi (ActionEvent event) {
    	for (int i = 0; i < buttonlar.length; i++) {
    		//tetiklenen butonu bulma 
    		
    		if(event.getSource()==buttonlar[i]) {
    			System.out.println(i + ".button tıklandı ");
    		}
			
		}
    }
    

}
