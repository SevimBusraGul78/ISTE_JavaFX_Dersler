package dokuzuncuhafta;

import java.awt.Checkbox;
import java.awt.TextField;

import javafx.scene.control.Button;

public class Kayitlar_X {
     private int id ;
     private String kul_adi;
     private double ortalama;
     
     private Checkbox onay;
    
     public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKul_adi() {
		return kul_adi;
	}
	public void setKul_adi(String kul_adi) {
		this.kul_adi = kul_adi;
	}
	public double getOrtalama() {
		return ortalama;
	}
	public void setOrtalama(double ortalama) {
		this.ortalama = ortalama;
	}
	public Checkbox getOnay() {
		return onay;
	}
	public void setOnay(Checkbox onay) {
		this.onay = onay;
	}
	public TextField getMetinkutusu() {
		return metinkutusu;
	}
	public void setMetinkutusu(TextField metinkutusu) {
		this.metinkutusu = metinkutusu;
	}
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	private  TextField metinkutusu;
     private Button button;
     
      public  Kayitlar_X() {
		 
	} 
       Kayitlar_X(int id , String kul_adi,double ortalama ,String icerik ,Button button){
    	   this.id=id;
    	   this.kul_adi=kul_adi;
    	   this.ortalama=ortalama;
    	   
    	   
    	   this.onay=new Checkbox();
    	   // onay.setText("Metin ");
    	    
    	   this.metinkutusu=new TextField();
    	   this.metinkutusu.setText(icerik);
    	   
    	   this.button=button;
    	   this.button.setText("mesaj yolla ");
    	   this.button=button;
    	 
    	   
    	   
       }
     
     
     
}
