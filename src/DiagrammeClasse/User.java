package DiagrammeClasse;


public abstract class User {
    
    public String nom;

    public String prenom;

    public String adresse;

    public String telephone;

    public String email;

  public User(String nom,String prenom,String adresse,String telephone,String email){
    this.nom=nom;
    this.prenom=prenom;
    this.adresse=adresse;
    this.telephone=telephone;
    this.email=email;
    
  }

  public abstract String getid();
  public String getemail(){return email;}

  public String getPrenom(){
    return prenom;
  }

}

  
