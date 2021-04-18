package Controller;

import DAO.FlujoEfectivoDAO;
import Entities.FlujoEfectivo;
import Entities.IndicadoresDinero;
import Entities.Utilidad;
import Model.Contador;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class reporteController implements Initializable {

    @FXML
    private ComboBox<String> meses;
    Contador contador = new Contador();
    FlujoEfectivoDAO flujoEfectivoDAO = new FlujoEfectivoDAO();

    @FXML
    void seleccionarClicked(MouseEvent event) {
        int semanasMax = 1;
        List<FlujoEfectivo> flujosMes = flujoEfectivoDAO.getAllFlujoEfectivoMes(meses.getSelectionModel().getSelectedIndex()+1);

        ArrayList<Utilidad> utilidads = new ArrayList<>();
        ArrayList<IndicadoresDinero> indicadoresDineros = new ArrayList<>();


        for (int i = 0; i < flujosMes.size(); i++) {

            if (flujosMes.get(i).getNumSemana() > semanasMax){
                semanasMax = flujosMes.get(i).getNumSemana();
            }

        }

        FlujoEfectivo [][] flujoEfectivosSemanales = new FlujoEfectivo[semanasMax][flujosMes.size()];


        int cont = 0;
        for (int i = 0; i < semanasMax; i++) {

            for (int j = 0; j < flujosMes.size(); j++) {

               if ( flujosMes.get(j).getNumSemana() == i+1){

                   flujoEfectivosSemanales[i][cont] = flujosMes.get(j);
                   cont++;
               }
            }
            cont = 0;
        }

        List<FlujoEfectivo> egresos =new ArrayList<>();
        List<FlujoEfectivo> ingresos =new ArrayList<>();

        for (int i = 0; i < semanasMax; i++) {

            for (int j = 0; j < flujosMes.size(); j++) {

                if(flujoEfectivosSemanales[i][j]!=null){

                    if(flujoEfectivosSemanales[i][j].getIdClasificacion() == 3 || flujoEfectivosSemanales[i][j].getIdClasificacion() == 4){
                        ingresos.add(flujoEfectivosSemanales[i][j]);
                    }
                    else {
                        egresos.add(flujoEfectivosSemanales[i][j]);
                    }

                }

            }

            contador.calcularEgresoTotal(egresos);
            contador.calcularIngresoTotal(ingresos);

            Utilidad utilidad = new Utilidad();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> flujo =  FXCollections.observableArrayList();
        flujo.addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiempbre","Octubre","Noviembre","Diciembre");

        meses.setItems(flujo);
    }
}
