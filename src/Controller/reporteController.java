package Controller;

import DAO.FlujoEfectivoDAO;
import DAO.UtilidadDAO;
import Entities.FlujoEfectivo;
import Entities.IndicadoresDinero;
import Entities.Utilidad;
import Model.Contador;
import Model.Informe;
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
    Informe informe = new Informe();

    @FXML
    void seleccionarClicked(MouseEvent event) {
        int semanasMax = 5;
        List<FlujoEfectivo> flujosMes = flujoEfectivoDAO.getAllFlujoEfectivoMes(meses.getSelectionModel().getSelectedIndex()+1);

//        FLUJOS DE EFECTIVO


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

        System.out.println("Flujos de efectivo semanales: ");

        for (int i = 0; i < semanasMax; i++) {

            for (int j = 0; j < flujosMes.size(); j++) {
                if(flujoEfectivosSemanales[i][j]==null){
                    break;
                }
                System.out.print(flujoEfectivosSemanales[i][j]);

            }
            System.out.println();
        }


//        List<FlujoEfectivo> gastoAOC =new ArrayList<>();  //GASTO-AOC
//        List<FlujoEfectivo> deposito =new ArrayList<>(); //DEPOSITO
//        List<FlujoEfectivo> efectivo =new ArrayList<>(); //EFECTIVO
//        List<FlujoEfectivo> costoVenta =new ArrayList<>();//COSTO-VENTA
//
//        for (int i = 0; i < semanasMax; i++) {
//            for (int j = 0; j < flujosMes.size(); j++) {
//
//                if(flujoEfectivosSemanales[i][j]!=null){
//
//                    if(flujoEfectivosSemanales[i][j].getIdClasificacion() == 3 ){
//                        deposito.add(flujoEfectivosSemanales[i][j]);
//                    }
//                    if(flujoEfectivosSemanales[i][j].getIdClasificacion() == 2){
//                        efectivo.add(flujoEfectivosSemanales[i][j]);
//                    }
//                    if(flujoEfectivosSemanales[i][j].getIdClasificacion() == 4){
//                        costoVenta.add(flujoEfectivosSemanales[i][j]);
//                    }
//                    else {
//                        gastoAOC.add(flujoEfectivosSemanales[i][j]);
//                    }
//                }
//            }
//        }

            for (int j = 0; j < semanasMax; j++) {

                float gastoAOC = 0;
                float costoVenta =0;
                float efectivo = 0;
                float deposito = 0;
                float ganancias = 0;
                int margen = 0;

                for (int i = 0; i < flujosMes.size(); i++) {

                    if(flujoEfectivosSemanales[j][i] == null){

                        ganancias = contador.calcularGanancia(costoVenta+gastoAOC,efectivo+deposito);
                        margen = contador.calcularMargen(ganancias,efectivo+deposito);

                        Utilidad utilidad = new Utilidad(costoVenta+gastoAOC,efectivo+deposito,margen,ganancias,j+1,efectivo,deposito,gastoAOC,costoVenta,meses.getSelectionModel().getSelectedIndex()+1);
                        //System.out.println(utilidad);
                        //utilidadDAO.insert(utilidad);
                        break;
                    }

                    if(flujoEfectivosSemanales[j][i].getIdClasificacion() == 1){
                        gastoAOC = gastoAOC + flujoEfectivosSemanales[j][i].getMonto();
                    }

                    if(flujoEfectivosSemanales[j][i].getIdClasificacion() == 2){
                        efectivo = efectivo + flujoEfectivosSemanales[j][i].getMonto();
                    }

                    if(flujoEfectivosSemanales[j][i].getIdClasificacion() == 3){
                        deposito = deposito + flujoEfectivosSemanales[j][i].getMonto();
                    }

                    if(flujoEfectivosSemanales[j][i].getIdClasificacion() == 4){
                        costoVenta = costoVenta + flujoEfectivosSemanales[j][i].getMonto();
                    }
                }
            }


            //informe.informe(String.valueOf(meses.getSelectionModel().getSelectedIndex()+1));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> flujo =  FXCollections.observableArrayList();
        flujo.addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiempbre","Octubre","Noviembre","Diciembre");

        meses.setItems(flujo);
    }
}
