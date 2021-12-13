package DiagrammeClasse;


public class VenteEnchere extends Vente {
    private int dureeVente;

    private int montantEnchere;

    public VenteEnchere(String titre, String description, String categorie, int prix, int dureeVente){
      super(titre, description, categorie, prix);
      this.dureeVente = dureeVente;
      this.montantEnchere = prix;
    }

    public void ajouterEnchere(int montant){
      montantEnchere += montant;
    }

    public int getMontantEnchere(){
      return montantEnchere;
    }
    

}
