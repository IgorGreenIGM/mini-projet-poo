package core;

import java.sql.*;
import java.util.Date;

/**
 * Classe abstraite représentant un contact.
 */
public abstract class Contact {
    
    // Attributs
    protected String code; // Code du contact
    protected String nom; // Nom du contact
    protected Date dateDeNaissance; // Date de naissance du contact
    protected String address; // Adresse du contact
    protected String email; // Adresse email du contact
    protected String telNumber; // Numéro de téléphone du contact

    /**
     * Constructeur de la classe Contact.
     * 
     * @param code              Le code du contact.
     * @param nom               Le nom du contact.
     * @param dateDeNaissance   La date de naissance du contact.
     * @param address           L'adresse du contact.
     * @param email             L'adresse email du contact.
     * @param telNumber         Le numéro de téléphone du contact.
     * @throws IllegalArgumentException Si des paramètres invalides sont passés au constructeur.
     */
    public Contact(String code, String nom, Date dateDeNaissance, String address, String email, String telNumber) throws IllegalArgumentException {
        if (code.equals("") || nom.equals("") || dateDeNaissance == null || address.equals("") || email.equals("") || telNumber.equals(""))
            throw new IllegalArgumentException("erreur, mauvais parametres dans l'appel au constructeur contact");
        
        this.code = code;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.address = address;
        this.email = email;
        this.telNumber = telNumber;
    }
    
    /**
     * Méthode abstraite pour insérer les informations du contact dans la base de données.
     * 
     * @param connection Connexion à la base de données.
     */
    public abstract void insererContact(Connection connection);
    
    public String getCode() {
        return code;
    }
    
    // setters & getters
    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Méthode pour afficher les informations du contact.
     */
    public void print(){
        System.out.print(this.code + " " + this.nom + " " + this.address + " " + this.email + " " + this.telNumber + " " + this.dateDeNaissance.toString());
    }
}
