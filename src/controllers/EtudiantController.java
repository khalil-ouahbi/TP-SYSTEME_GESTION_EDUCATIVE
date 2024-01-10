package controllers;

import MainPackage.Main;
import classes.Etudiant;
import classes.Filiere;
import services.EtudiantServices;

public class EtudiantController {

    public static void showMenu() {
        System.out.println("-------------------------[ Étudiants ]---------------------------");

        System.out.println("1: Pour ajouter un étudiant");
        System.out.println("2: Pour afficher les étudiants");
        System.out.println("3: Pour modifier un étudiant");
        System.out.println("4: Pour supprimer un étudiant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEtudiants() {
        for (Etudiant etudiant : EtudiantServices.getAllEtd()) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom());
            System.out.print(" | Prénom : " + etudiant.getPrenom());
            System.out.println("");
        }
    }

    public static void createEtudiant() {
        String nom = Main.getStringInput("Entrez le nom de l'étudiant :");
        String prenom = Main.getStringInput("Entrez le prénom de l'étudiant :");
        // Assuming email, apogee, and filiere are required fields
        String email = Main.getStringInput("Entrez l'email de l'étudiant :");
        int apogee = Main.getIntInput("Entrez l'apogée de l'étudiant :");
        // You may need to get the filiere details as needed
        // For now, let's assume that the filiere details are retrieved from another method
        Filiere filiere = getFiliereDetails();

        EtudiantServices.addEtd(nom, prenom, email, apogee, filiere);

        showEtudiants();
        showMenu();
    }

    public static void editEtudiant() {
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par id :");
        String nom = Main.getStringInput("Entrez le nouveau nom :");
        String prenom = Main.getStringInput("Entrez le nouveau prénom :");
        String email = Main.getStringInput("Entrez le nouvel email :");
        int apogee = Main.getIntInput("Entrez le nouvel apogée :");
        Filiere filiere = getFiliereDetails(); // Get filiere details as needed

        EtudiantServices.updateEtd(id, nom, prenom, email, apogee, filiere);

        showEtudiants();
        showMenu();
    }

    public static void destroyEtudiant() {
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par id :");
        EtudiantServices.deleteEtdById(id);
        showEtudiants();
    }

    private static Filiere getFiliereDetails() {
        // Implement this method to get filiere details as needed
        // For now, let's assume a placeholder implementation
        return new Filiere();
    }
}

