package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe représentant un enseignant.
 */
public class Enseignant extends Contact {
    
    /**
     * Énumération représentant les différents statuts d'un enseignant.
     */
    public enum Statut {
        Vacataire,
        Permanent
    }
    
    private Statut statut; // Statut de l'enseignant

    /**
     * Constructeur de la classe Enseignant.
     * 
     * @param code              Le code de l'enseignant.
     * @param nom               Le nom de l'enseignant.
     * @param dateDeNaissance   La date de naissance de l'enseignant.
     * @param address           L'adresse de l'enseignant.
     * @param email             L'adresse email de l'enseignant.
     * @param telNumber         Le numéro de téléphone de l'enseignant.
     * @param statut            Le statut de l'enseignant.
     * @throws IllegalArgumentException Si des paramètres invalides sont passés au constructeur.
     */
    public Enseignant(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, Statut statut) throws IllegalArgumentException{
        super(code, nom, dateDeNaissance, address, email, telNumber);
        
        if(statut == null)
            throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au contructeur Enseignant");
        
        this.statut = statut;
    }

    /**
     * Méthode pour insérer les informations de l'enseignant dans la base de données.
     * 
     * @param connection Connexion à la base de données.
     */
    @Override
    public void insererContact(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Enseignant (code, nom, date_naissance, adresse, email, tel_number, statut) VALUES (";
            // converting date 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
            String[] values = {this.code, this.nom, format.format(this.dateDeNaissance), this.address, this.email, this.telNumber, this.statut.name()};
            for (String value : values)
                query += "\"" + value + "\"" + ",";
            
            query = query.substring(0, query.length() - 1);
            query += ");";
            
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(" " + this.statut);
    }
}
