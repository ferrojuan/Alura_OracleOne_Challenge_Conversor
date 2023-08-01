package gui;
import javax.swing.*;
import Conversor.Conversor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import Enums.*;


public class VentanaConversor extends  JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;		
	private JMenuItem mntmMoneda;
	private JMenuItem mntmLongitud;
	private JMenuItem mntmTemperatura;
	private Moneda[] moneda= Moneda.values();;
	private Temperatura[] temperatura =Temperatura.values();
	private Longitud[] longitud = Longitud.values();
	private JTextField txtCantidad;
	private JButton btnCambiar;
	private JButton btnConvertir;
	private Conversor conversor = new Conversor();
	private int indexValorInicial;
	private int indexValorFinal;
	private int tipoConversor =0;
	private String textoAdicional="";
	
	
	
	public VentanaConversor() {
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConversor.class.getResource("/image/Logo.png")));
		setSize(new Dimension(600, 500));
		setTitle("Conversor Unidades");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(conversor.getColorResaltar());
		panelTitulo.setBounds(0, 0, 584, 40);
		getContentPane().add(panelTitulo);
		panelTitulo.setLayout(null);
		
		
		JLabel lblTituloApp = new JLabel("Conversor");
		lblTituloApp.setBounds(0, 0, 600, 40);
		lblTituloApp.setPreferredSize(new Dimension(570, 25));
		lblTituloApp.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(lblTituloApp);
		lblTituloApp.setForeground(conversor.getColorBase());
		lblTituloApp.setFont(conversor.getFontTitulo());
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(null);
		panelMenu.setBackground(conversor.getColorBase());
		panelMenu.setBounds(10, 50, 150, 100);
		getContentPane().add(panelMenu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(conversor.getColorBase());
		panelMenu.add(menuBar);
		
		
		JMenu mnOpcionesConversor = new JMenu("Opciones Conversion");
		mnOpcionesConversor.setDisplayedMnemonicIndex(0);
		mnOpcionesConversor.setHorizontalAlignment(SwingConstants.LEFT);
		mnOpcionesConversor.setBackground(conversor.getColorBase());
		mnOpcionesConversor.setFont(new Font("Arial Narrow", Font.BOLD, 15));		
		menuBar.add(mnOpcionesConversor);
		
		mntmMoneda = new JMenuItem("Moneda");
		mntmMoneda.setBackground(conversor.getColorBase());
		mntmMoneda.setFont(conversor.getFontItemMenu());
		mnOpcionesConversor.add(mntmMoneda);
		
		
		mntmTemperatura = new JMenuItem("Temperatura");
		mntmTemperatura.setFont(conversor.getFontItemMenu());
		mntmTemperatura.setBackground(conversor.getColorBase());
		mnOpcionesConversor.add(mntmTemperatura);
		
		mntmLongitud = new JMenuItem("Longitud");
		mntmLongitud.setFont(conversor.getFontItemMenu());
		mntmLongitud.setBackground(conversor.getColorBase());
		mnOpcionesConversor.add(mntmLongitud);
		
		JPanel panelConversor = new JPanel();
		panelConversor.setBorder(null);
		panelConversor.setBounds(0, 150, 585, 310);
		panelConversor.setBackground(new Color(255,255,255));
		getContentPane().add(panelConversor);
		panelConversor.setLayout(null);
		
		JLabel lblValorInicial = new JLabel("Convertir de  :");
		lblValorInicial.setFont(conversor.getFontLabel());
		lblValorInicial.setBounds(30, 50, 100, 20);
		panelConversor.add(lblValorInicial);	
		
		
		JComboBox cbValorInicial = new JComboBox();
		cbValorInicial.setFont(conversor.getFontComboBox());
		cbValorInicial.setModel(new DefaultComboBoxModel(Moneda.values()));
		cbValorInicial.setSelectedIndex(0);		
		cbValorInicial.setBackground(conversor.getColorBase());
		cbValorInicial.setBounds(140, 50, 150, 20);
		panelConversor.add(cbValorInicial);
		
		
		
		JLabel lblValorFinal = new JLabel("Convertir a :");
		lblValorFinal.setFont(conversor.getFontLabel());
		lblValorFinal.setBounds(30, 125, 100, 20);		
		panelConversor.add(lblValorFinal);
		
		JComboBox cbValorFinal = new JComboBox();		
		cbValorFinal.setFont(conversor.getFontComboBox());
		cbValorFinal.setModel(new DefaultComboBoxModel(Moneda.values()));
		cbValorFinal.setSelectedIndex(0);
		cbValorFinal.setBackground(conversor.getColorResaltar());
		cbValorFinal.setForeground(conversor.getColorBase());
		cbValorFinal.setBounds(140, 125, 150, 20);
		panelConversor.add(cbValorFinal);
		
		Label lblResultado = new Label("Valor");
		lblResultado.setFont(conversor.getFontLabel());
		lblResultado.setBounds(345, 125, 60, 20);
		panelConversor.add(lblResultado);
		
		TextField txtValorFinal = new TextField();
		txtValorFinal.setEditable(false);
		txtValorFinal.setBounds(410, 125, 120, 40);
		txtValorFinal.setFont(conversor.getFontLabel());
		panelConversor.add(txtValorFinal);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(410, 50, 120, 20);
		panelConversor.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(conversor.getFontLabel());
		lblCantidad.setBounds(340, 50, 70, 20);
		panelConversor.add(lblCantidad);
		
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(conversor.getFontButton());
		btnConvertir.setBounds(190, 220, 90, 25);
		panelConversor.add(btnConvertir);
		
		btnCambiar = new JButton("");
		btnCambiar.setIcon(new ImageIcon(VentanaConversor.class.getResource("/image/arrows__.png")));
		btnCambiar.setBounds(303, 222, 40, 25);
		btnCambiar.setBorder(null);
		panelConversor.add(btnCambiar);
		
		JLabel lblTextoAdicional = new JLabel(textoAdicional);
		lblTextoAdicional.setFont(conversor.getFontLabel());
		lblTextoAdicional.setBounds(410, 171, 150, 25);
		panelConversor.add(lblTextoAdicional);
		
		JPanel panelTituloVariable = new JPanel();
		panelTituloVariable.setBackground(new Color(255,255,255));
		panelTituloVariable.setBounds(335, 60, 250, 90);
		getContentPane().add(panelTituloVariable);
		panelTituloVariable.setLayout(null);
		
		JLabel lblTituloVariable = new JLabel("Moneda");
		lblTituloVariable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVariable.setBounds(new Rectangle(54, 36, 150, 30));
		lblTituloVariable.setFont(conversor.getFontTitulo());
		panelTituloVariable.add(lblTituloVariable);
		
		mntmMoneda.addActionListener(new ActionListener () {			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTituloVariable.setText("Moneda");
				cbValorInicial.setModel(new DefaultComboBoxModel(Moneda.values()));
				cbValorInicial.setSelectedIndex(0);
				cbValorFinal.setModel(new DefaultComboBoxModel(Moneda.values()));
				cbValorFinal.setSelectedIndex(0);
				tipoConversor = 0;
				
			}
		});
		mntmLongitud.addActionListener(new ActionListener () {			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTituloVariable.setText("Longitud");
				cbValorInicial.setModel(new DefaultComboBoxModel(Longitud.values()));
				cbValorInicial.setSelectedIndex(0);
				cbValorFinal.setModel(new DefaultComboBoxModel(Longitud.values()));
				cbValorFinal.setSelectedIndex(0);
				tipoConversor = 1;				
				
			}
		});
		mntmTemperatura.addActionListener(new ActionListener () {			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTituloVariable.setText("Temperatura");
				cbValorInicial.setModel(new DefaultComboBoxModel(Temperatura.values()));
				cbValorInicial.setSelectedIndex(0);
				cbValorInicial.getSelectedIndex();
				cbValorFinal.setModel(new DefaultComboBoxModel(Temperatura.values()));
				cbValorFinal.setSelectedIndex(0);
				tipoConversor = 2;
				
				
			}
			
		});
		btnCambiar.addActionListener(new ActionListener () {			
			@Override
			public void actionPerformed(ActionEvent e) {
				indexValorInicial = conversor.valorIndice(cbValorInicial);
				indexValorFinal = conversor.valorIndice(cbValorFinal);
				cbValorInicial.setSelectedIndex(indexValorFinal);
				cbValorFinal.setSelectedIndex(indexValorInicial);
				
				
			}			
		});
		btnConvertir.addActionListener(new ActionListener () {			
			@Override
			public void actionPerformed(ActionEvent e) {
				indexValorInicial = conversor.valorIndice(cbValorInicial);
				indexValorFinal = conversor.valorIndice(cbValorFinal);
				double cantidad =conversor.obtenerCantidad(txtCantidad);
				double valorInicial;
				double valorFinal;
				double valorCeroIni;
				double valorIncrementalIni;
				double valorCeroFin;
				double valorIncrementalFin;
				
				
				switch (tipoConversor) {
				case 0: {
					valorInicial = moneda[indexValorInicial].getValorMoneda().doubleValue();
					valorFinal = moneda[indexValorFinal].getValorMoneda().doubleValue();
					textoAdicional =moneda[indexValorFinal].getNombreMoneda();
					txtValorFinal.setText(conversor.conversorMonedaLongitud(cantidad, valorInicial, valorFinal));
					lblTextoAdicional.setText(textoAdicional);
					break;
				}
				case 1: {
					valorInicial = longitud[indexValorInicial].getValorLongitud();
					valorFinal = longitud[indexValorFinal].getValorLongitud();
					textoAdicional =longitud[indexValorFinal].getSigla();
					txtValorFinal.setText(conversor.conversorMonedaLongitud(cantidad, valorInicial, valorFinal));
					lblTextoAdicional.setText(textoAdicional);
					break;
				}
				case 2: {
					valorCeroIni = temperatura[indexValorInicial].getValorCero();
					valorIncrementalIni = temperatura[indexValorInicial].getValorIncremental();
					valorCeroFin =  temperatura[indexValorFinal].getValorCero();
					valorIncrementalFin = temperatura[indexValorFinal].getValorIncremental();					
					textoAdicional =temperatura[indexValorFinal].getSigno();
					txtValorFinal.setText(conversor.conversorTemperatura(cantidad, valorCeroIni, valorIncrementalIni, valorCeroFin, valorIncrementalFin));
					lblTextoAdicional.setText(textoAdicional);					
					break;
				}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + tipoConversor);
				}				
			}			
		});		
		setVisible(true);	
	}
	
	
}
