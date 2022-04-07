/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categorie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyDB;

/**
 *
 * @author lenovo
 */
public class CategorieService implements IService<Categorie> {
    
    Connection con;
    Statement stmm;
    
    public CategorieService(){
            con = MyDB.getInstance().getCon();
        
    }

    @Override
    public void ajouter(Categorie categorie) {
        try {
            String req="INSERT INTO `categorie`(`nom`, `boitevitesse`) VALUES ('"+ categorie.getNom() +"','"+ categorie.getBoiteVitesse() +"')";
            stmm = con.createStatement();
            stmm.executeUpdate(req); 
            System.out.println("Catégorie ajoutée");
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }

    @Override
    public List<Categorie> afficher() {
        List<Categorie> categories = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM `categorie`";
            stmm = con.createStatement();
            ResultSet rst = stmm.executeQuery(req);
           
            while (rst.next()) {
                Categorie c = new Categorie(rst.getInt("Id"),rst.getString("Nom"),rst.getString("BoiteVitesse"));
                categories.add(c);   
            }
           
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return categories;
    }
    

    @Override
    public void modifier(Categorie categorie){
        try {
            String req="UPDATE `categorie` SET `nom`='"+ categorie.getNom() +"',`boitevitesse`='"+ categorie.getBoiteVitesse() +"' WHERE `id`='"+ categorie.getId() +"'";
            stmm = con.createStatement();
            stmm.executeUpdate(req); 
            System.out.println("Categorie modifiée");
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }
    
    public Connection getCon() {
        return con;
    }

    @Override
    public void supprimer(Categorie categorie) {
        try {
            String req="DELETE FROM `categorie` WHERE `id`='"+ categorie.getId() +"'";
            stmm = con.createStatement();
            stmm.executeUpdate(req); 
            System.out.println("Categorie supprimée");
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }
}
