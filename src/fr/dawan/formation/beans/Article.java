package fr.dawan.formation.beans;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Doit avoir un constructeur par défaut (ie vide)
 * 
 * Toutes variables d'instances pv
 * 
 * Getter + Setter pour toutes les var
 * 
 * Doit implementer l'interface Serializable
 *
 */

public class Article implements Serializable {
    
    private long id;
    
    private String description;
    
    private double prix;

    private LocalDate dateFabrication;
    
    public Article() {
        super();
    }

    public Article(String description, double prix, LocalDate dateFabrication) {
        super();
        this.description = description;
        this.prix = prix;
        this.dateFabrication = dateFabrication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LocalDate getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(LocalDate dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", description=" + description + ", prix=" + prix + ", dateFabrication="
                + dateFabrication + "]";
    }
    
}
