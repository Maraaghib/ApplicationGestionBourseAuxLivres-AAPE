import java.util.ArrayList;

public class Commande {
	private long idCommande;
	private String dateCommande;
	public double prixCommande;
	private long idAdherent;
	private int[] idLivre;
	
	/**Constructor*/
	public Commande(){
		
	}

	public Commande(String dateCommande, double prixCommande, long idAdherent, int[] idLivre) {
		this.dateCommande = dateCommande;
		this.prixCommande = prixCommande;
		this.idAdherent = idAdherent;
		this.idLivre = idLivre;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public void setPrixCommande(double prixCommande) {
		this.prixCommande = prixCommande;
	}

	public long getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(long idAdherent) {
		this.idAdherent = idAdherent;
	}

	public int[] getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int[] idLivre) {
		for (int i = 0; i < idLivre.length; i++) {
			this.idLivre[i] = idLivre[i];
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Commande [idCommande=");
		buffer.append(idCommande);
		buffer.append(", dateCommande=");
		buffer.append(dateCommande);
		buffer.append(", prixCommande=");
		buffer.append(prixCommande);
		buffer.append(", idAdherent=");
		buffer.append(idAdherent);
//		buffer.append(", idLivre=");
//		buffer.append(idLivre);
		buffer.append("]");
		return buffer.toString();
	}

	
	
	
	
	
	

	
	
}