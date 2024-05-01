package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.isteMySQL.util.VeriTabanUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;

public class SampleController {
	public SampleController() {
		baglanti=VeriTabanUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEkle;

    @FXML
    private Button btnGüncelle;

    @FXML
    private Button btnSil;

    @FXML
    private Button btnŞifre;
    @FXML
    private Label txtSistem;
    @FXML
    private TextField txt_kul;
    @FXML
    private TextField txt_şifre;
    Connection baglanti=null;
    PreparedStatement sorguİfadesi=null;
    ResultSet getirilen=null;
    String sql;
    @FXML
    void btn_ekle(ActionEvent event) {
    }
    @FXML
    void btn_güncelle(ActionEvent event) {
    }

    @FXML
    void btn_sil(ActionEvent event) {

    }

    @FXML
    void btn_şifre(ActionEvent event) {
           //login olacak düzenlenmeiş haliyle 
    	sql="select * from login where kul_ad=? and sifre=?";
    	try {
			sorguİfadesi=baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1,txt_kul.getText().trim());
			sorguİfadesi.setString(2,txt_şifre.getText().trim());
			
			ResultSet getirilen=sorguİfadesi.executeQuery(); //select özellikle budur
			
			if (!getirilen.next()) {
				txtSistem.setText("kullanııcı adı veya şifre hatalı");
				
			}
			else {
				getirilen.getString(1);//Tabloda 1.sutundaki deger 
				//System.out.println("kID:"+getirilen.getString("kID"));
				System.out.println("kullanıcı"+getirilen.getString("kul_ad"));
				System.out.println("sifre"+getirilen.getString("sifre"));
				System.out.println("Yetki"+getirilen.getString("yetki"));
				//getirilen.getInt("kID");
			};
		} catch (Exception e) {
			txtSistem.setText(e.getMessage().toString());
		}
    }

    @FXML
    void initialize() {
      
    }

}
