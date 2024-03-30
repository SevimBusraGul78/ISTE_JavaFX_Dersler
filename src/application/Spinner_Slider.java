package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class Spinner_Slider {

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Button btn;

    @FXML
    private Slider sliderhoriz;

    @FXML
    private Slider sliderverti;

    @FXML
    private Spinner<Integer> spin1;

    @FXML
    private Spinner<String> spin2;

    @FXML
    private Spinner<Integer> spin3;

    @FXML
    private Spinner<Integer> spin4;

    @FXML
    private Spinner<Integer> spin5;

    @FXML
    private Spinner<Integer> spin6;

    @FXML
    private Spinner<Double> spin7;

    @FXML
    private Spinner<String> spin8;

    @FXML
    void button(ActionEvent event) {
    
    }

    @FXML
    void initialize() {
        int secilen = 3;
        SpinnerValueFactory<Integer> deger1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, secilen);
        spin1.setValueFactory(deger1);

        ObservableList<String> aylar = FXCollections.observableArrayList("ocak", "subat", "mart", "nisan", "mayıs"); 
        SpinnerValueFactory<String> deger2 = new SpinnerValueFactory.ListSpinnerValueFactory<String>(aylar);
        deger2.setValue("DEnemeeeeee");
        spin2.setValueFactory(deger2);

        SpinnerValueFactory<Integer> deger3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, secilen);
        spin3.setValueFactory(deger3);
        spin3.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);

        spin4.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);

        spin5.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL);

        SpinnerValueFactory<Double> deger4 = new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 100, secilen);
        spin7.setValueFactory(deger4);
        spin7.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);

        spin8.setValueFactory(deger2);

        spin8.valueProperty().addListener(
                (obs, oldValue, newValue) -> System.out.println("Spinner eski değer : " + oldValue + "\n yeni değer " + newValue)
        );

        sliderhoriz.setMax(75);
        sliderhoriz.setMin(15);
        sliderhoriz.setShowTickLabels(true);
        sliderhoriz.setShowTickMarks(true);
        sliderhoriz.setMajorTickUnit(5);
        sliderhoriz.setBlockIncrement(10);

        sliderhoriz.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // Yapılacak işlemler buraya yazılır
                System.out.println("Slider yatay değeri : " + newValue);
                lbl1.setText("Yeni Değer : " + String.valueOf(newValue));
                lbl2.setText("Eski miktarı: " + String.valueOf(oldValue));
            }
        });
        
        sliderverti.valueProperty().addListener(
        		(obs,OldValue2,newValue) -> {
 
        			 System.out.println("Slider dik değeri : " + newValue);
                     lbl1.setText("Yeni Değer : " + String.valueOf(newValue));
                     lbl2.setText("Eski miktarı: " + String.valueOf(OldValue2));
                 
        		}
        		);
        
    }

}
