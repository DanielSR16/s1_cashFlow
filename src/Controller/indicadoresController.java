package Controller;

import DAO.IndicadoresDineroDAO;
import Entities.IndicadoresDinero;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class indicadoresController {
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
    void guardarCuentaCobrarOnMuseClicked(MouseEvent event) {
        if(semanaCuentaCobrar.getLength() > 0 && montoCuentaCobrar.getLength() > 0 && razonCuentaCobrar.getLength() >0){
            IndicadoresDinero indicadores = new IndicadoresDinero(Integer.parseInt(semanaCuentaCobrar.getText()),Float.parseFloat(montoCuentaCobrar.getText()),razonCuentaCobrar.getText(),1);
            indicadoresDAO.insert(indicadores);
            semanaCuentaCobrar.clear();
            montoCuentaCobrar.clear();
            razonCuentaCobrar.clear();
            errorCobrar.setText("");
        }else{
            errorCobrar.setText("Faltan campos por llenar");
        }


    }

    @FXML
    void guardarCuentaPagarOnMuseClicked(MouseEvent event) {
        if(semanaCuentaPagar.getLength() > 0 && montoCuentaPagar.getLength() > 0 && razonCuentaPagar.getLength() >0){
            IndicadoresDinero indicadores = new IndicadoresDinero(Integer.parseInt(semanaCuentaPagar.getText()),Float.parseFloat(montoCuentaPagar.getText()),razonCuentaPagar.getText(),2);
            indicadoresDAO.insert(indicadores);
            semanaCuentaPagar.clear();
            montoCuentaPagar.clear();
            razonCuentaPagar.clear();
            errorPagar.setText("");
        }else{
            errorPagar.setText("Faltan campos por llenar");
        }


    }

    @FXML
    void guardarBancoOnMuseClicked(MouseEvent event) {
        if(semanaBanco.getLength() > 0 && montoBanco.getLength() > 0 && razonBanco.getLength() >0){
            IndicadoresDinero indicadores = new IndicadoresDinero(Integer.parseInt(semanaBanco.getText()),Float.parseFloat(montoBanco.getText()),razonBanco.getText(),3);
            indicadoresDAO.insert(indicadores);
            semanaBanco.clear();
            montoBanco.clear();
            razonBanco.clear();
            errorBanco.setText("");
        }else{
            errorBanco.setText("Faltan campos por llenar");
        }


    }

    @FXML
    void houseClicked(MouseEvent event) {
        Main.secondStage.close();
    }

}
