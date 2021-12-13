package DiagrammeClasse;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Vendeur extends User {
    private static int cpt=0;

    private String idVendeur;

    private String mdpVendeur;

    private List<Double> notesVendeur = new ArrayList<Double>();

    private String IBAN;

    private List<Vente> listeventesdirectes = new ArrayList<Vente> ();

    private List<Vente> listeventesencheres = new ArrayList<Vente> ();
    
    public Vendeur(String nom,String prenom,String adresse,String telephone,String email,String mdp,String IBAN){
      super(nom,prenom,adresse,telephone,email);
      this.mdpVendeur=mdp;
      this.IBAN=IBAN;
      cpt++;
      this.idVendeur="V"+cpt;
    }
    public void miseAjourEvaluation(double note) {
      notesVendeur.add(note);

    }

    public String toString(){
      return "["+idVendeur+"] : "+nom+" "+prenom+" "+email;
    }
    public static int getcpt(){ return cpt;}
    public String getmdp(){return mdpVendeur;}
    
    public String getid(){return idVendeur;}

    public double moyenneNote(){
      if(notesVendeur.size()==0){
        return 0.0;
      }
      double s = 0;
      for(double note : notesVendeur){
        s += note;
      }
      return Math.round((s/notesVendeur.size())*100)/100.0;
    }

    public List<Vente> getListeVentesDirectes(){
      return listeventesdirectes;
    }

    public List<Vente> getListeVentesEncheres(){
      return listeventesencheres;
    }

}
