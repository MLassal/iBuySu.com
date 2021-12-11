package DiagrammeClasse;

import java.util.ArrayList;
import java.util.List;

public class Vendeur extends User {
    public static int cpt=0;

    public String idVendeur;

    public String mdpVendeur;

    public double noteVendeur;

    public String IBAN;

    public List<Vente> listvente = new ArrayList<Vente> ();
    
    public Vendeur(String nom,String prenom,String adresse,String telephone,String email,String mdp,String IBAN){
      super(nom,prenom,adresse,telephone,email);
      this.mdpVendeur=mdp;
      this.IBAN=IBAN;
      cpt++;
      this.idVendeur="V"+cpt;
      this.noteVendeur=0;
    }
    public void miseAjourEvaluation() {
    }

    public String toString(){
      return "["+idVendeur+"] : "+nom+" "+prenom+" "+email;
    }
    public static int getcpt(){ return cpt;}
    public String getmdp(){return mdpVendeur;}
    
    public String getid(){return idVendeur;}

}
