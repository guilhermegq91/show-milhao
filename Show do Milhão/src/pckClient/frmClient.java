package pckClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import pckCommon.Mensagem;
import pckCommon.Pergunta;
import pckCommon.Resposta;

public class frmClient extends javax.swing.JFrame
{	
	// Socket que recebe dados
	private Socket clienteIn;

	// Stream de entrada
	private ObjectInputStream in;
	
	// Stream de saida
	private ObjectOutputStream out;
	
	// Socket que envia dados
	private Socket clienteOut;
	
	// Pacote mensagem
	private Mensagem m; 
	
    private javax.swing.JButton btnResponder;
    private javax.swing.ButtonGroup buttonGroupOpcoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenuAbout;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemFechar;
    private javax.swing.JMenuItem jMenuItemNovoJogo;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblPergunta;
    private javax.swing.JRadioButton rbtOpcao1;
    private javax.swing.JRadioButton rbtOpcao2;
    private javax.swing.JRadioButton rbtOpcao3;
    private javax.swing.JRadioButton rbtOpcao4;
	
    // Cria novo form frmClient
    public frmClient()
    {
        initComponents();
        btnResponder.hide();
        rbtOpcao1.hide();
        rbtOpcao2.hide();
        rbtOpcao3.hide();
        rbtOpcao4.hide();
        jLabel1.hide();
        jLabel4.hide();
        jLabel5.hide();
        lblMensagem.hide();
        lblPergunta.hide();
    }

