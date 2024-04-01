package tp.poo.sql.swing;

import core.Agent;
import java.util.Date;

import core.Repertoire;
import core.Etudiant;
import core.Enseignant;


public class MainApplication {
    
    public static void main(String[] args){
        Repertoire repertoire = new Repertoire();
        
        // testing add
        Etudiant etudiant = new Etudiant("21P246", "Mogou Igor Green", new Date(), "1234melen", "igormogou86@gmail.com", "690909090", "3GI", Etudiant.Cycle.Ingenieur);
        Etudiant etudiant2 = new Etudiant("21P330", "Moga Igora Greenelle", new Date(), "1345yde", "igoramoga86@gmail.com", "696969696", "3GI", Etudiant.Cycle.Licence);
        Enseignant enseignant = new Enseignant("AF3UY1", "Pr. GG",  new Date(), "1456doula", "GG@GG.com", "6GGGGGGGG", Enseignant.Statut.Permanent);
        Enseignant enseignant2 = new Enseignant("AF2UY1", "Pr. GGA",  new Date(), "1478medssa", "GGA@GGA.com", "6GGAGGAGGAGGA", Enseignant.Statut.Vacataire);
        Agent agent = new Agent("AF3AFK2021", "Agent GG", new Date(), "agent@agent.com", "456nkoabang", "697949794", 600000, Agent.Statut.Stagiaire, "CategorieA", 10, "Manager");
        
        repertoire.ajouterContact(etudiant);        
        repertoire.ajouterContact(etudiant2);
        repertoire.ajouterContact(enseignant);
        repertoire.ajouterContact(enseignant2);
        repertoire.ajouterContact(agent);
        
        System.out.println("Initial Content of repertory  : ");
        repertoire.afficherRepertoire();
        
        // testing modification
        repertoire.modifierContact("AF3AFK2021", "Agent GG1", new Date(), "123messassi", "agent@agent.com", "678946424", 650000, Agent.Statut.Temporaire, "CategorieB", 0, "Manager");
        repertoire.modifierContact("21P246", "Igor Green Mogou", new Date(), "123emana", "igorgreen86@gmail.com", "123456789", "4GI", Etudiant.Cycle.Licence);
        repertoire.modifierContact("AF3UY1", "Prof. GG", new Date(), "123 nkozoa", "gg@example.com", "987654321", Enseignant.Statut.Vacataire); //*/
        
        System.out.println("Content of repertory after modifications : ");
        repertoire.afficherRepertoire();
        
        // Check if the modification is successful
        Etudiant modifiedEtudiant = (Etudiant) repertoire.rechercherContact("21P246");
        assert modifiedEtudiant.getNom().equals("Igor Green Mogou") && modifiedEtudiant.getEmail().equals("igorgreen86@gmail.com") && modifiedEtudiant.getTelNumber().equals("123456789") && modifiedEtudiant.getNiveau().equals("4GI") && modifiedEtudiant.getCycle().equals(Etudiant.Cycle.Licence);      
        Enseignant modifiedEnseignant = (Enseignant) repertoire.rechercherContact("AF3UY1");
        assert modifiedEnseignant.getNom().equals("Prof. GG") && modifiedEnseignant.getEmail().equals("gg@example.com") && modifiedEnseignant.getTelNumber().equals("987654321") && modifiedEnseignant.getStatut().equals(Enseignant.Statut.Vacataire);
        Agent modifiedAgent = (Agent) repertoire.rechercherContact("AF3AFK2021");
        assert modifiedAgent.getNom().equals(agent.getNom()) && modifiedAgent.getEmail().equals("gg@example.com") && modifiedAgent.getStatut().equals(Agent.Statut.Permanent);
         // */
        
        repertoire.SupprimerContact("21P330");
        repertoire.SupprimerContact("AF2UY1");
        
         System.out.println("Content of repertory after Suppressions : ");
        repertoire.afficherRepertoire();
    }
}
