import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class MainScreen extends JFrame {
	/**
	 * Test
	 */
	File source = new File("/autofs/netapp/account/cremi/plorson/projtrans/GeBouL/database/GeBouL.db");
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public MainScreen() {
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Gestion des adh�rents");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println ("Test Gestion");
				AdherentsGUI adh = new AdherentsGUI();
		        adh.createAndShowGUI();
				
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestion du stock");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println ("Test Gestion");
				StockGUI stock = new StockGUI();
		        stock.createAndShowGUI();
				
			}
		});
		getContentPane().add(btnNewButton_1);
	
		
		JButton btnNewButton_2 = new JButton("Importer");
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println ("Test importer");
				JFileChooser fc = new JFileChooser();
				File dest = null;
				try{
				if(fc.showOpenDialog(btnNewButton_2) == JFileChooser.APPROVE_OPTION)
					dest = fc.getSelectedFile();
					Files.copy(dest.toPath(), source.toPath(),StandardCopyOption.REPLACE_EXISTING);
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
				File dest = null;
				try{
				if(fc.showSaveDialog(btnNewButton_3) == JFileChooser.APPROVE_OPTION){
					dest = fc.getSelectedFile();
					Files.copy(source.toPath(), dest.toPath());
				}
				} catch (IOException e1) {
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
		
		JMenuItem mntmImprimer = new JMenuItem("Imprimer");
		mnFichier.add(mntmImprimer);
		mntmImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PrinterJob pj = PrinterJob.getPrinterJob();
			    if (pj.printDialog()) {
			        try {pj.print();}
			        catch (PrinterException exc) {
			            System.out.println(exc);
		         }
		     }
			}
		});
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