    // Inicializa componentes do form
    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        buttonGroupOpcoes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblMensagem = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblPergunta = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rbtOpcao1 = new javax.swing.JRadioButton();
        rbtOpcao2 = new javax.swing.JRadioButton();
        rbtOpcao3 = new javax.swing.JRadioButton();
        rbtOpcao4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnResponder = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemNovoJogo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemFechar = new javax.swing.JMenuItem();
        jMenuAbout = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Show do Milh�o - Client");
        setForeground(new java.awt.Color(255, 255, 51));
        setName("frmClient"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                centralizaFrame(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("SHOW DO MILH�O");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        lblMensagem.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblMensagem.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        lblPergunta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPergunta.setForeground(new java.awt.Color(0, 0, 153));
        lblPergunta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPergunta.setText("jLabel3");
        lblPergunta.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblPergunta.setAutoscrolls(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Pergunta:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        rbtOpcao1.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroupOpcoes.add(rbtOpcao1);
        rbtOpcao1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbtOpcao1.setText("jRadioButton1");

        rbtOpcao2.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroupOpcoes.add(rbtOpcao2);
        rbtOpcao2.setFont(new java.awt.Font("Tahoma", 1, 12));
        rbtOpcao2.setText("jRadioButton2");

        rbtOpcao3.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroupOpcoes.add(rbtOpcao3);
        rbtOpcao3.setFont(new java.awt.Font("Tahoma", 1, 12));
        rbtOpcao3.setText("jRadioButton3");

        rbtOpcao4.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroupOpcoes.add(rbtOpcao4);
        rbtOpcao4.setFont(new java.awt.Font("Tahoma", 1, 12));
        rbtOpcao4.setText("jRadioButton4");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Alternativas:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtOpcao4)
                            .addComponent(rbtOpcao3)
                            .addComponent(rbtOpcao2)
                            .addComponent(rbtOpcao1))))
                .addContainerGap(460, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(rbtOpcao1)
                .addGap(18, 18, 18)
                .addComponent(rbtOpcao2)
                .addGap(18, 18, 18)
                .addComponent(rbtOpcao3)
                .addGap(18, 18, 18)
                .addComponent(rbtOpcao4)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));

        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuArquivo.setText("Arquivo");

        jMenuItemNovoJogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItemNovoJogo.setText("Iniciar novo jogo");
        jMenuItemNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoJogoActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemNovoJogo);
        jMenuArquivo.add(jSeparator1);

        jMenuItemFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemFechar.setText("Fechar jogo");
        jMenuItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemFechar);

        jMenuBar1.add(jMenuArquivo);

        jMenuAbout.setText("About");
            
        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenuAbout.add(jMenuItemSobre);

        jMenuBar1.add(jMenuAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jMenuItemFecharActionPerformed(java.awt.event.ActionEvent evt)
    {                                                
        System.exit(0);
    }                                               

    private void centralizaFrame(java.awt.event.WindowEvent evt)
    {                                 
        this.setLocationRelativeTo(null);  
    }                                

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt)
    {
        JOptionPane.showMessageDialog(null, "Gustavo Togni\n Leonardo dos Santos Paula\n Vinicius Ville", "Sobre", JOptionPane.INFORMATION_MESSAGE);        
    }
    
    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt)
    {
    	enviaResposta("resposta");
    }

    private void jMenuItemNovoJogoActionPerformed(java.awt.event.ActionEvent evt)
    {
        // Inicia um novo Jogo
        Cliente c = new Cliente();
        
        conectaSocket();
		
        // Monta pacote com a primeira mensagem
		m = new Mensagem("inicia", "Jogador");

		ObjectOutputStream output;
		
		try
		{
			// Envia mensagem para o servidor iniciar
			output = new ObjectOutputStream(clienteOut.getOutputStream());
			
			output.flush();
	        output.writeObject(m);
	        output.flush();	        
	  
	        // Aguarda retorno do servidor
	        ServerSocket servidor = new ServerSocket(6790);
	        clienteIn = servidor.accept();
	        
	        // Fecha o servidor
	        servidor.close();
	        
	        // Salva stream de dados
	        in = new ObjectInputStream(clienteIn.getInputStream());	        
	        
	        // Trata os dados recebidos
	        trataRetorno();
		}
		
		catch (Exception e) { System.out.println("Erro (2): " + e); }
    }

    // Conecta com o servidor
	public void conectaSocket()
	{
		// Solicita IP do servidor
		String x = javax.swing.JOptionPane.showInputDialog("Informe o IP do servidor");
		
		// Verifica se foi informado alguma coisa
		if (x != null)
		{

			// Conecta com o servidor
			try
			{
				// Fecha todas conexões ativas para abrir novas
				if (in  != null) in.close();
				if (out != null) out.close();
				if (clienteIn != null) clienteIn.close();
				if (clienteOut != null) clienteOut.close(); 
				
				clienteOut = new Socket(x, 6789);
			}
			
			catch (Exception e) { System.out.println("Erro (1): " + e); }
		} 
		
		// Mensagem de erro
		else		
			JOptionPane.showMessageDialog( null, "Informe um IP para iniciar", "Sobre", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/* Recebe uma mensagem vinda do servidor e realiza
	 * as opera��es de acordo com o objeto enviado */
	public void trataRetorno()
	{
		// Recebe mensagem
		try
		{
	        m = (Mensagem) in.readObject();
		} 
		
		catch (Exception e) { System.out.println(e); }

		// Verfica se eh uma pergunta
		if (m.getObj() instanceof Pergunta)
		{
			// Manipula a tela 
			btnResponder.show();
	        rbtOpcao1.show();
	        rbtOpcao1.setSelected(false);
	        rbtOpcao2.show();
	        rbtOpcao2.setSelected(false);
	        rbtOpcao3.show();
	        rbtOpcao3.setSelected(false);
	        rbtOpcao4.show();
	        rbtOpcao4.setSelected(false);
	        jLabel1.show();
	        jLabel4.show();
	        jLabel5.show();
	        lblMensagem.show();
	        lblPergunta.show();
	        
	        // Converte o objeto da mensagem para pergunta
			Pergunta p = (Pergunta) m.getObj();
			
			// Verifica a logica do jogo para os sons
			if (p.getContPergunta() <= 5)
			{
				if (p.getContPergunta() == 1) 
					Som.tocar("Rodada1.wav"); 
				
				else 
					Som.tocar("Question/" + (int)p.getValorAcertar() + ".wav"); 
			} 
			
			else if (p.getContPergunta() <= 10)
			{
				if (p.getContPergunta() == 6) 
					Som.tocar("Rodada2.wav");
				
				else 
					Som.tocar("Question/" + (int)p.getValorAcertar() + ".wav");
			} 
			
			else if (p.getContPergunta() <= 16)
			{
				if (p.getContPergunta() == 11) 
					Som.tocar("Rodada3.wav");
				
				else 
					Som.tocar("Question/" + (int)p.getValorAcertar() + ".wav");
			} 
			
			// Exibe na tela as informacoes
			lblPergunta.setText(p.getDescricao());
			
			rbtOpcao1.setText( p.getOpcoes()[0].getDescricao() );
			rbtOpcao2.setText( p.getOpcoes()[1].getDescricao() );
			rbtOpcao3.setText( p.getOpcoes()[2].getDescricao() );
			rbtOpcao4.setText( p.getOpcoes()[3].getDescricao() );
			lblMensagem.setText("Errar: R$ "   + p.getValorErrar()   +
					            "  Parar: R$ "   + p.getValorParar() + 
							    "  Acertar: R$ " + p.getValorAcertar());

		} 
		
		// N�o � Pergunta, apenas informacao [Errada]
		else if (m.getMsg().equals("Errada")) 
		{
			lblMensagem.setText("Voc� perdeu.");
			Som.tocar("RespostaErrada.wav");
			Som.tocar("Fim.wav");
			
			btnResponder.hide();
		}
		
		// N�o � Pergunta, apenas informacao [Certa]
		else if (m.getMsg().equals("Certa"))
		{
			Som.tocar("RespostaCerta.wav");
			trataRetorno();
		}
		
		// N�o � Pergunta, apenas informacao [Ganhou]
		else if (m.getMsg().equals("Ganhou"))
		{
			Som.tocar("UmMilhao.wav");
			Som.tocar("Fim.wav");
		}
	}
	
	public boolean enviaResposta(String msg)
	{	
		int opt;
		
		// Verifica opcao escolhida
		if (rbtOpcao1.isSelected())
			opt = 0; 
		
		else if (rbtOpcao2.isSelected())
			opt = 1;
		
		else if (rbtOpcao3.isSelected())
			opt = 2;
		
		else if (rbtOpcao4.isSelected())
			opt = 3;
		
		else
		{
			JOptionPane.showMessageDialog(null,"Escolha uma op��o","Escolha",JOptionPane.INFORMATION_MESSAGE);
			
			return false;
		}
	
		// Monta resposta
		Resposta r = new Resposta(msg, opt);
		
		// Empacota resposta
		m = new Mensagem(r, msg);
		
		// Envia mensagem para o servidor
		try
		{
			out = new ObjectOutputStream(clienteOut.getOutputStream());
			out.flush();
			out.writeObject(m);
			out.flush();
    	}
		
		catch (Exception e) { System.out.println("Erro (3): " + e); }
		
		// Prepara para receber os dados
		trataRetorno();
		return true;
	}
}
