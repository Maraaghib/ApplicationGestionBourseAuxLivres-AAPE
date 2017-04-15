import java.util.ArrayList;

public class Commande {
	private long id;
	private int classe;
	private boolean veuxUneCalculatrice;
	private ArrayList<Livre> listeLivre = new ArrayList<Livre>();
	
	/**Constructor*/
	public Commande(){
		
	}
	
	public Commande(long id, int classe, boolean veuxUneCalculatrice, ArrayList<Livre> liste){
		this.id = id;
		this.classe = classe;
		this.veuxUneCalculatrice = veuxUneCalculatrice;
		this.listeLivre = liste;
	}
	
	/**Controllers**/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public boolean getVeuxUneCalculatrice() {
		return veuxUneCalculatrice;
	}

	public void setVeuxUneCalculatrice(boolean veuxUneCalculatrice) {
		this.veuxUneCalculatrice = veuxUneCalculatrice;
	}

	public ArrayList<Livre> getListeLivre() {
		return listeLivre;
	}

	public void setListeLivre(ArrayList<Livre> listeLivre) {
		this.listeLivre = listeLivre;
	}

	public Livre getLivre(int indice){
		return this.listeLivre.get(indice);
	}

	public Commande clone(){
		return new Commande(this.id,this.classe,this.veuxUneCalculatrice,this.listeLivre);
	}
	
	public double facture(){
		double somme = 0;
		for(int i=0; i<listeLivre.size(); i++){
			somme += listeLivre.get(i).getPrix();
		}
		return somme;
	}
	

	public String toString(){
		StringBuffer s = new StringBuffer("Ceci est une commande pour un élève de classe de "+this.getClasse()+"et il désire la liste des livres suivants:");
		s.append("/n");
		for(int i=0; i<this.listeLivre.size(); i++){
			s.append(this.listeLivre.get(i).toString());
			s.append("/n");
		}
		
		if(getVeuxUneCalculatrice()){
		    s.append(" et il possède une calculatrice.");
		}
		else {
			s.append("il ne possède pas de calculatrice , et il en désire une.");
		}
		
		s.append("Le prix total de cette commande est de ");
		s.append(this.facture());
		return new String(s);
		
	}
	
}