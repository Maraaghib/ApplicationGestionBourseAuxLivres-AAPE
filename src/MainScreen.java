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
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;

public class MainScreen extends JFrame {
	/**
	 * Test
	 */
	File source = new File("/autofs/netapp/account/cremi/plorson/projtrans/GeBouL/database/GeBouL.db");
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public MainScreen() {
		
		
		
		JButton btnNewButton = new JButton("Ajout d'adhérents");
		btnNewButton.setPreferredSize(new Dimension(300, 100));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdhGUI add = new AddAdhGUI();
				
			}
		});
		JButton btnNewButton_5 = new JButton("Ajout de livre");
		btnNewButton_5.setPreferredSize(new Dimension(300, 100));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLivGUI add = new AddLivGUI();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Affichage du stock");
		btnNewButton_1.setPreferredSize(new Dimension(300, 100));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockGUI stock = new StockGUI();
				
			}
		});

		JButton btnNewButton_4 = new JButton("Affichage des adhérents");
		btnNewButton_4.setPreferredSize(new Dimension(300, 100));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdherentsGUI adh = new AdherentsGUI();
				
			}
		});
	
		
		JButton btnNewButton_2 = new JButton("Importer");
		btnNewButton_2.setPreferredSize(new Dimension(300, 100));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				File dest = null;
				try{
				if(fc.showOpenDialog(btnNewButton_2) == JFileChooser.APPROVE_OPTION){
					dest = fc.getSelectedFile();
					Files.copy(dest.toPath(), source.toPath(),StandardCopyOption.REPLACE_EXISTING);
				}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		
		JButton btnNewButton_3 = new JButton("Exporter");
		btnNewButton_3.setPreferredSize(new Dimension(300, 100));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_5);
		getContentPane().add(btnNewButton_4);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(btnNewButton_2);
		getContentPane().add(btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	}

	public static void main(String[] args) {
        MainScreen gui = new MainScreen();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setPreferredSize(new Dimension(700, 400));
        gui.setMinimumSize(new Dimension(700, 400));
        gui.setTitle("Bourse aux livres AAPE Gradignan");
        gui.setVisible(true);
	}
}