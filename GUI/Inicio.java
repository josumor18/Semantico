package GUI;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import analizador_Lexico.AnalizadorLexico;
import analizador_Lexico.Lexer;
import analizador_Semantico.Semantico;
import analizador_Sintactico.Sintactico;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Inicio extends JFrame {
	private JTextField txtRuta;
	private JLabel lblMensaje;
	private AnalizadorLexico analizador;
	private String archivo = "";
	private JTextArea txtReporte;
	
	public Inicio() {
		setBounds(300, 150, 652, 505);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		setTitle("Parser de C");
		getContentPane().setLayout(null);
		
		JLabel lblArchivo = new JLabel("Archivo:");
		lblArchivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArchivo.setBounds(20, 59, 72, 14);
		getContentPane().add(lblArchivo);
		
		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setBounds(93, 123, 441, 19);
		getContentPane().add(lblMensaje);
		
		txtRuta = new JTextField();
		txtRuta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblMensaje.setVisible(false);
			}
		});
		txtRuta.setBounds(93, 58, 422, 20);
		getContentPane().add(txtRuta);
		txtRuta.setColumns(10);
		txtRuta.setEditable(false);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirExplorador();
			}
		});
		btnSeleccionar.setBounds(525, 57, 111, 23);
		getContentPane().add(btnSeleccionar);
		
		JLabel lblTituloAnalizador = new JLabel("PARSER");
		lblTituloAnalizador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTituloAnalizador.setBounds(10, 11, 227, 37);
		getContentPane().add(lblTituloAnalizador);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					analizar();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAnalizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnalizar.setBounds(273, 89, 92, 23);
		getContentPane().add(btnAnalizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 153, 616, 312);
		getContentPane().add(scrollPane);
		
		txtReporte = new JTextArea();
		txtReporte.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtReporte);
		txtReporte.setEditable(false);
		
		analizador = new AnalizadorLexico();
	}
	
	private void abrirExplorador(){
		JFileChooser sel = new JFileChooser();
		//Creamos el filtro
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.C", "c");
		//Le indicamos el filtro
		sel.setFileFilter(filtro);
		int opcion = sel.showOpenDialog(getContentPane());
		lblMensaje.setVisible(false);
		txtReporte.setText("");
		if(opcion == sel.APPROVE_OPTION){
			archivo = sel.getSelectedFile().getPath();
			txtRuta.setText(archivo);
			//System.out.println(archivo);
			
		}
	}
	
	private void analizar()throws FileNotFoundException, IOException{
		Semantico sem = Semantico.getInstance();
		sem.prepararAnalisis();
		
		if(!(archivo.equals(""))){
			System.out.println("Analisis sintactico del archivo: " + archivo);
			String res = "\nRESULTADO ANALISIS LEXICO\n";
	        System.out.println("RESULTADO ANALISIS LEXICO\n");
	        res+= AnalizadorLexico.ejecutarAnalisis(archivo);
			System.out.println("- " + res);
			res+= "\n\n--------------------------------------------------------------------------------";
			System.out.println("\n--------------------------------------------------------------------------------");
	        
	        Lexer lexico = new Lexer(new BufferedReader(new FileReader(archivo)));
	        Sintactico sintactico = new Sintactico(lexico);
	        res+= "\nRESULTADO ANALISIS SINTACTICO\n";
	        System.out.println("RESULTADO ANALISIS SINTACTICO\n");
	        res+= "\n- Lista de errores sintacticos encontrados:";
	        System.out.println("- Lista de errores sintacticos encontrados:");
	        try {
	            sintactico.parse();
	            res+= sintactico.resultado;
	            System.out.println(sintactico.resultado);
	            System.out.println("\n____________________________________________________________________________________________________________________________________________\n");
	            lblMensaje.setText("Analisis ejecutado");
				lblMensaje.setVisible(true);             
				
	            txtReporte.setText(res);
	        } catch (Exception e) {
	        	lblMensaje.setText("Ha ocurrido un error al intentar abrir el archivo.");
				lblMensaje.setVisible(true);
	        }
		}else{
			lblMensaje.setText("Debe seleccionar un archivo");
			lblMensaje.setVisible(true);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String path = "C:/Users/Diego Armando/Documents/U/segundo semestre 2017/Compiladores e Interpretes/progra 1 - Analizador léxico/Analizador Lexico/src/analizador_Lexico/regexp.flex";
		//String path = "C:/Users/Josu�/Documents/Programas Java/Parser/src/analizadores/regexp.flex";
		//generateLexer(path);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}