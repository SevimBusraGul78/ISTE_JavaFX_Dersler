package application;

import java.awt.Choice;
import java.awt.desktop.SystemSleepEvent;
import java.net.URL;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.security.auth.callback.TextInputCallback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class alertController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnalert;

    @FXML
    private Button btncombo;

    @FXML
    private Button btncıkış;

    @FXML
    private Button btnhata;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnsoru;

    @FXML
    private Button btnınput;

    @FXML
    private TextField txtkullanici;

    @FXML
    private PasswordField txtsifre;

    @FXML
    void btnalert(ActionEvent event) {
      Alert alert=new Alert(AlertType.INFORMATION);
      alert.setTitle("Bilgi Mesajıdır ....... ");
      alert.setHeaderText("Bu kodu yazan kız mükemmeldir");
      alert.setContentText("Bilgilendirme Bitmiştir....\n by Sevim Büşra ");
      		alert.showAndWait();
    }

    @FXML
    void btncombo(ActionEvent event) {
    	List<String> sec=new ArrayList<>();  //observable da oluşturabilirdin
    	
    	sec.add("Çekilecek");
    	sec.add("gibi");
    	sec.add("aşk ");
    	sec.add("değil");
    	
    	ChoiceDialog<String> dialog=new ChoiceDialog<String>("aşk",sec);  //2.seçenekden başlasın 
    	
    	Optional <String> sonuc=dialog.showAndWait();
    	if(sonuc.isPresent()) {
    		System.out.println("Secilen "+sonuc.get());
    	}
    	

    }

    @FXML
    void btncıkış(ActionEvent event) {
      System.exit(0); //çıkışa bastığı an durumu kapatır 
    }

    @FXML
    void btnhata(ActionEvent event) {
    	 Alert alert=new Alert(AlertType.ERROR);
         alert.setTitle("Bilgi Mesajıdır ....... ");
         alert.setHeaderText("Hatasız kul olmaz ");
         alert.setContentText("Bu bir hata mesajıdır....\n by Sevim Büşra ");
         alert.showAndWait();
    }

    @FXML
  
    void btnlogin(ActionEvent event) {
        LoginKontrol(txtkullanici.getText(), txtsifre.getText());
    }


    @FXML
    void btnsoru(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
          alert.setTitle("İSte oto");
          alert.setHeaderText("onay kutusu ");
          alert.setContentText("Silmek istediğinize emin misin");
          
                ButtonType btn1=new ButtonType("Evet");
          		ButtonType btn2=new ButtonType("Hayır");
          		ButtonType btn3=new ButtonType("İptal",ButtonData.CANCEL_CLOSE);
          		ButtonType btn4=new ButtonType("Tamam",ButtonData.OK_DONE);
          		
          		alert.getButtonTypes().setAll(btn1,btn2,btn3);
          		
          		Optional<ButtonType> sonuc=alert.showAndWait();
          		if(sonuc.get()==btn1) {
          			System.out.println("Evet butonuna basıldu ");
          		}
          		else if (sonuc.get()==btn2) {
          			System.out.println("hayır butonuna tıklandı");
					
				}
          		else if (sonuc.get()==btn3) {
          			System.out.println("iptal tuşuna basıldı");
					
				}
          		else  {
					System.out.println("iptal butonuna basıldı ");
				}

    }
           
    public void LoginKontrol(String kul, String sifre) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("İSte oto");
        alert.setHeaderText("hata kutusu ");

        if (kul.isEmpty() || sifre.isEmpty()) {
            alert.setContentText("Kullancı adı ve şifre istediğinizde emin misin?");
        }
        else {
            if (kul.contains("@iste.edu.tr") && kul.length() > 13)
              {
                if (sifre.contains("") || sifre.contains("") || sifre.contains("\\x75") || sifre.contains("\\x25")) //x75 u harfini gösterir 
                	/*Şifre en az bir karakter içermelidir (sifre.contains("") && sifre.contains("")).
                         Şifre içinde "u" (\x75 Unicode değeri) veya "%" (\x25 Unicode değeri) karakterlerinden en az biri varsa...........*/
                     {
                    alert.setContentText("SQL injection tespit edildi");
                     } 
                
                else {
                    alert.setContentText("Giriş başarılı");
                     }
            }
            
               else {
                       if (sifre.length() < 8) {
                       alert.setContentText("Şifre 8 karakterden az olamaz");
                }
                       else {
                    alert.setContentText("İste mail adresi girilmelidir");
                }
            }
        }

        alert.showAndWait();
    }
    @FXML
    void btnınput(ActionEvent event) {
         TextInputDialog dialog=new TextInputDialog("İste");
         dialog.setTitle("İste");
         dialog.setHeaderText("Otomasnyon Onay");
         dialog.setContentText("Telefonunuza gönderilen onay kodu giriniz");
         
         Optional<String> sonuc=dialog.showAndWait();
         
         if(sonuc.isPresent()) {
        	 System.out.println("Girilen metin " +sonuc.get());
         }
    }

    @FXML
    void initialize() {
       
    }

}
