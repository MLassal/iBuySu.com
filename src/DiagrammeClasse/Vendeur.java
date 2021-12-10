package DiagrammeClasse;

import java.util.ArrayList;
import java.util.List;

public class Vendeur extends User {
    public Vendeur(){
        
    }
    public String idVendeur;

    public String mdpVendeur;

    public String noteVendeur;

    public List<Vente> listvendeur = new ArrayList<Vente> ();

    public void miseAjourEvaluation() {
    }

}
