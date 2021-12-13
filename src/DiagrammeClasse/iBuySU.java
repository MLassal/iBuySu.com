package DiagrammeClasse;


import java.util.ArrayList;
import java.util.List;

public class iBuySU {
    private static List<Acheteur> listacheteur = new ArrayList<Acheteur> ();
    private static List<Vendeur> listvendeur = new ArrayList<Vendeur> ();
    private static List<VenteDirecte> listventesdirectes = new ArrayList<VenteDirecte>();
    private static List<VenteEnchere> listventesencheres = new ArrayList<VenteEnchere>();
    private static List<Categorie> listcategories = new ArrayList<Categorie>();
    private static User currentUser = null;
    
    public void rechercher(final String objetRecherche) {
    }

    public void verifierRecherche() {
    }

    public static User getcurrentuser(){return currentUser;}
    
    public static String getrole(){
      if(currentUser==null){return "Visiteur";}
      //System.out.print(currentUser.getid().charAt(0));
      if(currentUser.getid().charAt(0)=='A'){
        //System.out.print(currentUser.getid().charAt(0));
        return "Acheteur";
      }
      if(currentUser.getid().charAt(0)=='V'){
        //System.out.print(currentUser.getid().charAt(0));
        return "Vendeur";
      }
      else return "Visiteur";
    
    }
    
    public static boolean demandeConnexion(String email, String mdp) {
      for(int i=0;i<listacheteur.size();i++){
        if(email.equals(listacheteur.get(i).getemail())){
          if(mdp.equals(listacheteur.get(i).getmdp())){
            currentUser=listacheteur.get(i);
            return true;
          }
        }
      }
      for(int i=0;i<listvendeur.size();i++){
        if(email.equals(listvendeur.get(i).getemail())){
          if(mdp.equals(listvendeur.get(i).getmdp())){
            currentUser=listvendeur.get(i);
            return true;
          }
        }
      }
      return false;
    }

    public void afficherMessage() {
    }

    public static void inscriptionVendeur(String nom,String prenom,String adresse,String telephone,String email,String mdp,String IBAN) {
      Vendeur vend=new Vendeur(nom,prenom,adresse,telephone,email,mdp,IBAN);
      listvendeur.add(vend);
    }

    public void enregistrerInfosVendeur() {
    }

    public void verfierInfoVendeur() {
    }

    public void verifierInfoAcheteur() {
    }

    public static void inscriptionAcheteur(String nom,String prenom,String adresse,String telephone,String email,String mdp) {
      Acheteur acht=new Acheteur(nom,prenom,adresse,telephone,email,mdp);
      listacheteur.add(acht);
    }

    public void enregistrerInfoAcheteur() {
    }

    public static void achatDirect(User user, Vente vente) {
      vente.getListeAcheteurs().add((Acheteur)user);
    }

    public void checkValeurEnchère() {
    }

    public static void encherir(int montant, VenteEnchere vente) {
      vente.ajouterEnchere(montant);
      vente.getListeAcheteurs().add((Acheteur)iBuySU.getcurrentuser());
      
    }

    public void évaluer() {
    }

    public static void creerVenteDirecte(String titre, String description, String categorie, int prix) {
      VenteDirecte ventedirecte = new VenteDirecte(titre, description, categorie, prix);
      listventesdirectes.add(ventedirecte);
      ((Vendeur)iBuySU.getcurrentuser()).getListeVentesDirectes().add(ventedirecte);
    }

    public static void creerVenteEncheres(String titre, String description, String categorie, int prix, int dureeVente) {
      VenteEnchere venteenchere = new VenteEnchere(titre, description, categorie, prix, dureeVente);
      listventesencheres.add(venteenchere);
      ((Vendeur)iBuySU.getcurrentuser()).getListeVentesEncheres().add(venteenchere);
    }

    public void accepterVente() {
    }

    public void demanderPaiement() {
    }

    public void refuserVente() {
    }

    public static boolean existCategorie(String nom){
      for(Categorie c : listcategories){
        if(nom.equals(c.getNom())){
          return true;
        }
      }
      return false;
    }

    public static void ajouterCategorie(String nom){
      if(existCategorie(nom)){
        System.out.println("Cette catégorie existe déjà.");
        return ;
      }
      Categorie c = new Categorie(nom);
      listcategories.add(c);
    }

    public static List<Vente> rechercheProduit(String key) {
      List<Vente> resultats = new ArrayList<Vente>();
      for(Vente vente : listventesdirectes){
        if(vente.getNom().contains(key)){
          resultats.add(vente);
        }
      }
      for(Vente vente : listventesencheres){
        if(vente.getNom().contains(key)){
          resultats.add(vente);
        }
      }
      return resultats;
    }

    public static List<Vente> rechercheProduit(Categorie categorie) {
      List<Vente> resultats = new ArrayList<Vente>();
      for(Vente vente : listventesdirectes){
        if(vente.getCategorie() == categorie.getNom()){
          resultats.add(vente);
        }
      }
      for(Vente vente : listventesencheres){
        if(vente.getCategorie() == categorie.getNom()){
          resultats.add(vente);
        }
      }
      return resultats;
    }


    public static List<VenteDirecte> getListVentesDirectes(){
      return listventesdirectes;
    }

    public static List<VenteEnchere> getListVentesEnchere(){
      return listventesencheres;
    }

    public static List<Vendeur> getListVendeurs(){
      return listvendeur;
    }
    public static List<Acheteur> getListAcheteurs(){
      return listacheteur;
    }
  
    

}
