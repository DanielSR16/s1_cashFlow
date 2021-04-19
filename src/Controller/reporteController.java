package Controller;

import DAO.FlujoEfectivoDAO;
import DAO.UtilidadDAO;
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
    UtilidadDAO utilidadDAO = new UtilidadDAO();

    @FXML
    void seleccionarClicked(MouseEvent event) {
        int semanasMax = 1;
        List<FlujoEfectivo> flujosMes = flujoEfectivoDAO.getAllFlujoEfectivoMes(meses.getSelectionModel().getSelectedIndex()+1);

        //FLUJOS DE EFECTIVO

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
        List<FlujoEfectivo> ventas =new ArrayList<>();

        for (int i = 0; i < semanasMax; i++) {
            for (int j = 0; j < flujosMes.size(); j++) {

                if(flujoEfectivosSemanales[i][j]!=null){

                    if(flujoEfectivosSemanales[i][j].getIdClasificacion() == 3 ){
                        ingresos.add(flujoEfectivosSemanales[i][j]);
                    }
                    if(flujoEfectivosSemanales[i][j].getIdClasificacion() == 2){
                        ventas.add(flujoEfectivosSemanales[i][j]);
                    }
                    else {
                        egresos.add(flujoEfectivosSemanales[i][j]);
                    }
                }
            }
        }

            for (int j = 0; j < semanasMax; j++) {

                float egresoTotal = 0;
                float ingresosTotaleClas = 0;
                float ventasTotales = 0;
                float ganancias = 0;
                int margen = 0;

                for (int i = 0; i < flujosMes.size(); i++) {

                    if(flujoEfectivosSemanales[j][i] == null){

                        ganancias = contador.calcularGanancia(egresoTotal,ingresosTotaleClas+ventasTotales);
                        margen = contador.calcularMargen(ganancias,ingresosTotaleClas+ventasTotales);

                        Utilidad utilidad = new Utilidad(egresoTotal,ingresosTotaleClas+ventasTotales,margen,ganancias,j+1,ventasTotales,ingresosTotaleClas,meses.getSelectionModel().getSelectedIndex()+1);
                        utilidadDAO.insert(utilidad);
                        break;
                    }

                    if(flujoEfectivosSemanales[j][i].getIdClasificacion() == 1){
                        egresoTotal = egresoTotal + flujoEfectivosSemanales[j][i].getMonto();
                    }

                    if(flujoEfectivosSemanales[j][i].getIdClasificacion() == 2){
                        ventasTotales = ventasTotales + flujoEfectivosSemanales[j][i].getMonto();
                    }

                    if(flujoEfectivosSemanales[j][i].getIdClasificacion() == 3){
                        ingresosTotaleClas = ingresosTotaleClas + flujoEfectivosSemanales[j][i].getMonto();
                    }
                }
            }







    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> flujo =  FXCollections.observableArrayList();
        flujo.addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiempbre","Octubre","Noviembre","Diciembre");

        meses.setItems(flujo);
    }
}
