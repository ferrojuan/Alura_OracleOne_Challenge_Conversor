package gui;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class MenuInicial extends JFrame{
	String[] itemMenuInicial = {"Conversor Moneda", "Conversor Temperatura"};
	
	public MenuInicial() {
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicial.class.getResource("/image/Logo.png")));
		setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		setBackground(new Color(0, 128, 255));
		getContentPane().setSize(new Dimension(400, 250));
		setSize(new Dimension(400, 300));
		setTitle("Conversor ");
		getContentPane().setLayout(null);
		
		JLabel lblTituloMenuInicial = new JLabel("Conversor de Unidades ");
		lblTituloMenuInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenuInicial.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblTituloMenuInicial.setBounds(110, 30, 180, 20);
		getContentPane().add(lblTituloMenuInicial);
		
		JLabel lblIndicacionMP = new JLabel("Elija opcion");
		lblIndicacionMP.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndicacionMP.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblIndicacionMP.setBounds(60, 100, 80, 20);
		getContentPane().add(lblIndicacionMP);
		
		JComboBox cbMenuInicial = new JComboBox(itemMenuInicial);
		cbMenuInicial.setModel(new DefaultComboBoxModel(new String[] {"", "Conversor Moneda", "Conversor Temperatura"}));
		cbMenuInicial.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		cbMenuInicial.setBounds(200, 100, 150, 20);
		getContentPane().add(cbMenuInicial);
		
		JButton btnContinuarMI = new JButton("Continuar");
		btnContinuarMI.setBackground(new Color(46, 134, 193));
		btnContinuarMI.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnContinuarMI.setBounds(144, 200, 80, 25);
		getContentPane().add(btnContinuarMI);
	}

	private static final long serialVersionUID = 1L;
}
