import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class StockGUI extends JFrame {

  public StockGUI() {
	JPanel panel = new JPanel();
    JTable table = new JTable(new MyTableModel());
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane);
    createAndShowGUI(scrollPane, table);

  }
  
  static void createAndShowGUI(JScrollPane scrollpane, JTable table) {
	    JFrame frame = new JFrame("Affichage du stock");
	    frame.add(scrollpane);
	    frame.pack();
	    frame.setVisible(true);
	  }

  class MyTableModel extends AbstractTableModel {
    private String[] columnNames = { "Nom du livre", "Identification", "Etat",
        "Nombre en stock"};

    private Object[][] data = {
        { "Mary", "Campione", "Snowboarding", new Integer(5)},
        { "Alison", "Huml", "Rowing", new Integer(3),},
        { "Kathy", "Walrath", "Knitting", new Integer(2)},
        { "Sharon", "Zakhour", "Speed reading", new Integer(20)},
        { "Philip", "Milne", "Pool", new Integer(10)}};
    

    public int getColumnCount() {
      return columnNames.length;
    }

    public int getRowCount() {
      return data.length;
    }

    public String getColumnName(int col) {
      return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
      return data[row][col];
    }

    public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void setValueAt(Object value, int row, int col) {
      System.out.println("Setting value at " + row + "," + col
            + " to " + value + " (an instance of "
            + value.getClass() + ")");
      data[row][col] = value;
      fireTableCellUpdated(row, col);
        System.out.println("New value of data:");
        printDebugData();
    }

    private void printDebugData() {
      int numRows = getRowCount();
      int numCols = getColumnCount();

      for (int i = 0; i < numRows; i++) {
        System.out.print("    row " + i + ":");
        for (int j = 0; j < numCols; j++) {
          System.out.print("  " + data[i][j]);
        }
        System.out.println();
      }
      System.out.println("--------------------------");
    }
  }


}