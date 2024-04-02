# Mini-Projet POO 
Réalisé par Mogou Igor Green, 3GI
Ce mini-projet est une application de gestion de répertoire de contacts, développée en Java dans le cadre d'un cours de Programmation Orientée Objet (POO).

## Interface graphique
### affichage de la liste des contacts
<img src="./captures/list.png">
### interface de création de contacts
<div style="display:flex;">
  <img src="./captures/etudiant.png" style="width:32%; height:32%;">
  <img src="./captures/agent.png" style="width:32%; height:32%;">
  <img src="./captures/enseignat.png" style="width:32%; height:32%;">
</div>

## Schéma de la base de données :

```mermaid
erDiagram
    Contact {
        code VARCHAR(255)
        nom VARCHAR(255)
        date_naissance DATE
        address VARCHAR(255)
        telNumber VARCHAR(255)
        email VARCHAR(255)
    }

    Agent {
        salaire DECIMAL
        statut VARCHAR(255)
        categorie VARCHAR(255)
        indice_salaire INT
        occupation VARCHAR(255)
        code VARCHAR(255)
    }

    Etudiant {
        cycle VARCHAR(255)
        niveau VARCHAR(255)
    }

    Enseignant {
        statut VARCHAR(255)
    }

    Contact ||--|{ Agent : code
    Contact ||--|{ Etudiant : code
    Contact ||--|{ Enseignant : code
```

## Utilisation

Pour utiliser cette application, vous pouvez suivre les étapes suivantes :

1. Clonez ce dépôt sur votre machine locale
```shell
git clone https://github.com/IgorGreenIGM/mini-projet-poo/edit/master
```
2. Ouvrez le projet dans Apache netbeans
3. Lancez le fichier `ui/MainFrmApplication.java`

## Auteur

Ce projet a été développé par Mogou Igor Green -- 3GI -- 21P246

## Licence

Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.
