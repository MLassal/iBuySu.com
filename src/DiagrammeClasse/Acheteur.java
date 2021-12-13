package DiagrammeClasse;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Acheteur extends User {
    private static int cpt=0;

    private String idAcheteur;

    private String mdpAcheteur;

    private List<Double> notesAcheteur = new ArrayList<Double> ();
    
  public Acheteur(String nom,String prenom,String adresse,String telephone,String email,String mdp){
      super(nom,prenom,adresse,telephone,email);
      this.mdpAcheteur=mdp;
      cpt++;
      this.idAcheteur="A"+cpt;
  }

  public static int getcpt(){ return cpt;}
  public String getid(){return idAcheteur;}
  public String getemail(){return email;}
  public String getmdp(){return mdpAcheteur;}

  public void miseAjourEvaluation(double note) {
    notesAcheteur.add(note);
  }

  public double moyenneNote(){
      if(notesAcheteur.size()==0){
        return 0.0;
      }
      double s = 0;
      for(double note : notesAcheteur){
        s += note;
      }
      return Math.round((s/notesAcheteur.size())*100)/100.0;
    }
    
  public String toString(){
      return "["+idAcheteur+"] : "+nom+" "+prenom+" "+email;
    }
  
}
