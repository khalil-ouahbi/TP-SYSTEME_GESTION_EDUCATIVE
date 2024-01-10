package controllers;



import classes.Enseignant;
import services.DB;

public class EnseignantController {

    public static void showMenu(){

    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );

//            if (! Main.isNull(departement.getChef())) {
//                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
//            }
            System.out.println("");
        }
    }
    public static void createEnseignant(){

    }
    public static void editEnseignant(){

    }
    public static void destroyEnseignant(){

    }
}

