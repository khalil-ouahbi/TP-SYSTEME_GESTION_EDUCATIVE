import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Departement;
import classes.Enseignant;


public class Phase2 {


    public class main
    {
        public static void main(String[] args)
        {
            String dburl="jdbc:mysql://localhost:3306/prjjava";
            String username="root";
            String password="";
            try
            {
                Connection cx=DriverManager.getConnection(dburl,username,password);
                System.out.println("connecte avec succes");

                List<Enseignant> enseignants = getAllEns(cx);
         /*  //Affichage des enseignant

            System.out.println("Enseignants dans la base de donnees :");
            for (Enseignant enseignant : enseignants)
            {
                System.out.println(enseignant);
            }

          */
                //Affichage des departement
                List<Departement> departements = getAllDep(cx);
                System.out.println("Départements avant la suppression:");
                for (Departement departement : departements)
                {
                    System.out.println(departement);
                }
          /* //ajoutee un departement
            Enseignant specificEnseignant = enseignants.get(0);

            insertDept(service_departement.addDept("mathematique", specificEnseignant),cx);

            //Affichage des departement
            List<Departement> departements2 = getAllDep(cx);
            System.out.println("Départements apres l ajoute d un dept:");
            for (Departement departement : departements2)
            {
                System.out.println(departement);
            }*/

                //supprimer un departement
                supprimerDept(20,cx);
                //Affichage des departement
                List<Departement> departement = getAllDep(cx);
                System.out.println("Départements :");
                for (Departement departement1 : departement)
                {
                    System.out.println(departement1);
                }


            }
            catch (SQLException e)
            {
                System.out.println("une ereur s'est produit");
                e.printStackTrace();
            }

        }

        public static void createTabledep(Connection cx) throws SQLException
        {
            String query = "create table IF NOT EXISTS departement\n" +
                    "(\n" +
                    " id int primary key,\n" +
                    " nom varchar(50) charset utf8 null,\n" +
                    " enseignant int,\n" + // Supposant que enseignant_id est un champ de type int
                    " FOREIGN KEY (enseignant) REFERENCES enseignant (idens)\n" + // Correction du mot-clé 'FOREIGN' et du nom du champ
                    ")";

            Statement st =cx.createStatement();
            st.execute(query);
        }
        public static void insertDept(Departement departement, Connection cx) throws SQLException
        {

            String query="INSERT INTO departement(id,nom,enseignant) values(?,?,?)";
            PreparedStatement ps=cx.prepareStatement(query);
            ps.setInt(1, departement.getId());
            ps.setString(2,departement.getIntitule());
            ps.setInt(3,departement.getChef().getId());


            ps.executeUpdate();

        }
        public static void supprimerDept(int id,Connection cx) throws SQLException
        {
            String query="DELETE FROM departement where id=?";

            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();

        }
        public static List<Departement> getAllDep(Connection cx) throws SQLException
        {
            String query="SELECT * FROM departement";
            List<Departement> departements= new ArrayList<Departement>();
            Statement st= cx.createStatement();
            ResultSet r = st.executeQuery(query);

            while (r.next())
            {
                int idensg=r.getInt("enseignant");
                String nom=r.getString("nom");


            }


            return departements;
        }
        public static void createTable(Connection cx) throws SQLException
        {
            String query="create table IF NOT EXISTS enseignant\n"+"(\n"+
                    " idens int  primary key,\n"+
                    "nom varchar(50) charset utf8 null,\n"

                    +"prenom varchar(50) charset utf8 null,\n"
                    +"email varchar(100) charset utf8 null,\n"
                    +"grade varchar(100) charset utf8 null\n"

                    +")";
            Statement st =cx.createStatement();
            st.execute(query);
        }

        public static void insertEnse(Enseignant enseignant, Connection cx) throws SQLException
        {

            String query="INSERT INTO enseignant(idens,nom,prenom,email,grade) values(?,?,?,?,?)";
            PreparedStatement ps=cx.prepareStatement(query);



            ps.setString(4,enseignant.getEmail());
            ps.setString(5,enseignant.getGrade());


            ps.executeUpdate();

        }
        public static void supprimerEnsg(int id,Connection cx) throws SQLException
        {
            String query="DELETE FROM syst_gest_educat.etudiants where idens=?";

            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();

        }



        public static List<Enseignant> getAllEns(Connection cx) throws SQLException {
            String query = "SELECT * FROM enseignant";
            List<Enseignant> enseignants = new ArrayList<Enseignant>();
            Statement st = cx.createStatement();
            ResultSet r = st.executeQuery(query);

            while (r.next()) {



            }

            return enseignants;
        }}
/*public static List<Enseignant> suppEnsg(Connection cx)
{
    enseigcontrolleure.afficherEnsg();
    int id= Main.getIntInput("selectionner un enseignant par id");
    String query ="DELETE FROM enseignant WHERE idens=id";
}
}*/

}


