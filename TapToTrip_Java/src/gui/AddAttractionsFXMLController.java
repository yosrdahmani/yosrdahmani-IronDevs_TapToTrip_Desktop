/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Attraction;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.AttractionService;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AddAttractionsFXMLController implements Initializable {

    @FXML
    private Label pont;
    @FXML
    private TextField NomAttraction;
    @FXML
    private TextField LieuAttraction;
    @FXML
    private TextArea DescriptionAttraction;
    @FXML
    private Button pont1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboard(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilBack.fxml"));
            Parent root = loader.load();
            pont.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(gui.AccueilBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Voyage(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listVoyagesFXML.fxml"));
            Parent root = loader.load();
            pont.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(gui.ListVoyagesFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Attraction(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listAttractionsFXML.fxml"));
            Parent root = loader.load();
            pont.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(gui.AccueilBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BoutonBack(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listAttractionsFXML.fxml"));
            Parent root = loader.load();
            pont.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(gui.ListAttractionsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouterAttraction(ActionEvent event) {
        
        AttractionService as = new AttractionService();
          if (NomAttraction.getText().equals("")||LieuAttraction.getText().equals("")||DescriptionAttraction.getText().equals(""))
       {
           JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs!");
       } 
        
          else { 
              Attraction att = new Attraction(NomAttraction.getText(), LieuAttraction.getText(), DescriptionAttraction.getText() );
          
        as.ajouterAttraction(att);
        
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Succes");
        alert.setContentText("Attraction ajoutée avec succes! ");
        alert.show();
        
        NomAttraction.setText("");
        LieuAttraction.setText("");
        DescriptionAttraction.setText("");
          }
    }

    @FXML
    private void AnnulerAjoutAttraction(ActionEvent event) {
        
        NomAttraction.setText("");
        LieuAttraction.setText("");
        DescriptionAttraction.setText("");
    }

    @FXML
    private void deconnecter(ActionEvent event) {
              try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontVoyage.fxml"));
            Parent root = loader.load();
            pont.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FrontVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
