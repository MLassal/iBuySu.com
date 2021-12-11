package DiagrammeClasse;


import java.util.ArrayList;
import java.util.List;

public class iBuySU {
    public static List<Acheteur> listacheteur = new ArrayList<Acheteur> ();
    public static List<Vendeur> listvendeur = new ArrayList<Vendeur> ();
    public static List<Vente> listventes = new ArrayList<Vente>();
    public static User currentUser = null;
    
    public void rechercher(final String objetRecherche) {
    }

    public void verifierRecherche() {
    }

    public static User getcurrentuser(){return currentUser;}
    public String getrole(){
    return "";
    }
    public static boolean demandeConnexion(String email, String mdp) {
      for(int i=0;i<listacheteur.size();i++){
        if(email==listacheteur.get(i).getemail()){
          System.out.print("Email trouver !");
          if(listacheteur.get(i).getmdp()==mdp){
             System.out.print("Mot de passe bon !");
            currentUser=listacheteur.get(i);
            return true;
          }
        }
      }
      for(int i=0;i<listvendeur.size();i++){
        if(email==listvendeur.get(i).getemail()){
          System.out.print("Email trouver !");
          if(listacheteur.get(i).getmdp()==mdp){
            System.out.print("Mot de passe bon !");
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

    public static void créerVenteDirecte() {
      
    }

    public void créerVenteEnchères() {
    }

    public void accepterVente() {
    }

    public void demanderPaiement() {
    }

    public void refuserVente() {
    }

    public void rechercheProduit() {
    }

}
