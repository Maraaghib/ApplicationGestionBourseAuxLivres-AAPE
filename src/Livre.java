public class Livre {
	private long id;
	private double prix;
	private int etat;
	private long reference;
	private boolean enStock;
	
	/** Constructor **/
	public Livre(){
		
	}
	public Livre (long id, double prix, int etat, long reference, boolean enStock){
		this.id = id;
		this.prix = prix;
		this.etat = etat;
		this.reference = reference;
		this.enStock = enStock;
	}

	/** Setteurs et getteurs **/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public long getReference() {
		return reference;
	}
	public void setReference(long reference) {
		this.reference = reference;
	}
	
	public boolean getEnStock() {
		return enStock;
	}
	public void setEnStock(boolean enStock) {
		this.enStock = enStock;
	}
	
	
	public Livre clone(){
		return new Livre(this.id, this.prix, this.etat, this.reference, this.enStock);
	}
	
	public boolean equals(Livre bis){
		return this.getPrix() == bis.getPrix() && this.getEtat() == bis.getEtat() && this.getReference() == this.getReference() && this.getEnStock() == bis.getEnStock();
	}
	
	public String toString(){
		return "Le livre de reference " + this.getReference() + " dans l'etat "+this.getEtat() +" et il "+this.getEnStock() +" en Stock";
	}
}