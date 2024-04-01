package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Etudiant extends Contact{
    
    // Attributs
    public enum Cycle {
        Licence,
        Ingenieur
    }

    private String niveau; // Niveau de l'étudiant
    private Cycle cycle; // Cycle de l'étudiant

    /**
     * Constructeur de la classe Etudiant.
     * 
     * @param code              Le code de l'étudiant.
     * @param nom               Le nom de l'étudiant.
     * @param dateDeNaissance   La date de naissance de l'étudiant.
     * @param address           L'adresse de l'étudiant.
     * @param email             L'adresse email de l'étudiant.
     * @param telNumber         Le numéro de téléphone de l'étudiant.
     * @param niveau            Le niveau de l'étudiant.
     * @param cycle             Le cycle de l'étudiant.
     * @throws IllegalArgumentException Si des paramètres invalides sont passés au constructeur.
     */
    public Etudiant(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber, String niveau, Cycle cycle) throws IllegalArgumentException{
        super(code, nom, dateDeNaissance, address, email, telNumber);
        
        if (niveau.equals("") || cycle == null)
            throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au contructeur contact");
        
        this.niveau = niveau;
        this.cycle = cycle;
    }
    
    /**
     * Méthode pour insérer les informations de l'étudiant dans la base de données.
     * 
     * @param connection Connexion à la base de données.
     */
    @Override
    public void insererContact(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Etudiant (code, nom, date_naissance, adresse, email, tel_number, cycle, niveau) VALUES (";
            // converting date 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
            String[] values = {this.code, this.nom, format.format(this.dateDeNaissance), this.address, this.email, this.telNumber, this.cycle.name(), this.niveau};
            for (String value : values)
                query += "\"" + value + "\"" + ",";
            
            query = query.substring(0, query.length() - 1);
            query += ");";
            
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }
    
    /**
     * Méthode pour afficher les informations de l'etudiant.
     */
    @Override
    public void print(){
        super.print();
        System.out.println(" " + this.niveau + " " + this.cycle.name());
    }
}
