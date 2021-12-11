package DiagrammeClasse;

import java.util.Scanner;

public class IHM {

    public void initialiserIHM(){ 
        System.out.println("...............BIENVENUE SUR IBUYSU.COM...........\n");
        System.out.println("Vous etes connectés en tant que "+iBuySU.getrole());
        System.out.println("1 : Rechercher un article");
        System.out.println("2 : S'inscrire en tant que Vendeur");
        System.out.println("3 : S'inscrire en tant qu'Acheteur");
        System.out.println("4 : Se connecter");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch(x){
          case 1:
            rechercheProduitIHM();
            break;
          case 2:
            InscriptionVendeurIHM();
            break;
          case 3:
            InscriptionAcheteurIHM();
            break;
          case 4:
            demandeConnexionIHM();
            break;
        }
        
    }
    public void creerVenteDirecteIHM() {
      System.out.println("...................Creer une vente directe..................\n");
      System.out.print("Saisissez le titre de la vente");
      Scanner sc = new Scanner(System.in);
      String titre = sc.nextLine();
      System.out.print("Saisissez la description de la vente");
      String description = sc.nextLine();
      System.out.println("Saisissez la categorie du produit");
      String categorie = sc.nextLine();
      System.out.println("Saisissez le prix du produit");
      int prix = sc.nextInt();
      iBuySU.creerVenteDirecte(titre, description, categorie, prix);
    }

    public void creerVenteEncheresIHM() {
    }

    public void demandeConnexionIHM() {
      System.out.println("...................CONNEXION..................\n");
      System.out.print("Saisissez vote email : ");
      Scanner sc = new Scanner(System.in);
      String email = sc.nextLine();
      System.out.print("Saisissez votre mot de passe : ");
      String mdp = sc.nextLine();
      boolean resultatVerification=iBuySU.demandeConnexion(email,mdp);
      if(resultatVerification){
        System.out.print(" Connexion reussie \n");
        System.out.println(iBuySU.getcurrentuser());
        initialiserIHM();
        }
      else{
        System.out.print(" Connexion échoué, veuillez vérifier les informations rentrés \n");
        initialiserIHM();
      }

    }

    public void afficherMessageIHM() {
    }

    public void laisserEvaluationVendeurIHM() {
    }

    public void laisserEvaluationAcheteurIHM() {
    }

    public void InscriptionAcheteurIHM() {
      System.out.println("...............INSCRIPTION ACHETEUR...........\n");
      System.out.print("Entrez votre nom : ");
      Scanner sc = new Scanner(System.in);
      String nom = sc.nextLine();
      System.out.print("Entrez votre prénom : ");
      String prenom = sc.nextLine();
      System.out.print("Entrez votre adresse : ");
      String adresse = sc.nextLine();
      System.out.print("Entrez votre téléphone : ");
      String telephone = sc.nextLine();
      System.out.print("Entrez votre email : ");
      String email = sc.nextLine();
      System.out.print("Entrez votre mot de passe : ");
      String mdp = sc.nextLine();
      iBuySU.inscriptionAcheteur(nom,prenom,adresse,telephone,email,mdp);
      if(nom==""||prenom==""||adresse==""||telephone==""||email==""){
        System.out.println("Merci d'entrer un caractère pour chaque information.");
        InscriptionAcheteurIHM();
        return ;
      }
      System.out.println("Inscription reussie");
      System.out.println(iBuySU.listacheteur.get((Acheteur.getcpt())-1));
      initialiserIHM();

    }
    
    public void InscriptionVendeurIHM() {
      System.out.println("...............INSCRIPTION VENDEUR...........\n");
      System.out.print("Entrez votre nom : ");
      Scanner sc = new Scanner(System.in);
      String nom = sc.nextLine();
      System.out.print("Entrez votre prénom : ");
      String prenom = sc.nextLine();
      System.out.print("Entrez votre adresse : ");
      String adresse = sc.nextLine();
      System.out.print("Entrez votre téléphone : ");
      String telephone = sc.nextLine();
      System.out.print("Entrez votre email : ");
      String email = sc.nextLine();
      System.out.print("Entrez votre mot de passe : ");
      String mdp = sc.nextLine();
      System.out.print("Entrez vos identifiants bancaire (IBAN) : ");
      String IBAN = sc.nextLine();
      iBuySU.inscriptionVendeur(nom,prenom,adresse,telephone,email,mdp,IBAN);
      System.out.println(iBuySU.listvendeur.get((Vendeur.getcpt())-1));
      System.out.println("Inscription reussi");
      initialiserIHM();
    }

    public void accepterVenteIHM() {
    }

    public void refuserVenteIHM() {
    }

    public void demandePaiementIHM() {
    }

    public void rechercheProduitIHM() {
    }

}
