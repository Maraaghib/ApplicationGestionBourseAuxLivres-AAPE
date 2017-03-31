import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AdherentsGUI extends JFrame {
	private JTable table;
    Object[][] data = {
  	      {"Cysboy", "28 ans", "1.80 m"},
  	      {"BZHHydde", "28 ans", "1.80 m"},
  	      {"IamBow", "24 ans", "1.90 m"},
  	      {"FunMan", "32 ans", "1.85 m"}
  	    };

  	    String  title[] = {"Pseudo", "Age", "Taille"};
	public AdherentsGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		table = new JTable(data, title);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		add(table, gbc_table);
		
		
	}

}