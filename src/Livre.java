

public class Livre {
	
	private int idLivre;
	private String designation;
	private double prix;
	private int etat;
	private int reference;
	private byte enStock; // 0 ou 1
	
	/** Constructor **/
	public Livre(){
		
	}

	public Livre(int idLivre, String designation, double prix, int etat, int reference, byte enStock) {
		this.idLivre = idLivre;
		this.designation = designation;
		this.prix = prix;
		this.etat = etat;
		this.reference = reference;
		this.enStock = enStock;
	}

	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public byte isEnStock() {
		return enStock;
	}

	public void setEnStock(byte enStock) {
		this.enStock = enStock;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Livre [idLivre=");
		buffer.append(idLivre);
		buffer.append(", designation=");
		buffer.append(designation);
		buffer.append(", prix=");
		buffer.append(prix);
		buffer.append(", etat=");
		buffer.append(etat);
		buffer.append(", reference=");
		buffer.append(reference);
		buffer.append(", enStock=");
		buffer.append(enStock);
		buffer.append("]");
		return buffer.toString();
	}
}