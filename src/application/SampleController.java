package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.isteMySQL.util.VeriTabanUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    Connection baglanti = null;
    PreparedStatement sorguİfadesi = null;
    ResultSet getirilen = null;

    @FXML
    void btn_ekle(ActionEvent event) {
        String sql = "INSERT INTO login (kul_ad, sifre, yetki) VALUES (?, ?, ?)";
        try {
            sorguİfadesi = baglanti.prepareStatement(sql);
            sorguİfadesi.setString(1, txt_kul.getText().trim());
            sorguİfadesi.setString(2, txt_şifre.getText().trim());
            sorguİfadesi.setString(3, "0");
            sorguİfadesi.executeUpdate();
            txtSistem.setText("Kullanıcı ekleme gerçekleşti...");
        } catch (SQLException e) {
            txtSistem.setText("Hata: " + e.getMessage());
        }
    }

    @FXML
    void btn_güncelle(ActionEvent event) {
        String sql = "UPDATE login SET sifre = ? WHERE kul_ad = ?";
        try {
            sorguİfadesi = baglanti.prepareStatement(sql);
            sorguİfadesi.setString(1, txt_şifre.getText().trim());
            sorguİfadesi.setString(2, txt_kul.getText().trim());
            sorguİfadesi.executeUpdate();
            txtSistem.setText("Şifre güncelleme gerçekleşti...");
        } catch (SQLException e) {
            txtSistem.setText("Hata: " + e.getMessage());
        }
    }

    @FXML
    void btn_sil(ActionEvent event) {
        String sql = "DELETE FROM login WHERE kul_ad = ? AND sifre = ?";
        try {
            sorguİfadesi = baglanti.prepareStatement(sql);
            sorguİfadesi.setString(1, txt_kul.getText().trim());
            sorguİfadesi.setString(2, txt_şifre.getText().trim());
            sorguİfadesi.executeUpdate();
            txtSistem.setText("Kullanıcı silme gerçekleşti...");
        } catch (SQLException e) {
            txtSistem.setText("Hata: " + e.getMessage());
        }
    }

    @FXML
    void btn_şifre(ActionEvent event) {
        String sql = "SELECT * FROM login WHERE kul_ad = ? AND sifre = ?";
        try {
            sorguİfadesi = baglanti.prepareStatement(sql);
            sorguİfadesi.setString(1, txt_kul.getText().trim());
            sorguİfadesi.setString(2, txt_şifre.getText().trim());
            getirilen = sorguİfadesi.executeQuery();
            if (!getirilen.next()) {
                txtSistem.setText("Kullanıcı adı veya şifre hatalı");
            } else {
                String kullaniciAdi = getirilen.getString("kul_ad");
                String sifre = getirilen.getString("sifre");
                String yetki = getirilen.getString("yetki");
                txtSistem.setText("Kullanıcı adı: " + kullaniciAdi + ", Şifre: " + sifre + ", Yetki: " + yetki);
            }
        } catch (SQLException e) {
            txtSistem.setText("Hata: " + e.getMessage());
        }
    }

    @FXML
    void initialize() {
        baglanti = VeriTabanUtil.Baglan();
    }
}
