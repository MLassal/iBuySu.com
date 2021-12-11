package DiagrammeClasse;


import java.util.ArrayList;
import java.util.List;

public class iBuySU {
    public static List<Acheteur> listacheteur = new ArrayList<Acheteur> ();
    public static List<Vendeur> listvendeur = new ArrayList<Vendeur> ();
    public static List<VenteDirecte> listventesdirectes = new ArrayList<VenteDirecte>();
    public static List<VenteEnchère> listventesencheres = new ArrayList<VenteEnchère>();
    public static User currentUser = null;
    
    public void rechercher(final String objetRecherche) {
    }

    public void verifierRecherche() {
    }

    public static User getcurrentuser(){return currentUser;}
    public static String getrole(){
      if(currentUser==null){return "Visiteur";}
      System.out.print(currentUser.getid().charAt(0));
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

    public void AchatDirect() {
    }

    public void checkValeurEnchère() {
    }

    public void enchérir() {
    }

    public void évaluer() {
    }

    public static void creerVenteDirecte(String titre, String description, String categorie, int prix) {
      VenteDirecte ventedirecte = new VenteDirecte(titre, description, categorie, prix);
      listventesdirectes.add(ventedirecte);
    }

    public static void creerVenteEncheres() {
    }

    public void accepterVente() {
    }

    public void demanderPaiement() {
    }

    public void refuserVente() {
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

}
