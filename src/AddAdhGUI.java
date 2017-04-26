import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * AdherentsGUI is just like SimpleAdherentsGUI, except that it uses a custom
 * TableModel.
 */
public class AddAdhGUI extends JPanel {

  public AddAdhGUI() {

		AdherentDAO adherentDAO = new AdherentDAO();
		CommandeDAO commandeDAO = new CommandeDAO();
		LivreDAO livreDAO = new LivreDAO();
	  ArrayList<Livre> listLivres = livreDAO.selectAll();
	  String[] petStrings = new String[listLivres.size()];
	  int listeLivre[] = new int[listLivres.size()];
	  
	for (int i = 0; i < listLivres.size(); i++) {
		petStrings[i] = listLivres.get(i).getDesignation();
		listeLivre[i] = (int) listLivres.get(i).getIdLivre();
	}
	
	
	// La date
	 String[] month = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
	 String[] day = {"Samedi", "Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
	 
	Calendar calendar = Calendar.getInstance();
	 StringBuffer dateTimeTodayBuffer = new StringBuffer();
	 dateTimeTodayBuffer.append(day[calendar.get(Calendar.DAY_OF_WEEK)]+" ");
	 dateTimeTodayBuffer.append(calendar.get(Calendar.DAY_OF_MONTH)+" ");
	 dateTimeTodayBuffer.append(month[calendar.get(Calendar.MONTH)]+" ");
	 dateTimeTodayBuffer.append(calendar.get(Calendar.YEAR)+ " ");
	 dateTimeTodayBuffer.append("à "+calendar.get(Calendar.HOUR_OF_DAY)+":");
	 dateTimeTodayBuffer.append(calendar.get(Calendar.MINUTE)+":");
	 dateTimeTodayBuffer.append(calendar.get(Calendar.SECOND));
	 
	 String dateTimeToday = dateTimeTodayBuffer.toString();
	 
	 
		adherentDAO.createTable();
		commandeDAO.createTable();
		livreDAO.createTable();
	  
    

    JPanel panel = new JPanel();
    GridLayout gl = new GridLayout(12,12); // 4 rows, 2 columns
    panel.setLayout(gl);



  JLabel lbliD = new JLabel(" Numero d'adherent");
  JTextField txtiD = new JTextField();
  panel.add(lbliD);
  panel.add(txtiD);
  JLabel lblNom = new JLabel(" Nom");
  JTextField txtNom = new JTextField();
  panel.add(lblNom);
  panel.add(txtNom);
  JLabel lblPrenom = new JLabel("  Prénom");
  JTextField txtPrenom = new JTextField();
  panel.add(lblPrenom);
  panel.add(txtPrenom);
  JLabel lblDate = new JLabel(" Date de naissance (format JJ/MM/AAAA) ");
  JTextField txtDate = new JTextField();
  panel.add(lblDate);
  panel.add(txtDate);
  JLabel lblTel = new JLabel("  Numéro de Téléphone Eleve");
  JTextField txtTel = new JTextField();
  panel.add(lblTel);
  panel.add(txtTel);
  JLabel lblMail = new JLabel(" Adresse Electronique");
  JTextField txtMail = new JTextField();
  panel.add(lblMail);
  panel.add(txtMail);
  JLabel lblClasse = new JLabel("  Classe");
  JTextField txtClasse = new JTextField();
  panel.add(lblClasse);
  panel.add(txtClasse);
  JLabel lblSpé = new JLabel(" Spécialité");
  JTextField txtSpe = new JTextField();
  panel.add(lblSpé);
  panel.add(txtSpe);
  JLabel lblEtat = new JLabel(" Etat des livres");
  JTextField txtEtat = new JTextField();
  panel.add(lblEtat);
  panel.add(txtEtat);
  JLabel lblParent = new JLabel("  Nom Parent");
  JTextField txtParent = new JTextField();
  panel.add(lblParent);
  panel.add(txtParent);
  JLabel lblPParent = new JLabel(" Prénom Parent");
  JTextField txtPParent = new JTextField();
  panel.add(lblPParent);
  panel.add(txtPParent);
  JLabel lblResp = new JLabel("  Responsable Légal");
  JTextField txtResp = new JTextField();
  panel.add(lblResp);
  panel.add(txtResp);
  JLabel lblAdresse = new JLabel(" Adresse");
  JTextField txtAdresse = new JTextField();
  panel.add(lblAdresse);
  panel.add(txtAdresse);
  JLabel lblCode = new JLabel("  Code Postal");
  JTextField txtCode = new JTextField();
  panel.add(lblCode);
  panel.add(txtCode);
  JLabel lblVille = new JLabel(" Ville");
  JTextField txtVille = new JTextField();
  panel.add(lblVille);
  panel.add(txtVille);
  JLabel lblTelP = new JLabel("  Téléphone Parent");
  JTextField txtTelP = new JTextField();
  panel.add(lblTelP);
  panel.add(txtTelP);
  JLabel lblPart = new JLabel(" Participation");
  JTextField txtPart = new JTextField();
  panel.add(lblPart);
  panel.add(txtPart);
  JLabel lblForm = new JLabel("  Formule");
  JTextField txtForm = new JTextField();
  panel.add(lblForm);
  panel.add(txtForm);
  JLabel lblAcc = new JLabel(" Accompte");
  JTextField txtAcc = new JTextField();
  panel.add(lblAcc);
  panel.add(txtAcc);
  JLabel lblLivres = new JLabel("  Choisir un livre");
  JComboBox listeLivres = new JComboBox(petStrings);
  listeLivres.setSelectedIndex(4);
  panel.add(lblLivres);
  panel.add(listeLivres);
  JLabel lblBlank = new JLabel(" ");
  panel.add(lblBlank);
  JLabel lblBlank2 = new JLabel(" ");
  panel.add(lblBlank2);
  JLabel lblBlank3 = new JLabel(" ");
  panel.add(lblBlank3);
  JButton b1 = new JButton("Ajouter le livre");
  JButton b2 = new JButton("Inscrire");
  panel.add(b1);
  panel.add(b2);
  b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String test = (String) listeLivres.getSelectedItem();
		}
	});
  b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			double prixCommande = 0;
			
			for (int i = 0; i < listeLivre.length; ++i) {
			 	Livre livre = livreDAO.selectById(listeLivre[i]); // Récupérer le livre depuis la base de données
			 	System.out.println(livre.toString());
			 	prixCommande += livre.getPrix(); // Ajouter le prix de chaque livre sur le montant de la commande
			 }
			
			 //String livre = (String) listeLivres.getSelectedItem();
			 String idAdherentS = txtiD.getText();
			 long idAdherent = Long.parseLong(idAdherentS);
			 String prenom = txtPrenom.getText();
			 String nom = txtNom.getText();
			 String dateNaiss = txtDate.getText();
			 String telPerso = txtTel.getText();
			 String mailPerso = txtMail.getText();
			 String classe = txtClasse.getText();
			 String specialite = txtSpe.getText();
			 String nomParaent = txtParent.getText();
			 String prenomParent = txtPParent.getText();
			 String respLegal = txtResp.getText();
			 String typeLivre = txtEtat.getText(); 
			 String adresse = txtAdresse.getText();
			 String codePostalS = txtCode.getText();
			 long codePostal = Long.parseLong(codePostalS);
			 String ville = txtVille.getText();
			 String telParent = txtTelP.getText();
			 String participation = txtPart.getText();
			 String formule = txtForm.getText();
			 String acompteS = txtAcc.getText();
			 double acompte = Double.parseDouble(acompteS);
			 double montant = acompte;
			 String dateAdhesion = dateTimeToday;
			 
			 Commande commande = new Commande(dateTimeToday, prixCommande, idAdherent, listeLivre); 
			 
			 Adherent adherent = new Adherent(idAdherent, prenom, nom, dateNaiss, telPerso, mailPerso, classe, specialite, nomParaent, prenomParent, respLegal, adresse, codePostal, ville, telParent, participation, formule, acompte, montant, commande, typeLivre, listeLivre, dateAdhesion);
			 
			 adherentDAO.insert(adherent);
			 
		}
	});

  createAndShowGUI(panel);
  
  }

  final void createAndShowGUI(JPanel panel) {
	    JFrame frame = new JFrame("Ajout d'un adhérent");
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);
	  };
  
}

  