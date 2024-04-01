
package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La classe Agent représente un agent avec des informations spécifiques.
 * Elle hérite de la classe Contact.
 */
public class Agent  extends Contact {
    
    /**
     * L'énumération Statut définit les différents statuts possibles d'un agent.
     */
    public enum Statut{
        Temporaire,
        Stagiaire,
        Permanent
    }
    
    private int salaire; // Le salaire de l'agent
    private Statut statut; // Le statut de l'agent
    private String categorie; // La catégorie de l'agent
    private int indiceSalaire; // L'indice de salaire de l'agent
    private String occupation; // L'occupation de l'agent

    /**
     * Constructeur de la classe Agent.
     * 
     * @param code              Le code de l'agent.
     * @param nom               Le nom de l'agent.
     * @param dateDeNaissance   La date de naissance de l'agent.
     * @param address           L'adresse de l'agent.
     * @param email             L'adresse email de l'agent.
     * @param telNumber         Le numéro de téléphone de l'agent.
     * @param salaire           Le salaire de l'agent.
     * @param statut            Le statut de l'agent.
     * @param categorie         La catégorie de l'agent.
     * @param indiceSalaire     L'indice de salaire de l'agent.
     * @param occupation        L'occupation de l'agent.
     * @throws IllegalArgumentException Si des paramètres invalides sont passés au constructeur.
     */
    public Agent(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, int salaire, Statut statut, String categorie, int indiceSalaire, String occupation) throws IllegalArgumentException{
        super(code, nom, dateDeNaissance, address, email, telNumber);
        
        if (statut == null || categorie.equals("") || occupation.equals("") || indiceSalaire < 0)
                throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au constructeur Agent");
        
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indiceSalaire = indiceSalaire;
        this.occupation = occupation;
    }
    
    /**
     * Méthode pour insérer les informations de l'agent dans la base de données.
     * 
     * @param connection Connexion à la base de données.
     */
    @Override
    public void insererContact(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Agent (code, nom, date_naissance, adresse, email, tel_number, salaire, statut, categorie, indice_salaire, occupation) VALUES (";
            // converting date 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
            String[] values = {this.code, this.nom, format.format(this.dateDeNaissance), this.address, this.email, this.telNumber, Integer.toString(this.salaire), this.statut.name(), this.categorie, Integer.toString(this.indiceSalaire), this.occupation};
            for (String value : values)
                query += "\"" + value + "\"" + ",";
            
            query = query.substring(0, query.length() - 1);
            query += ");";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Getters et Setters
    
    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIndiceSalaire() {
        return indiceSalaire;
    }

    public void setIndiceSalaire(int indiceSalaire) {
        this.indiceSalaire = indiceSalaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    /**
     * Méthode pour afficher les informations de l'agent.
     */
    @Override
    public void print(){
        super.print();
        System.out.println(" " + this.categorie + " " + this.occupation + " " + this.indiceSalaire + " " + this.salaire + " " + this.statut.name());
    }
}
