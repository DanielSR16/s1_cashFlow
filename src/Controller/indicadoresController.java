package Controller;

import DAO.IndicadoresDineroDAO;
import Entities.IndicadoresDinero;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class indicadoresController implements Initializable {
IndicadoresDineroDAO indicadoresDAO = new IndicadoresDineroDAO();
    @FXML
    private TextField semanaCuentaCobrar;

    @FXML
    private TextField semanaCuentaPagar;

    @FXML
    private TextField semanaBanco;

    @FXML
    private TextField montoCuentaCobrar;

    @FXML
    private TextField razonCuentaCobrar;

    @FXML
    private TextField montoBanco;

    @FXML
    private TextField razonBanco;

    @FXML
    private TextField montoCuentaPagar;

    @FXML
    private TextField razonCuentaPagar;

    @FXML
    private Text errorCobrar;

    @FXML
    private Text errorPagar;

    @FXML
    private Text errorBanco;

    @FXML
    private Button guardarCuentaCobrar;

    @FXML
    private Button guardarCuentaPagar;

    @FXML
    private Button guardarBanco;
    //1 cuentas por cobrar
    //2 cuentas por pagar
    //3 banco
    @FXML
    private ComboBox<String> meses;

    @FXML
    void guardarCuentaCobrarOnMuseClicked(MouseEvent event) {

        if(meses.getSelectionModel().isEmpty()){
            System.out.println("TA vacio chavo");
        }
        else {
            if(semanaCuentaCobrar.getLength() > 0 && montoCuentaCobrar.getLength() > 0 && razonCuentaCobrar.getLength() >0){
                IndicadoresDinero indicadores = new IndicadoresDinero(Integer.parseInt(semanaCuentaCobrar.getText()),Float.parseFloat(montoCuentaCobrar.getText()),razonCuentaCobrar.getText(),1,meses.getSelectionModel().getSelectedIndex()+1);
                indicadoresDAO.insert(indicadores);
                semanaCuentaCobrar.clear();
                montoCuentaCobrar.clear();
                razonCuentaCobrar.clear();
                errorCobrar.setText("");
            }else{
                errorCobrar.setText("Faltan campos por llenar");
            }
        }
    }

    @FXML
    void guardarCuentaPagarOnMuseClicked(MouseEvent event) {

        if(meses.getSelectionModel().isEmpty()){
            System.out.println("TA vacio chavo");
        }
        else {
            if(semanaCuentaPagar.getLength() > 0 && montoCuentaPagar.getLength() > 0 && razonCuentaPagar.getLength() >0){
                IndicadoresDinero indicadores = new IndicadoresDinero(Integer.parseInt(semanaCuentaPagar.getText()),Float.parseFloat(montoCuentaPagar.getText()),razonCuentaPagar.getText(),2,meses.getSelectionModel().getSelectedIndex()+1);
                indicadoresDAO.insert(indicadores);
                semanaCuentaPagar.clear();
                montoCuentaPagar.clear();
                razonCuentaPagar.clear();
                errorPagar.setText("");
            }else{
                errorPagar.setText("Faltan campos por llenar");
            }
        }
    }

    @FXML
    void guardarBancoOnMuseClicked(MouseEvent event) {

        if(meses.getSelectionModel().isEmpty()){
            System.out.println("TA vacio chavo");
        }
        else {

            if(semanaBanco.getLength() > 0 && montoBanco.getLength() > 0 && razonBanco.getLength() >0){
                IndicadoresDinero indicadores = new IndicadoresDinero(Integer.parseInt(semanaBanco.getText()),Float.parseFloat(montoBanco.getText()),razonBanco.getText(),3,meses.getSelectionModel().getSelectedIndex()+1);
                indicadoresDAO.insert(indicadores);
                semanaBanco.clear();
                montoBanco.clear();
                razonBanco.clear();
                errorBanco.setText("");
            }else{
                errorBanco.setText("Faltan campos por llenar");
            }

        }


    }

    @FXML
    void houseClicked(MouseEvent event) {
        Main.secondStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> flujo =  FXCollections.observableArrayList();
        flujo.addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiempbre","Octubre","Noviembre","Diciembre");

        meses.setItems(flujo);
    }
}
