import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class MainScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public MainScreen() {
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Gestion des adhérents");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println ("Test Gestion");
				AdherentsGUI adh = new AdherentsGUI();
		        adh.setSize(500, 500);
		        adh.setVisible(true);
				
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestion du stock");
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Importer");
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println ("Test importer");
				JFileChooser fc = new JFileChooser();
				
				BufferedReader reader = null;
				try{
				if(fc.showOpenDialog(btnNewButton_2) == JFileChooser.APPROVE_OPTION)
					reader = new BufferedReader(new FileReader(fc.getSelectedFile()));
				} catch (IOException e1) {
					System.out.println ("Test importer");
					e1.printStackTrace();
				}
			}
			
		});
		
		
		JButton btnNewButton_3 = new JButton("Exporter");
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println ("Test Exporter");
				JFileChooser fc = new JFileChooser();
				
				BufferedReader reader = null;
				try{
				if(fc.showOpenDialog(btnNewButton_3) == JFileChooser.APPROVE_OPTION)
					reader = new BufferedReader(new FileReader(fc.getSelectedFile()));
				} catch (IOException e1) {
					System.out.println ("Test exporter");
					e1.printStackTrace();
				}
			}
			
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmGestionDesAdhrents = new JMenuItem("Gestion des adhérents");
		mnFichier.add(mntmGestionDesAdhrents);
		
		JMenuItem mntmGestionDuStock = new JMenuItem("Gestion du stock");
		mnFichier.add(mntmGestionDuStock);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MainScreen gui = new MainScreen();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(500, 500);
        gui.setTitle("Bourse aux livres AAPE Gradignan");
        gui.setVisible(true);
	}
}