package DiagrammeClasse;
import java.util.ArrayList;
import java.util.List;


public abstract class Vente {
    private String titre;

    private String description;

    private String categorie;

    private int prix;

    private List<Acheteur> listeacheteurs = new ArrayList<Acheteur>();

    private String statut = "Disponible";


    public Vente(String titre, String description, String categorie, int prix){
      this.titre = titre;
      this.description = description;
      this.prix = prix;
      this.categorie = categorie;
      
    }

    public String getNom(){
      return titre;
      }
    
    public int getPrix(){
      return prix;
      }

    public String getDescription(){
      return description;
    }

    public List<Acheteur> getListeAcheteurs(){
      return listeacheteurs;
    }

    public void statutFinalisee(){
      this.statut = "Finalisee";
    }

    public String getStatut(){
      return statut;
    }

    public String getCategorie(){
      return categorie;
    }

}
