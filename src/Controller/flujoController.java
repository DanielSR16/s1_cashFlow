package Controller;

import DAO.CategoriaDAO;
import DAO.FlujoEfectivoDAO;
import DAO.SubCategoriaDAO;
import Entities.Categoria;
import Entities.FlujoEfectivo;
import Entities.SubCategoria;
import application.Main;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import java.util.ResourceBundle;

public class flujoController implements Initializable {
    CategoriaDAO categoriadao =  new CategoriaDAO();
    SubCategoriaDAO subcategoriaDAO = new SubCategoriaDAO();
    FlujoEfectivoDAO flujoEfectivoDAO  = new FlujoEfectivoDAO();
    long now = System.currentTimeMillis();
    Date sqlDate = new Date(now);

    @FXML
    private TableView<FlujoEfectivo> tabla;

    @FXML
    private TableColumn<FlujoEfectivo, Date> fechaColum;

    @FXML
    private TableColumn<FlujoEfectivo, String> descripcionColum;

    @FXML
    private TableColumn<FlujoEfectivo, String> categoriaColum;

    @FXML
    private TableColumn<FlujoEfectivo, String> subcategoriaColum;

    @FXML
    private CheckBox checkBoxEntrada;

    @FXML
    private CheckBox checkBoxSalida;

    @FXML
    private ComboBox<String> comboBoxCategoria;

    @FXML
    private TextField textFieldDescripcion;

    @FXML
    private TextField textFieldMonto;

    @FXML
    private ComboBox<String> comboBoxSubCategoria1;
    @FXML
    private Label errorLabel;

    @FXML
    private DatePicker fecha;


    @FXML
    void entradaOnMouseClicked(MouseEvent event) {
        if(checkBoxSalida.isSelected()){
            checkBoxSalida.setSelected(false);
        }

        if(checkBoxEntrada.isSelected()){
            ObservableList<String> categoriaBOX = FXCollections.observableArrayList();
            for (int i = 0; i < categoriadao.getCategorias(2,3).size(); i++) {
                categoriaBOX.add(categoriadao.getCategorias(2,3).get(i).getNombre());
            }
            comboBoxCategoria.setItems(categoriaBOX);
        }

    }

    @FXML
    void salidaOnMouseClicked(MouseEvent event) {
        if(checkBoxEntrada.isSelected()){
            checkBoxEntrada.setSelected(false);
        }
            if(checkBoxSalida.isSelected()){
                ObservableList<String> categoriaBOX = FXCollections.observableArrayList();
                for (int i = 0; i < categoriadao.getCategorias(1).size(); i++) {
                    categoriaBOX.add(categoriadao.getCategorias(1).get(i).getNombre());
                }
                comboBoxCategoria.setItems(categoriaBOX);
            }
        }


    @FXML
    void comboSubCategoriaOnMouseClicked(MouseEvent event) {
        if(comboBoxCategoria.getSelectionModel().isEmpty() == false){
            ObservableList<String> subcategoriaBOX = FXCollections.observableArrayList();
            for (int i = 0; i < subcategoriaDAO.getAllSubCategoriabycategoriaPadre(comboBoxCategoria.getSelectionModel().getSelectedItem()).size(); i++) {
                subcategoriaBOX.add(subcategoriaDAO.getAllSubCategoriabycategoriaPadre(comboBoxCategoria.getSelectionModel().getSelectedItem()).get(i).getNombre());
            }
            comboBoxSubCategoria1.setItems(subcategoriaBOX);
        }
    }
//    @FXML
//    void comboCategoriaOnMouseClicked(MouseEvent event) {
//        if(comboBoxCategoria.getSelectionModel().isEmpty() == false){
//            ObservableList<String> subcategoriaBOX = FXCollections.observableArrayList();
//            for (int i = 0; i < subcategoriaDAO.getAllSubCategoriabycategoriaPadre(comboBoxCategoria.getSelectionModel().getSelectedItem()).size(); i++) {
//                subcategoriaBOX.add(subcategoriaDAO.getAllSubCategoriabycategoriaPadre(comboBoxCategoria.getSelectionModel().getSelectedItem()).get(i).getNombre());
//            }
//            comboBoxSubCategoria1.setItems(subcategoriaBOX);
//        }
//
//
//    }

    @FXML
    void guardarClicked(MouseEvent event) {
        if(textFieldMonto.getLength()>0 && textFieldDescripcion.getLength()>0 && comboBoxSubCategoria1.getSelectionModel().isEmpty() == false && comboBoxCategoria.getSelectionModel().isEmpty() == false){
            Date date = Date.valueOf(LocalDate.of(fecha.getValue().getYear(), fecha.getValue().getMonth(), fecha.getValue().getDayOfMonth()));

            FlujoEfectivo  flujoefectivo = new FlujoEfectivo(Float.parseFloat(textFieldMonto.getText()),textFieldDescripcion.getText(),date,comboBoxCategoria.getSelectionModel().getSelectedItem(),comboBoxSubCategoria1.getSelectionModel().getSelectedItem());
            flujoEfectivoDAO.insertFlujo(flujoefectivo);

            textFieldDescripcion.clear();
            textFieldMonto.clear();
            comboBoxCategoria.getSelectionModel().clearSelection();
            comboBoxSubCategoria1.getSelectionModel().clearSelection();
            checkBoxEntrada.setSelected(false);
            checkBoxSalida.setSelected(false);
            tabla.getItems().clear();
            
            ObservableList<FlujoEfectivo> flujo =  FXCollections.observableArrayList();
            fechaColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,Date>("fecha"));
            descripcionColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,String>("descripcion"));
            categoriaColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,String>("Categoria"));
            subcategoriaColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,String>("subCategoria"));
            flujo.addAll(flujoEfectivoDAO.getAllFlujoEfectivo());
            tabla.setItems(flujo);
            errorLabel.setText("");

        }else {
            errorLabel.setText("FALTAN CAMPOS POR LLENAR");
        }

    }

    @FXML
    void houseClicked(MouseEvent event) {
        Main.secondStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        LocalDate localDate = Instant.ofEpochMilli(sqlDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        fecha.setValue(localDate);
        ObservableList<FlujoEfectivo> flujo =  FXCollections.observableArrayList();
        fechaColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,Date>("fecha"));
        descripcionColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,String>("descripcion"));
        categoriaColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,String>("Categoria"));
        subcategoriaColum.setCellValueFactory(new PropertyValueFactory<FlujoEfectivo,String>("subCategoria"));
        flujo.addAll(flujoEfectivoDAO.getAllFlujoEfectivo());
        tabla.setItems(flujo);






    }
}