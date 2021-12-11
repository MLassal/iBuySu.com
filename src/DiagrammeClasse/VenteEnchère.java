package DiagrammeClasse;


public class VenteEnchere extends Vente {
    public String dureeVente;

    public int montantEnchere;

    public VenteEnchere(String titre, String description, String categorie, int prix){
      super(titre, description, categorie, prix);
    }

}
