import java.util.*;

public class Adherent {
	
	private long idAdherent;	
	private String prenom;
	private String nom;
	private String dateNaiss; // Format JJ/MM/AAAA
	private String telPerso;
	private String mailPerso ;
	private String classe;
	private String specialite;
	private String nomParaent;
	private String prenomParent;
	private String respLegal; // Responsable légal: Père || Mère || Autre (à préciser)
	private String adresse;
	private long codePostal;
	private String ville;
	private String telParent;
	private String participation; // Au conseil de classe || à la bourse aux libres || au conseil d'administration
	private String formule; // formule "de base" à 15€ || formule "soutien" à 25€ || formule "bienfaiteur" à 39€
	private double acompte; // (Si pas de reprise pour ectte commande)
	private double montant;
	private Commande commande;
	private String typeLivre; // Neuf || Excellent état type 2 || Etat moyen type 3 || Etat passable 4 || Etat très passable 5
	private int [] listeLivre; // Pourquoi pas ne pâs stocker que les ID des livres. De ce fait, pour afficher les livres, on fait livreDAO.selectById(idLivre[i])
	private String dateAdhesion;

	/**Constructors**/
	public Adherent(){
		
	}
	
	public Adherent(long idAdherent, String prenom, String nom, String dateNaiss, String telPerso, String mailPerso,
			String classe, String specialite, String nomParaent, String prenomParent, String respLegal, String adresse,
			long codePostal, String ville, String telParent, String participation, String formule, double acompte,
			double montant, Commande commande, String typeLivre, int[] listeLivre, String dateAdhesion) {

		this.idAdherent = idAdherent;
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaiss = dateNaiss;
		this.telPerso = telPerso;
		this.mailPerso = mailPerso;
		this.classe = classe;
		this.specialite = specialite;
		this.nomParaent = nomParaent;
		this.prenomParent = prenomParent;
		this.respLegal = respLegal;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telParent = telParent;
		this.participation = participation;
		this.formule = formule;
		this.acompte = acompte;
		this.montant = montant;
		this.commande = commande;
		this.typeLivre = typeLivre;
//		for (int i = 0; i < listeLivre.length; i++) {
			this.listeLivre = Arrays.copyOf(listeLivre, listeLivre.length);
//		}
		this.dateAdhesion = dateAdhesion;
	}

	
	
	
	public long getIdAdherent() {
		return idAdherent;
	}
	
	public void setIdAdherent(long idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getTelPerso() {
		return telPerso;
	}

	public void setTelPerso(String telPerso) {
		this.telPerso = telPerso;
	}

	public String getMailPerso() {
		return mailPerso;
	}

	public void setMailPerso(String mailPerso) {
		this.mailPerso = mailPerso;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getNomParaent() {
		return nomParaent;
	}

	public void setNomParaent(String nomParaent) {
		this.nomParaent = nomParaent;
	}

	public String getPrenomParent() {
		return prenomParent;
	}

	public void setPrenomParent(String prenomParent) {
		this.prenomParent = prenomParent;
	}

	public String getRespLegal() {
		return respLegal;
	}

	public void setRespLegal(String respLegal) {
		this.respLegal = respLegal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(long codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelParent() {
		return telParent;
	}

	public void setTelParent(String telParent) {
		this.telParent = telParent;
	}

	public String getParticipation() {
		return participation;
	}

	public void setParticipation(String participation) {
		this.participation = participation;
	}

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}

	public double getAcompte() {
		return acompte;
	}

	public void setAcompte(double acompte) {
		this.acompte = acompte;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public String getTypeLivre() {
		return typeLivre;
	}

	public void setTypeLivre(String typeLivre) {
		this.typeLivre = typeLivre;
	}

	public int[] getListeLivre() {
		return listeLivre;
	}

	public void setListeLivre(int[] listeLivre) {
		for (int i = 0; i < listeLivre.length; i++) {
			this.listeLivre[i] = listeLivre[i];
		}
	}
	
	public void addLivre(int livre) {
		this.listeLivre[this.listeLivre.length] = livre;
	}

	public String getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(String dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public double getPrixCommande() {
//		double somme = 0;
//		for(int i = 0; i < listeLivre.size(); i++){
//			somme += listeLivre.get(i).getPrix();
//		}
		
		return 160;//somme;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Adherent [idAdherent=");
		buffer.append(idAdherent);
		buffer.append(", prenom=");
		buffer.append(prenom);
		buffer.append(", nom=");
		buffer.append(nom);
		buffer.append(", dateNaiss=");
		buffer.append(dateNaiss);
		buffer.append(", telPerso=");
		buffer.append(telPerso);
		buffer.append(", mailPerso=");
		buffer.append(mailPerso);
		buffer.append(", classe=");
		buffer.append(classe);
		buffer.append(", specialite=");
		buffer.append(specialite);
		buffer.append(", nomParaent=");
		buffer.append(nomParaent);
		buffer.append(", prenomParent=");
		buffer.append(prenomParent);
		buffer.append(", respLegal=");
		buffer.append(respLegal);
		buffer.append(", adresse=");
		buffer.append(adresse);
		buffer.append(", codePostal=");
		buffer.append(codePostal);
		buffer.append(", ville=");
		buffer.append(ville);
		buffer.append(", telParent=");
		buffer.append(telParent);
		buffer.append(", participation=");
		buffer.append(participation);
		buffer.append(", formule=");
		buffer.append(formule);
		buffer.append(", acompte=");
		buffer.append(acompte);
		buffer.append(", montant=");
		buffer.append(montant);
		buffer.append(", commande=");
		if(commande != null)
		buffer.append(commande.toString());
		buffer.append(", typeLivre=");
		buffer.append(typeLivre);
		buffer.append(", listeLivre=");
		LivreDAO livreDAO = new LivreDAO();
		for (int i = 0; i < listeLivre.length; i++) {
			buffer.append(livreDAO.selectById(listeLivre[i]).toString());
		}
		buffer.append(listeLivre);
		buffer.append(", dateAdhesion=");
		buffer.append(dateAdhesion);
		buffer.append("]");
		return buffer.toString();
	}

	
//	public double facture(){
//		double somme = montant;
//		for(int i = 0; i < listeCommande.size(); i++){
//			somme += listeCommande.get(i).getPrixCommande();
//		}
//		return somme;
//	}

	

}