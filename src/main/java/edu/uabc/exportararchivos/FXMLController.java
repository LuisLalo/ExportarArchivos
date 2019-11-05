package edu.uabc.exportararchivos;

import conexionBD.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import modelo.Catorcena;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ComboBox<Catorcena> cbCatorcena;
    
    private List<Catorcena> catorcena = new ArrayList<>();
    
    private ObservableList<Catorcena> obsCatorcena;
    
    @FXML
    private Button button;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void mouseClicked (ActionEvent event) {
        System.out.println("Hola Mundo");
        label.setText("Hola Mundo");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarCatorcenas();
    }
    
    public void agregarCatorcenas() {
        
        try {
            // Se crea el objeto para conectarse a la base de datos
            Conexion conn = new Conexion();
            Connection conexion = conn.getConexion();
            
            //Código para hacer el query a la base de datos y ejecutarlo
            PreparedStatement preparedStatement = conexion.prepareStatement("select distinct TextoExtra3 from ControlFacturasAYA");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                Catorcena c1 = new Catorcena(resultSet.getString(1));
                catorcena.add(c1);
            }
            
            // Se cierra la conexión a la base de datos
            conexion.close();
            
            obsCatorcena = FXCollections.observableArrayList(catorcena);
            
            cbCatorcena.setItems(obsCatorcena);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
}