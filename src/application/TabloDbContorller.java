package application;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.isteMySQL.util.VeriTabanUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabloDbContorller {
	public TabloDbContorller() {
			baglanti=VeriTabanUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_refresh;

    @FXML
    private TableColumn<Kayıtlar_login, Integer> colId;

    @FXML
    private TableColumn<Kayıtlar_login, String> colKul;

    @FXML
    private TableColumn<Kayıtlar_login, Integer> colSifre;

    @FXML
    private TableColumn<Kayıtlar_login, String> colYetki;

    @FXML
    private Label lbl_id;
   


    @FXML
    private Label lbl_yetki;

    @FXML
    private TableView<Kayıtlar_login> tableViewKayıtlar;

    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;
    
    Connection baglanti = null;
    PreparedStatement sorguİfadesi = null;
    ResultSet getirilen = null;
    String sql;

    @FXML
    void btn_refresh(ActionEvent event) {
    	DegerleriGetir(tableViewKayıtlar);

    }
    public void DegerleriGetir(TableView tablo) {
    	 sql="select * from login";
    	ObservableList<Kayıtlar_login> kayıtlarListe=FXCollections.observableArrayList();
    	
    	try {
    		sorguİfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguİfadesi.executeQuery();
    		while (getirilen.next()) {
				kayıtlarListe.add(new Kayıtlar_login(getirilen.getInt("klD"), getirilen.getString("kul_ad"), getirilen.getString("sifre"), getirilen.getInt("yetki")));
				
			}
    		
    		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    		colKul.setCellValueFactory(new PropertyValueFactory<>("sutun_kulad"));
    		colSifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		colYetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));
		     tableViewKayıtlar.setItems(kayıtlarListe);
    	
    	}  
    	  
    	 
    	
    	catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    	
    	
    }
    

    @FXML
    void tableviewmouse_click(MouseEvent event) {
             Kayıtlar_login kayitlar=new Kayıtlar_login();
             kayitlar=(Kayıtlar_login) tableViewKayıtlar.getItems().get(tableViewKayıtlar.getSelectionModel().getSelectedIndex());
            txt_kul.setText(kayitlar.getSutun_kulad());  
            txt_sifre.setText(kayitlar.getSifre());
            lbl_id.setText(String.valueOf(kayitlar.getId()));
            if(kayitlar.getYetki()==1) {
            	lbl_yetki.setText("normal kullanıcı");
            }
            else if(kayitlar.getYetki()==1) {
            	lbl_yetki.setText("Yönetici");
            }
    }

 
	@FXML
    void initialize() {
        DegerleriGetir(tableViewKayıtlar);
    }

}
