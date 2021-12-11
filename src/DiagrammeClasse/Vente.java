package DiagrammeClasse;


public abstract class Vente {
    public String titre;

    public String description;

    public String categorie;

    public int prix;

    public Vente(String titre, String description, String categorie, int prix){
      this.titre = titre;
      this.description = description;
      this.categorie = categorie;
      this.prix = prix;
    }

}
