package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class inventaire extends Application {
    private int argent = 0;
    private ObservableList<Tache> taches;
    private ObservableList<Objet> boutique;
    private ObservableList<Objet> inventaire; // Nouvelle liste pour stocker les objets achetés

    @Override
    public void start(Stage primaryStage) {
        taches = FXCollections.observableArrayList();
        boutique = FXCollections.observableArrayList();
        inventaire = FXCollections.observableArrayList();

        Text argentText = new Text("Argent: " + argent);

        TextField titreField = new TextField();

        Button creerTache = new Button("Créer Tâche");
        creerTache.setOnAction(e -> {
            String titre = titreField.getText();
            Tache nouvelleTache = new Tache(titre);
            taches.add(nouvelleTache);
            titreField.clear();
        });

        ListView<Tache> tachesListView = new ListView<>(taches);

        Button editerTache = new Button("Éditer");
        editerTache.setOnAction(e -> {
            Tache tacheSelectionnee = tachesListView.getSelectionModel().getSelectedItem();
            if (tacheSelectionnee != null) {
                String nouveauTitre = titreField.getText();
                tacheSelectionnee.setTitre(nouveauTitre);
            }
        });

        Button validerTache = new Button("Valider");
        validerTache.setOnAction(e -> {
            Tache tacheSelectionnee = tachesListView.getSelectionModel().getSelectedItem();
            if (tacheSelectionnee != null && !tacheSelectionnee.isValide()) {
                tacheSelectionnee.setValide(true);
                argent += 15;
                argentText.setText("Argent: " + argent);
            }
        });

        Button supprimerTache = new Button("Supprimer");
        supprimerTache.setOnAction(e -> {
            Tache tacheSelectionnee = tachesListView.getSelectionModel().getSelectedItem();
            if (tacheSelectionnee != null) {
                taches.remove(tacheSelectionnee);
            }
        });

        Text boutiqueText = new Text("Boutique");

        ListView<Objet> boutiqueListView = new ListView<>(boutique);

        Button acheterObjet = new Button("Acheter");
        acheterObjet.setOnAction(e -> {
            Objet objetSelectionne = boutiqueListView.getSelectionModel().getSelectedItem();
            if (objetSelectionne != null && argent >= objetSelectionne.getPrix()) {
                argent -= objetSelectionne.getPrix();
                argentText.setText("Argent: " + argent);
                Tache nouvelleTache = new Tache(objetSelectionne.getNom());
                taches.add(nouvelleTache);
                inventaire.add(objetSelectionne); // Ajouter l'objet acheté à l'inventaire
            }
        });

        // Ajout des objets à la boutique
        Objet objet1 = new Objet("SANDWICH SAUMON", 4);
        Objet objet2 = new Objet("SANDWICH PORC", 3);
        Objet objet3 = new Objet("SANDWICH POULET", 3);
        Objet objet4 = new Objet("SANDWICH THON", 3);
        Objet objet5 = new Objet("SANDWICH CHEVRET MIEL ", 3);
        Objet objet6 = new Objet("SANDWICH RUSTIQUE AUX NOIX ", 5);
        Objet objet7 = new Objet("SANDWICH GREC ", 4);
        Objet objet8 = new Objet("SANDWICH TOMATE MODZA ", 3);
        Objet objet9 = new Objet("SANDWICH POULET JAMBON BEURRE", 2);
        Objet objet10 = new Objet("SANDWICH POULET PANTHE", 4);
        Objet objet11 = new Objet("BOISSON OASIS ", 2);
        Objet objet12 = new Objet("BOISSON COCA ", 3);
        Objet objet13 = new Objet("BOISSON ORANGINA", 3);
        Objet objet14 = new Objet("BOISSON FANTA ", 3);
        Objet objet15 = new Objet("BOISSON SPRITE", 3);
        Objet objet16 = new Objet("BOISSON JUS D'ORANGE", 2);
        Objet objet17 = new Objet("AIR JORDAN 1", 265);
        Objet objet18 = new Objet("JORDAN 3 ", 220);
        Objet objet19 = new Objet("JORDAN 4 ", 340);
        Objet objet20 = new Objet("JORDAN 11 ", 150);
        Objet objet21 = new Objet("AIR FORCE 1 ", 145);
        Objet objet22 = new Objet("NIKE DUNK SEAN CLEAVER", 100);
        Objet objet23 = new Objet("JORDAN 1 FRAGMENT TRAVIS SCOTT", 25);
        Objet objet24 = new Objet("JORDAN 1 BLACK PHANTOM", 60);
        Objet objet25 = new Objet("NIKE SACAI WAFFLE ", 4);
        Objet objet26 = new Objet("NIKE SACAI WAFFLE BLAZER ", 2);
        Objet objet27 = new Objet("SACOCHE PARUR  ", 100);
        Objet objet28 = new Objet("SACOCHE OFF WHITE", 90);
        Objet objet29 = new Objet("SACOCHE GUCCI ", 80);
        Objet objet30= new Objet("SACOCHE PRADA", 70);
        Objet objet31 = new Objet("SACOCHE LOUIS VITTON", 60);
        Objet objet32 = new Objet("YEEZY 700", 350);
        Objet objet33 = new Objet("YEEZY 700 V2 ", 325);
        Objet objet34 = new Objet("YEEZY 700 STATIC ", 300);
        Objet objet35 = new Objet("YEEZY 500", 275);
        Objet objet36 = new Objet("YEEZY 350 ", 250);
        Objet objet37 = new Objet("IPHONE 14 PRO MAX", 250);
        Objet objet38 = new Objet("IPHONE 13 PRO MAX ", 225);
        Objet objet39 = new Objet("IPHONE 12 PRO MAX ", 200);
        Objet objet40 = new Objet("IPHONE 11 PRO MAX ", 175);
        
        boutique.addAll(objet1, objet2, objet3, objet4, objet5,objet6,objet7,objet8,objet9,objet10,objet11,objet12,objet13,objet14,objet15,objet16,objet17,objet18,objet19,objet20,objet21,objet22,objet23,objet24,objet25,objet26,objet27,objet28,objet29,objet30,objet31,objet32,objet33,objet34,objet35,objet36,objet37,objet38,objet39,objet40);

        ListView<Objet> inventaireListView = new ListView<>(inventaire); // ListView pour afficher l'inventaire

        HBox hBox1 = new HBox(titreField, creerTache);
        hBox1.setSpacing(10);

        HBox hBox2 = new HBox(editerTache, validerTache, supprimerTache);
        hBox2.setSpacing(10);

        HBox hBox3 = new HBox(boutiqueText);
        hBox3.setSpacing(10);

        HBox hBox4 = new HBox(boutiqueListView, acheterObjet);
        hBox4.setSpacing(10);

        HBox hBox5 = new HBox(new Text("Inventaire"), inventaireListView); // HBox pour afficher l'inventaire
        hBox5.setSpacing(10);

        VBox vBox = new VBox(hBox1, tachesListView, hBox2, hBox3, hBox4, argentText, hBox5); // Ajouter la hBox5 à la VBox
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Classe Tache
class Tache {
    private String titre;
    private boolean valide;

    public Tache(String titre) {
        this.titre = titre;
        this.valide = false;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    @Override
    public String toString() {
        return titre + (valide ? " (Validée)" : "");
    }
}

// Classe Objet
class Objet {
    private String nom;
    private int prix;

    public Objet(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return nom + " - " + prix + " €";
    }
}
