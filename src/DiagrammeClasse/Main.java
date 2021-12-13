package DiagrammeClasse;

public class Main{
    public static void main(String[] args){

      Vendeur VendeurTest = new Vendeur("Uzumaki","Naruto","konoha","1234","narutorazengan@gmail.com","hinata","1456");
      
      iBuySU.getListVendeurs().add(VendeurTest);

      Acheteur acheteurTest = new Acheteur("Haruno","Sakura","Konoha","06","sakurarose@gmail.com","kunai123");
      iBuySU.getListAcheteurs().add(acheteurTest);

      iBuySU.ajouterCategorie("Stylo");
      iBuySU.ajouterCategorie("Console");   
      iBuySU.ajouterCategorie("Chaussure"); 

      VenteDirecte styloRouge = new VenteDirecte("Vend stylo rouge parfait etat", "le stylo est vla bien", "Stylo", 2);

      VenteDirecte styloBleu = new VenteDirecte("Vend stylo bleu plus d'encre", "le stylo est vla bien mais ya plus dencre", "Stylo", 4);

      VenteEnchere nintendo = new VenteEnchere("Vend nintendo switch rouge", "très peu utilisée", "Console", 200, 5);

      VendeurTest.getListeVentesEncheres().add(nintendo);
      iBuySU.getListVentesEnchere().add(nintendo);


      VendeurTest.getListeVentesDirectes().add(styloRouge);
      VendeurTest.getListeVentesDirectes().add(styloBleu);

      iBuySU.getListVentesDirectes().add(styloRouge);
      iBuySU.getListVentesDirectes().add(styloBleu);

      iBuySU.achatDirect(acheteurTest, styloRouge);
      
      IHM ihm = new IHM();
      //ihm.laisserEvaluationVendeurIHM();
      ihm.initialiserIHM();

    }
}
