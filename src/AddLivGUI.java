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

public class AddLivGUI extends JPanel {

  public AddLivGUI() {

  JPanel panel = new JPanel();
  GridLayout gl = new GridLayout(8,12); // 4 rows, 2 columns
  panel.setLayout(gl);

  JLabel lblId = new JLabel("  Identifiant");
  JTextField txtId = new JTextField();
  panel.add(lblId);
  panel.add(txtId);
  JLabel lblDes = new JLabel("  Designation   ");
  JTextField txtDes = new JTextField();
  panel.add(lblDes);
  panel.add(txtDes);
  JLabel lblPrix = new JLabel("  Prix");
  JTextField txtPrix = new JTextField();
  panel.add(lblPrix);
  panel.add(txtPrix);
  JLabel lblEtat = new JLabel("  Etat");
  JTextField txtEtat = new JTextField();
  panel.add(lblEtat);
  panel.add(txtEtat);
  JLabel lblRef = new JLabel("  Reference");
  JTextField txtRef = new JTextField();
  panel.add(lblRef);
  panel.add(txtRef);
  JLabel lblStock = new JLabel("  Stock");
  JTextField txtStock = new JTextField();
  panel.add(lblStock);
  panel.add(txtStock);
  JButton b1 = new JButton("Ajouter");
  panel.add(b1);
  b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 //String livre = (String) listeLivres.getSelectedItem();
			 String idLivre = txtId.getText();
			 String designation = txtDes.getText();
			 String prix = txtPrix.getText();
			 String etat = txtEtat.getText();
			 String reference = txtRef.getText();
			 String enStock = txtStock.getText(); // 0 ou 1
		}
	});
  createAndShowGUI(panel);
  }

  final void createAndShowGUI(JPanel panel) {
	    JFrame frame = new JFrame("Ajout d'un livre");
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);
	  };
  
}

  