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

/**
 * AdherentsGUI is just like SimpleAdherentsGUI, except that it uses a custom
 * TableModel.
 */
public class AddAdhGUI extends JPanel {

  public AddAdhGUI() {
    String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

    JPanel panel = new JPanel();
    GridLayout gl = new GridLayout(12,12); // 4 rows, 2 columns
    panel.setLayout(gl);



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
			 //String livre = (String) listeLivres.getSelectedItem();
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
			 String adresse = txtAdresse.getText();
			 String codePostal = txtCode.getText();
			 String ville = txtVille.getText();
			 String telParent = txtTelP.getText();
			 String participation = txtPart.getText();
			 String formule = txtForm.getText();
			 String acompte = txtAcc.getText();
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

  