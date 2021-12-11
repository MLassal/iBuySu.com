package DiagrammeClasse;


public class VenteEnchère extends Vente {
    public String duréeVente;

    public int montantEnchère;

    public VenteEnchère(String titre, String description, String categorie, int prix){
      super(titre, description, categorie, prix);
  }

}
