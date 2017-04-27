import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AdherentDAO adherentDAO = new AdherentDAO();
		CommandeDAO commandeDAO = new CommandeDAO();
		LivreDAO livreDAO = new LivreDAO();
		double prixCommande = 0;



		String[] month = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aoû»t", "Septembre", "Octobre", "Novembre", "Décembre"};
		String[] day = {"Samedi", "Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};


		Calendar calendar = Calendar.getInstance();
		StringBuffer dateTimeTodayBuffer = new StringBuffer();
		dateTimeTodayBuffer.append(day[calendar.get(Calendar.DAY_OF_WEEK)]+" ");
		dateTimeTodayBuffer.append(calendar.get(Calendar.DAY_OF_MONTH)+" ");
		dateTimeTodayBuffer.append(month[calendar.get(Calendar.MONTH)]+" ");
		dateTimeTodayBuffer.append(calendar.get(Calendar.YEAR)+ " ");
		dateTimeTodayBuffer.append("à  "+calendar.get(Calendar.HOUR_OF_DAY)+":");
		dateTimeTodayBuffer.append(calendar.get(Calendar.MINUTE)+":");
		dateTimeTodayBuffer.append(calendar.get(Calendar.SECOND));

		String dateTimeToday = dateTimeTodayBuffer.toString();
		String dateAdhesion = dateTimeToday;
		String dateCommande = dateTimeToday;


		adherentDAO.createTable();
		commandeDAO.createTable();
		livreDAO.createTable();


		long idAdherent = 2018;

		String prenom = "Mon Prénom";

		String nom = "Mon nom";

		String dateNaiss = "01/01/1900";

		String telPerso = "0123456789";

		String mailPerso = "adresse@outlook.fr";

		String classe = "Licence";

		String specialite = "Informatique";

		String nomParaent = "Son nom";

		String prenomParent = "Son Préonm";

		String respLegal = "Mon responsable";

		String adresse = "27 rue François Mitterand";

		long codePostal = 33000;

		String ville = "Bordeaux";

		String telParent = "0987654321";

		String participation = "Bourse aux livres";

		String formule = "Bienfaiteur";

		double acompte = 40;

		double montant = 39;

		String typeLivre = "Neuf";

		int listeLivre[] = {0, 1, 2, 3, 5, 10, 11};


		/****************** STOCKER DES LIVRES DANS LA BASE DE DONNEES *******************/

		/*
		int listeLivre1[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}; // Les id des livres à  ajouter dans le stock
		for (int i = 0; i < listeLivre1.length; i++) {
			Livre livre = new Livre(listeLivre1[i], "designation"+i, (i*100), i+1, i*73, (byte)1);
			// livre.toString();
			livreDAO.insert(livre);
		}
		//*/

		/******************* RECUPERER DES LIVERS DEPUIS LA BASE DE DONNEES VIA LEURS ID ET LES AFFICHER *******************/

		/*
		int listeLivre2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}; // Les livres à  ajouter dans le stock

		for (int i = 0; i < listeLivre2.length; ++i) {
			Livre livre = livreDAO.selectById(listeLivre2[i]); // Récupérer le livre depuis la base de données
			System.out.println(livre.toString());
			prixCommande += livre.getPrix(); // Calculer le prix de la commande
		}
		//*/


		Commande commande = new Commande(dateCommande, prixCommande, idAdherent, listeLivre);

		Adherent adherent = new Adherent(idAdherent, prenom, nom, dateNaiss, telPerso, mailPerso, classe, specialite, nomParaent, prenomParent, respLegal, adresse, codePostal, ville, telParent, participation, formule, acompte, montant, commande, typeLivre, listeLivre, dateAdhesion);


		/******************* ENREGISTREMENT D'UN NOUVEL ADHERENT *******************/

		/*
		boolean test = adherentDAO.insert(adherent);
		if(test) {
			System.out.println("Enregistrement effectué avec succès !");
		}
		else{
			System.out.println("L'enregistrement a échoué !");
		}
		//*/

		
		/******************* AFFICHER  TOUS LES ADHERENTS ET LEURS INFOS *******************/

		//*
		ArrayList<Adherent> listeAdherent = new ArrayList<Adherent>();
		listeAdherent = adherentDAO.selectAll();
		for (int i = 0; i < listeAdherent.size(); i++) {
			Adherent adherent2 = listeAdherent.get(i);
			System.out.println(adherent2.toString());
			System.out.println();
		}
		
		
		//*/
		
		/******************* RECUPERER UN ADHERENT VIA SON ID PUIS AFFICHER SES INFOS *******************/

		/*
		Adherent adherent2 = adherentDAO.selectById(idAdherent);
		System.out.println(adherent2.toString());
		//*/


		/******************* MISE A JOUR DES INFOS D'UN ADHERENT DEJA ENREGISTRE *******************/

		/*
		boolean test = adherentDAO.update(adherent);
		if(test) {
			System.out.println("Les informations de l'adhérents ont été bien mises à  jour !");
		}
		else{
			System.out.println("La mise de l'adhérent a échoué !");
		}
		//*/


		/******************* SUPPRESSION D'UN ADHERENT *******************/

		/*
		boolean test = adherentDAO.deleteById(adherent);
		if(test) {
			System.out.println("L'adhérent "+adherent.getPrenom()+" "+adherent.getNom()+" est bien supprimé !");
		}
		else{
			System.out.println("La suppression de l'adhérent "+adherent.getPrenom()+" "+adherent.getNom()+" a échoué !");
		}
		//*/


		/******************* MISE à JOUR D'UNE COMMANDE DEJA ENREGISTREE *******************/

		/*
		boolean test = commandeDAO.update(commande);
		if(test) {
			System.out.println("La commande a bien été mise à  jour !");
		}
		else{
			System.out.println("La mise à  jour de la commande a échoué !");
		}
		//*/


		/******************* RECUPERER UNE COMMANDE VIA SON ID PUIS AFFICHER *******************/

		/*
		Commande commande2 = commandeDAO.selectById(idAdherent);
		System.out.println(commande2.toString());
		//*/


		/******************* SUPPRESSION D'UNE COMMANDE *******************/

		/*
		boolean test = commandeDAO.deleteById(commande);
		if(test) {
			System.out.println("La commande est bien supprimée !");
		}
		else{
			System.out.println("La suppression de la commande a échoué !");
		}
		//*/

	}

}
