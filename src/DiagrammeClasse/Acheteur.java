package DiagrammeClasse;

public class Acheteur extends User {
    public static int cpt=0;

    public String idAcheteur;

    public String mdpAcheteur;

    public double noteAcheteur;
    
  public Acheteur(String nom,String prenom,String adresse,String telephone,String email,String mdp){
      super(nom,prenom,adresse,telephone,email);
      this.mdpAcheteur=mdp;
      cpt++;
      this.idAcheteur="A"+cpt;
      this.noteAcheteur=0;
  }

  public static int getcpt(){ return cpt;}
  public String getid(){return idAcheteur;}
  public String getemail(){return email;}
  public String getmdp(){return mdpAcheteur;}

  public void miseAjourEvaluation() {
  }
    
  public String toString(){
      return "["+idAcheteur+"] : "+nom+" "+prenom+" "+email;
    }
  
}
