package fr.dawan.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.formation.beans.Article;

public class Main {

    public static void main(String[] args) {
        
        Article a = new Article("Une télévision 4K", 700.00, LocalDate.of(2021, 3, 10)); 
        
        List<Article> l=testSelect();
        for(Article ar : l) {
            System.out.println(ar);}
        }
    
/*        Connection cnx = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cnx=DriverManager.getConnection("jdbc:mariadb://localhost:3306/formation", "root", "dawan");
            Statement stm=cnx.createStatement();
            stm.executeUpdate("INSERT INTO articles(description,prix,date_fabrication) VALUES('"+a.getDescription()+"',"+a.getPrix()+",'"+a.getDateFabrication().toString()+"')");            System.out.println("Connecté à MariaDB !");
        } catch (ClassNotFoundException e) {
            System.out.println("Probleme de driver !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Probleme de connection a la BDD !");
            e.printStackTrace();
        } finally {
            if(cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
    
    /**
     * 
     * Try with ressource va fermer auto la connection a la DB
     */
    public static List<Article> testSelect(){
        List<Article> lst=new ArrayList<>();
        try(Connection cnx=DriverManager.getConnection("jdbc:mariadb://localhost:3306/formation", "root", "dawan")){
            Statement stm=cnx.createStatement();
            ResultSet rs=stm.executeQuery("SELECT id,description,prix,date_fabrication FROM articles");
            while(rs.next()) {
                Article ar=new Article(rs.getString("description"), rs.getDouble("prix"), rs.getDate("date_fabrication").toLocalDate());
                ar.setId(rs.getLong("id"));
                lst.add(ar);}
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Probleme de connection a la BDD !");
        }
        return lst;
    }
} 
