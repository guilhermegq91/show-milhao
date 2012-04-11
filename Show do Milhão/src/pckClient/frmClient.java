package pckClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class frmClient extends JFrame {
	
	JPanel pnlNorth;
	JPanel pnlCenter;
	JPanel pnlSouth;
	JPanel pnlToolbar;
	JPanel pnlPergunta;
	
	JButton btnResponde;
	JButton btnPula;
	
	JTextArea texPergunta;

	public frmClient(){
		ajustaFrame(); //configura layout, posição, caption e etc...
		criaObjetos(); //cria objetos que serão utilizados
		montaFrame();  //monta o frame, colocando os objetos em seus devidos lugares
		this.setVisible(true);
	}
	
	private void criaObjetos(){
		pnlNorth   = new JPanel(new GridLayout(3,0));
		pnlCenter  = new JPanel();
		pnlSouth   = new JPanel();
		pnlToolbar = new JPanel(new GridLayout(0,4));//vai ficar dentro do pnlNorth
		((GridLayout)pnlToolbar.getLayout()).setHgap(1); //margem horizontal entre objetos	
		pnlPergunta = new JPanel();
		pnlPergunta.setBounds(0, 0, 600, 200);
		
		btnResponde = new JButton("Responder");
		btnPula = new JButton("Pular");
		btnPula.setEnabled(false);
		
		texPergunta = new JTextArea();
		texPergunta.setText("OLA");
		texPergunta.setForeground(Color.BLUE);
		texPergunta.setEditable(false);		
	}
	
	private void ajustaFrame(){
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 600, 400);
		this.setTitle("Show do Milhão - Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
		this.setResizable(false);		
	}
	
	private void montaFrame(){
		pnlToolbar.add(btnResponde);
		pnlToolbar.add(btnPula);
		pnlToolbar.add(new JPanel());
		pnlToolbar.add(new JPanel());		
		//pnlPergunta.add(texPerunta);
		texPergunta.setBounds(0, 0, 600, 500);
		
		pnlNorth.add(new JLabel(" Vamos para a pergunta que vale 10.000 reais"));
		JScrollPane scroll = new JScrollPane(texPergunta);
		//scroll.setBounds(0, 0, 600, 600);
		//scroll.setAutoscrolls(true);
		scroll.setAutoscrolls(false);
		pnlNorth.add(scroll);
		pnlNorth.add(pnlToolbar);
		
		this.add("North" , pnlNorth);
		this.add("Center", pnlCenter);
		this.add("South" , pnlSouth);
	}
	
	public static void main(String args[]){
		JFrame.setDefaultLookAndFeelDecorated(true);
		frmClient frm = new frmClient();		
	}

}
