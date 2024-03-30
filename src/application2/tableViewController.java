package application2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Size;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class tableViewController {

    @FXML
    private TableColumn<Kayitlar, String> Columsifre;

    @FXML
    private Button bengüncellle;

    @FXML
    private Button btnekle;

    @FXML
    private Button btngöster;

    @FXML
    private Button btnsil;

    @FXML
    private TableColumn<Kayitlar, String> columnKul;

    @FXML
    private TableColumn<Kayitlar, Integer> columnİD;

    @FXML
    private TableView<Kayitlar> kayıtlarTable;

    @FXML
    private Label lbldeğer;

    @FXML
    private TextField txtkul;

    @FXML
    private TextField txtsifre;

    @FXML
    void btnekle(ActionEvent event) {
        veriler=FXCollections.observableArrayList();
        veriler.add(new Kayitlar(3,txtkul.getText(),txtsifre.getText()));
    	kayıtlarTable.getItems().addAll(veriler);
    	
    }

    @FXML
    void btngöster(ActionEvent event) {
          Kayitlar kayitlar=new Kayitlar();
          if(kayıtlarTable.getSelectionModel().getSelectedIndex()!=-1) {
        	  kayitlar=(Kayitlar) kayıtlarTable.getItems().get(0);//hepsinde sıfır verir 
        	  lbldeğer.setText("Değer" +kayitlar.getId()+"Kullanıcı Adi "+kayitlar.getKul_ad() + "Sifre =" +kayitlar.getSifre() );
          }else {
			lbldeğer.setText("Herhangi bir kayıt seçilemedi .......");
		}
    	
    	
    	
    }
   ObservableList<Kayitlar> veriler;
    
    
    @FXML
    void btngüncelle(ActionEvent event) {
          //Seçili kaydı aldırmak için 
    	Kayitlar kayit=new Kayitlar();
    	  if(kayıtlarTable.getSelectionModel().getSelectedIndex()!=-1) {
        	  kayit=(Kayitlar) kayıtlarTable.getItems().get(0);//hepsinde sıfır verir 
        	 int idm=kayit.getId();
        	// txtkul.setText(kayit.getKul_ad());
        	 //txtsifre.setText(kayit.getSifre());
        	 //Yeni kayıtlar oluşturarara indislere gçre atama 
        	 Kayitlar kkKayitlar=new Kayitlar(idm,txtkul.getText(),txtsifre.getText());
        	 
        	 int sira=kayıtlarTable.getSelectionModel().getSelectedIndex();
        	 kayıtlarTable.getItems().set(sira, kkKayitlar);
        	 
        	 
        	 
        	  
        	  // lbldeğer.setText("Değer" +kayitlar.getId()+"Kullanıcı Adi "+kayitlar.getKul_ad() + "Sifre =" +kayitlar.getSifre() );
          }else {
			//lbldeğer.setText("Herhangi bir kayıt seçilemedi .......");
		}
    	
    	
    }

    @FXML
    void btnsil(ActionEvent event) {
    	
    	ObservableList<Kayitlar> secilenKayit,tumKayıtlar;
    	tumKayıtlar=kayıtlarTable.getItems();
    	secilenKayit=kayıtlarTable.getSelectionModel().getSelectedItems();
    	
    	
    	secilenKayit.forEach(tumKayıtlar::remove); ///Önemli 
    	

    }
    @FXML
    void initialize() {
    	btnekle.setTooltip(new Tooltip("Kayıt Eklemeyi sağlar .......")); //ekle butonuna geldiği zaman kayıt etmeyi sağlar 
       //ToolTip ekleme
    	
    	Tooltip tip = new Tooltip();
    	tip.setStyle("-fx-background-color:yellow;");
    	tip.setText("Silme işlemi yapar" );
    	 Image img=new Image(getClass().getResourceAsStream("resim.jpg"));
         tip.setGraphic(new ImageView(img));  	
         btnsil.setTooltip(tip);
         
         //TableView veri gömme
         
         veriler=FXCollections.observableArrayList();
         veriler.add(new Kayitlar(1,"admin","145678"));
         veriler.add(new Kayitlar(2,"root","784521"));
         veriler.add(new Kayitlar(3,"user","678"));
         
         //ilk tableColumn iismi 
         // TableView sütunları ile Kayitlar class'ı arasında bağlantı kurma
         columnİD.setCellValueFactory(new PropertyValueFactory<>("id"));
         columnKul.setCellValueFactory(new PropertyValueFactory<>("kul_ad"));
         Columsifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));         
         
         kayıtlarTable.setItems(veriler);
         
       // columnKul.setVisible(false);
    }
    
    
    public static class Kayitlar {
      
    	private int id;
    	private String kul_ad;
    	private  String sifre;
    	
    	    Kayitlar() {
    	    	
    	    	this.id=0;
    		
		}
    	    
    	    public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getKul_ad() {
				return kul_ad;
			}

			public void setKul_ad(String kul_ad) {
				this.kul_ad = kul_ad;
			}

			public String getSifre() {
				return sifre;
			}

			public void setSifre(String sifre) {
				this.sifre = sifre;
			}

			Kayitlar(int id ,String kul_Ad,String sifre){
    	    	this.id=id;
    	    	this.kul_ad=kul_Ad;
    	    	this.sifre=sifre;
    	    	
    	    	
    	    }
    	
		
	}
    
}
