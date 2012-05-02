package pckClient;

import javax.swing.*;  
import java.awt.*;  
  
  
public class Teste extends JFrame {  
  
  
public JLabel lblNome, lblEndereco, lblTelefone;  
public JTextField jtfNome, jtfEndereco, jtfTelefone;  
  
public JTextArea jtaCadastro;  
  
public JButton btnBotaoOK, btnBotaoCancelar;  
  
  
public Teste() {  
  
// painel com os dados  
lblNome = new JLabel(" Nome :");  
jtfNome = new JTextField();  
lblEndereco = new JLabel(" Endereço :");  
jtfEndereco = new JTextField();  
lblTelefone = new JLabel(" Telefone :");  
jtfTelefone = new JTextField();  
  
JPanel pGrid = new JPanel(new GridLayout(3, 2));  
pGrid.add(lblNome);  
pGrid.add(jtfNome);  
pGrid.add(lblEndereco);  
pGrid.add(jtfEndereco);  
pGrid.add(lblTelefone);  
pGrid.add(jtfTelefone);  
  
// painel com o cadastro  
jtaCadastro = new JTextArea();  
  
JScrollPane pCadastro = new JScrollPane(jtaCadastro);  
  
// painel com os comandos  
btnBotaoOK = new JButton("OK");  
btnBotaoCancelar = new JButton("Cancelar");  
  
JPanel pBotoes = new JPanel(new GridLayout(0, 2));  
pBotoes.add(btnBotaoOK);  
pBotoes.add(btnBotaoCancelar);  
  
// painel do JFrame  
this.setLayout(new BorderLayout());  
this.getContentPane().add(pGrid, BorderLayout.NORTH);  
this.getContentPane().add(pCadastro, BorderLayout.CENTER);  
this.getContentPane().add(pBotoes, BorderLayout.SOUTH);  
  
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
this.setTitle("Cadastro");  
this.setSize(400, 200);  
this.setResizable(false);  
this.setLocationRelativeTo(null);  
this.setVisible(true);  
}  
  
  
public static void main(String[] args) {  
JFrame.setDefaultLookAndFeelDecorated(true);  
new Teste();  
}  
  
  
}  