package DiagrammeClasse;

import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class IHM {

    public void initialiserIHM(){ 
        //Menu Visiteur
        if(iBuySU.getrole() == "Visiteur"){
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
        //Menu Vendeur
        if(iBuySU.getrole() == "Vendeur"){
          System.out.println("...............Vous etes connecte en tant que vendeur...........\n");
          System.out.println("1 : Creer une vente directe");
          System.out.println("2 : Creer une vente aux encheres");
          System.out.println("3 : Consulter mes ventes directes");
          System.out.println("4 : Consulter mes ventes aux encheres");
          Scanner sc = new Scanner(System.in);
          int x = sc.nextInt();
          switch(x){
            case 1:
              creerVenteDirecteIHM();
              break;
            case 2:
              creerVenteEncheresIHM();
              break;
            case 3:
              consulterVenteDirecteVendeurIHM((Vendeur)iBuySU.getcurrentuser());
              break;
            case 4:
              consulterVenteEnchereVendeurIHM((Vendeur)iBuySU.getcurrentuser());
              break;
          }
        }

        //Menu Acheteur
        if(iBuySU.getrole() == "Acheteur"){
          System.out.println("...............Vous etes connecte en tant qu'acheteur...........\n");
          System.out.println("1 : Rechercher un article");
          Scanner sc = new Scanner(System.in);
          int x = sc.nextInt();
          switch(x){
            case 1:
              rechercheProduitIHM();
              break;
            case 2:

              break;
            case 3:
      
              break;
            case 4:
      
              break;
          }
        }
        
        
    }

    

    public void creerVenteDirecteIHM() {
      System.out.println("...................CREER UNE VENTE DIRECTE..................\n");
      System.out.print("Saisissez le titre de la vente : ");
      Scanner sc = new Scanner(System.in);
      String titre = sc.nextLine();
      System.out.print("Saisissez la description de la vente : ");
      String description = sc.nextLine();
      System.out.print("Saisissez la categorie du produit : ");
      String categorie = sc.nextLine();
      while(!iBuySU.existCategorie(categorie)){
        System.out.println("Cette catégorie n'existe pas !");
        System.out.print("Saisissez la categorie du produit : ");
        categorie = sc.nextLine();
      }
      System.out.print("Saisissez le prix du produit : ");
      int prix = sc.nextInt();
      iBuySU.creerVenteDirecte(titre, description, categorie, prix);
    }

    public void afficherVentesDirectes(){
      System.out.println("...................Voici la liste de vos ventes directes..................");
    }

    public void creerVenteEncheresIHM() {
      System.out.println("...................CREER UNE VENTE AUX ENCHERES..................\n");
      System.out.print("Saisissez le titre de la vente : ");
      Scanner sc = new Scanner(System.in);
      String titre = sc.nextLine();
      System.out.print("Saisissez la description de la vente : ");
      String description = sc.nextLine();
      System.out.print("Saisissez la categorie du produit : ");
      String categorie = sc.nextLine();
      while(!iBuySU.existCategorie(categorie)){
        System.out.println("Cette catégorie n'existe pas !");
        System.out.print("Saisissez la categorie du produit : ");
        categorie = sc.nextLine();
      }
      System.out.print("Saisissez le prix du produit : ");
      int prix = sc.nextInt();
      System.out.print("Saisissez la duree de la vente : ");
      int dureeVente = sc.nextInt();
      iBuySU.creerVenteEncheres(titre, description, categorie, prix, dureeVente);
    }

    public void demandeConnexionIHM() {
      System.out.println("...................CONNEXION..................\n");
      System.out.print("Saisissez votre email : ");
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
        System.out.print(" Connexion échouée, veuillez vérifier les informations rentrées \n");
        initialiserIHM();
      }

    }

    public void afficherMessageIHM() {
    }

    
    public void laisserEvaluationVendeurIHM(Vendeur vendeur){
      System.out.println("...........EVALUATION...........\n");
      System.out.print("Laissez une note au vendeur (De 0 à 5) : ");
      Scanner sc = new Scanner(System.in);
      boolean error;
      double note = 0.0;
      do{
        try{
          note = Math.round(sc.nextDouble()*100)/100.0;
          if(note<0||note>5){
            error = true;
          }
          else{
            error = false;
          }
        }
        catch(Exception e){
          System.out.println("Merci d'entrer un nombre entre 0 et 5.");
          error = true;
        }
      }while(error);
      vendeur.miseAjourEvaluation(note);
      initialiserIHM();
      return ;
      
    }

    public void laisserEvaluationAcheteurIHM(Acheteur acheteur){
      System.out.println("...........EVALUATION...........\n");
      System.out.print("Laissez une note à l'acheteur (De 0 à 5) : ");
      Scanner sc = new Scanner(System.in);
      boolean error;
      double note = 0.0;
      do{
        try{
          note = Math.round(sc.nextDouble()*100)/100.0;
          if(note<0||note>5){
            error = true;
          }
          else{
            error = false;
          }
        }
        catch(Exception e){
          System.out.println("Merci d'entrer un nombre entre 0 et 5.");
          error = true;
        }
      }while(error);
      acheteur.miseAjourEvaluation(note);
      initialiserIHM();
      return ;
    }

    public void InscriptionAcheteurIHM() {
      System.out.println("\n\n\n");
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
      if(nom==""||prenom==""||adresse==""||telephone==""||email==""){
        System.out.println("Merci d'entrer au moins un caractère pour chaque information.");
        InscriptionAcheteurIHM();
        return ;
      }
      iBuySU.inscriptionAcheteur(nom,prenom,adresse,telephone,email,mdp);
      System.out.println("Inscription reussie");
      System.out.println(iBuySU.getListAcheteurs().get((Acheteur.getcpt())-1));
      initialiserIHM();

    }
    
    public void InscriptionVendeurIHM() {
      System.out.println("\n\n\n");
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
      if(nom==""||prenom==""||adresse==""||telephone==""||email==""){
        System.out.println("Merci d'entrer au moins un caractère pour chaque information.");
        InscriptionVendeurIHM();
        return ;
      }
      iBuySU.inscriptionVendeur(nom,prenom,adresse,telephone,email,mdp,IBAN);
      System.out.println(iBuySU.getListVendeurs().get((Vendeur.getcpt())-1));
      System.out.println("Inscription reussie");
      initialiserIHM();
    }

    public void accepterVenteIHM(Vente vente, Acheteur acheteur) {
      vente.statutFinalisee();
      System.out.println("..............PROPOSITION ACCEPTEE..............");
      System.out.println("Felicitations, vous avez accepte la proposition de "+acheteur.getPrenom()+" !");
    }

    public void refuserVenteIHM() {
    }

    public void demandePaiementIHM() {
    }

    public void rechercheProduitIHM() {
      System.out.println("\n\n\n");
      System.out.println("..............RECHERCHE..............");
      System.out.println("\nChoisissez un mode de recherche : ");
        System.out.println("\n0 - Menu Principal");
        System.out.println("1 - Recherche par mots clés");
        System.out.println("2 - Recherche par catégorie");
        System.out.print("\nEntrez le numéro correspondant à l'option souhaitée : ");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
      while(choix!=0&&choix!=1&&choix!=2){
        System.out.print("Merci d'entrer un numéro compris entre 0 et 2 : ");
        choix = sc.nextInt();
      }
      switch(choix){
        case 0 :
          initialiserIHM();
          return ;
        case 1 :
          System.out.print("\nEntrez un mot clé : ");
          sc = new Scanner(System.in);
          String key = sc.nextLine();
          List<Vente> resultats = iBuySU.rechercheProduit(key);
          if(resultats.size()==0){
            System.out.println("\nAucun article ne correspond.\n");
            System.out.println("Appuyez sur une Entrée pour revenir sur le menu principal.");
            sc.nextLine();
            initialiserIHM();
            return ;
          }
          System.out.println("Voici les résultats de votre recherche : ");
          System.out.println("\n0 - Menu principal");
          for(Vente vente : resultats){
            System.out.println((resultats.indexOf(vente)+1)+" - "+vente.getNom()+" - "+vente.getPrix()+"€");
          }
          System.out.print("\nSaisissez le numéro de l'article que vous souhaitez consulter : ");
          choix = sc.nextInt();
          while(choix<0||choix>resultats.size()){
            System.out.print("\nMerci d'entrer un numéro compris entre 0 et "+resultats.size()+" : ");
            choix = sc.nextInt();
          }
          if(choix == 0){
            initialiserIHM();
            return ;
          }
          afficherVente(resultats.get(choix-1));
          return; 
        case 2 :
          //choix des catégories
          System.out.println("\nVoici les catégories disponibles : ");
          System.out.println("\n0 - Menu Principal");
          for(Categorie c : iBuySU.getlistcategories()){
            System.out.println((iBuySU.listcategories.indexOf(c)+1)+" - "+c.getNom());
          }
          System.out.print("\nChoisissez le numéro correspondant à la catégorie souhaitée : ");
          sc = new Scanner(System.in);
          choix = sc.nextInt();
          while(choix<0||choix>iBuySU.listcategories.size()){
            System.out.print("\nMerci d'entrer un numéro compris entre 0 et "+iBuySU.listcategories.size()+" : ");
            choix = sc.nextInt();
          }
          if(choix==0){
            initialiserIHM();
            return ;
          }
          Categorie categorie = iBuySU.listcategories.get(choix-1);
          //choix de la vente
          resultats = iBuySU.rechercheProduit(categorie);
          if(resultats.size()==0){
            System.out.println("\nAucun article ne correspond."+categorie.getNom()+iBuySU.listventesdirectes.get(0).getCategorie()+"\n");
            System.out.println("Appuyez sur une Entrée pour revenir sur le menu principal.");
            sc = new Scanner(System.in);
            sc.nextLine();
            initialiserIHM();
            return ;
          }
          System.out.println("Voici les articles de catégorie \""+categorie.getNom()+"\" : ");
          System.out.println("0 - Menu Principal");
          for(Vente vente : resultats){
            System.out.println((resultats.indexOf(vente)+1)+" - "+vente.getNom()+" - "+vente.getPrix()+"€");
          }
          System.out.print("\nSaisissez le numéro de l'article que vous souhaitez consulter : ");
          choix = sc.nextInt();
          while(choix<0||choix>resultats.size()){
            System.out.print("Merci d'entrer un numéro compris entre 0 et "+resultats.size()+" : ");
            choix = sc.nextInt();
          }
          if(choix == 0){
            initialiserIHM();
            return ;
          }
          afficherVente(resultats.get(choix-1));
          return;
      }
    }

    public void afficherVente(Vente vente){
      System.out.println("\n\n\n");
      System.out.println("..........FICHE PRODUIT..........\n");

      System.out.println("STATUT DE LA VENTE : "+vente.getStatut()+"\n");


      System.out.println("Titre : "+vente.getNom()+"\n");
      System.out.println("Catégorie : "+vente.getCategorie()+"\n");
      if(vente instanceof VenteDirecte){
        System.out.println("Prix : "+vente.getPrix()+"€\n");
      } else {
        System.out.println("Prix de départ : "+vente.getPrix()+"€");
        System.out.println("Prix actuel : "+(((VenteEnchere) vente).getMontantEnchere())+"€\n");
      }
      
      
      System.out.println("Description : "+vente.getDescription()+"\n");

      if(iBuySU.getrole() == "Vendeur" && vente.getStatut() == "Disponible"){ 
        System.out.println("Voici les acheteurs ayant fait une proposition d'achat : \n");
        for(Acheteur acheteur : vente.getListeAcheteurs()){
         System.out.println((vente.getListeAcheteurs().indexOf(acheteur)+1)+" - "+acheteur.getPrenom());
        }
        System.out.println("Pour accepter la proposition d'un utilisateur, saisissez le numero correspondant : ");
        Scanner scan = new Scanner(System.in);
        int choix = scan.nextInt();
        accepterVenteIHM(vente, vente.getListeAcheteurs().get(choix-1));
        
      }
      
      if(iBuySU.getrole() == "Acheteur" && vente.getStatut() == "Disponible" && vente instanceof VenteDirecte){
        System.out.println("\n0 : Retour");
        System.out.println("1 : Acheter");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch(x){
            case 0:
              initialiserIHM();
              break;
            case 1:
              achatDirectIHM(vente);
              break;
          }
      }

      if(iBuySU.getrole() == "Acheteur" && vente.getStatut() == "Disponible" && vente instanceof VenteEnchere){
        System.out.println("\n0 : Retour");
        System.out.println("1 : Encherir");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch(x){
            case 0:
              initialiserIHM();
              break;
            case 1:
              encherirIHM((VenteEnchere)vente);
              break;
          }
      }
    }

    public void encherirIHM(Vente vente){
        System.out.println("\n\n\n");
        System.out.println("..........ENCHERIR..........\n");
        System.out.println("Entrez le montant de votre enchère : ");
        Scanner sc = new Scanner(System.in);
        int montant = sc.nextInt();
        iBuySU.encherir(montant, (VenteEnchere) vente);
        initialiserIHM();
    }

    public void achatDirectIHM(Vente vente){
      iBuySU.achatDirect(iBuySU.getcurrentuser(), vente);
      System.out.println("\n\n\n");
      System.out.println("..........PROPOSITION D'ACHAT..........\n");
      System.out.println("Votre proposition d'achat a ete transmise au vendeur !");
      System.out.println("Ce dernier a le choix d'accepter ou de refuser votre offre");
      initialiserIHM();
    }

    public void consulterVenteDirecteVendeurIHM(Vendeur vendeur){
      System.out.println("\n\n\n");
      System.out.println("..........MES VENTES DIRECTES..........\n");
      System.out.println("Voici une liste de vos ventes directes : ");
      for(Vente vente : vendeur.getListeVentesDirectes()){
        System.out.println((vendeur.getListeVentesDirectes().indexOf(vente)+1)+" - "+vente.getNom());
      }
      Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        afficherVente(vendeur.getListeVentesDirectes().get(choix-1));
    }

    public void consulterVenteEnchereVendeurIHM(Vendeur vendeur){
      System.out.println("\n\n\n");
      System.out.println("..........MES VENTES AUX ENCHERES..........\n");
      System.out.println("Voici une liste de vos ventes aux encheres : ");
      for(Vente vente : vendeur.getListeVentesEncheres()){
        System.out.println((vendeur.getListeVentesEncheres().indexOf(vente)+1)+" - "+vente.getNom());
      }
      Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        afficherVente(vendeur.getListeVentesEncheres().get(choix-1));
    }

}
