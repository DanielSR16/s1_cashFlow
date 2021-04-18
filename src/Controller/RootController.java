package Controller;

import Entities.IndicadoresDinero;
import Entities.Utilidad;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import application.Main;
public class RootController {

    @FXML
    void categoriasClicked(MouseEvent event) {
        Main.newStage("categoriaView","Categorias");
    }

    @FXML
    void flujoClicked(MouseEvent event) {
        Main.newStage("flujoView","Flujo de efectivo");

    }

    @FXML
    void indicadoresClicked(MouseEvent event) {
        Main.newStage("indicadoresView","Indicadores de dinero");
    }

    @FXML
    void reporteClicked(MouseEvent event) {
//        Utilidad [] utilidad = new Utilidad[4];
//        IndicadoresDinero [] indicadores = new IndicadoresDinero[4];

//        for (int i = 0; i < 4; i++) {
//
//            Utilidad utilidadSemanal = new Utilidad();

//        }

        Main.newStage("reporteView","Generar Reporte");

    }

}
