package DiagrammeClasse;
import java.util.Scanner;

public class IHM {

    public static void initialiserIHM(){ 
        System.out.println("...............BIENVENUE SUR IBUYSU.COM...........\n");
        System.out.println("Vous etes connectés en tant que USER");
        System.out.println("1 : Rechercher un article");
        System.out.println("2 : S'inscrire en tant que Vendeur");
        System.out.println("3 : S'inscrire en tant qu'Acheteur");
        System.out.println("4 : Se connecter");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(x);
        
    }
    public void creerVenteDirecteIHM() {
    }

    public void creerVenteEncheresIHM() {
    }

    public void demandeConnexionIHM() {
    }

    public void afficherMessageIHM() {
    }

    public void laisserEvaluationVendeurIHM() {
    }

    public void laisserEvaluationAcheteurIHM() {
    }

    public void demandeInscriptionAcheteurIHM() {
    }

    public void accepterVenteIHM() {
    }

    public void refuserVenteIHM() {
    }

    public void demandePaiementIHM() {
    }

    public void rechercheProduitIHM() {
    }

    public static void main(String[] args){
        initialiserIHM();
    }
}
