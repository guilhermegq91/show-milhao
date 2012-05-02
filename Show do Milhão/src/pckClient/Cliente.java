package pckClient;

import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import pckCommon.Comando;
import pckCommon.Mensagem;

public class Cliente
{
	private frmClient frameClient;
	private Socket conexSendMsgServer;
	private ClientMonitorMensagens clientMonitor;
	private ObjectOutputStream output;
	private Socket socketClient;
	
	public Cliente()
	{
        mostraInterface();
		frameClient = new frmClient((Cliente)this);	
		
		//cria thread que vai monitorar msgs recebidas do servidor
		this.clientMonitor = new ClientMonitorMensagens(this);
		Thread threadMonServ = new Thread(clientMonitor);
		threadMonServ.start();
		
		//cria socket que vai enviar mensagens para o servidor
		try
		{
			socketClient = new Socket("127.0.0.1", 6789);
			output = new ObjectOutputStream(socketClient.getOutputStream());
			//exibe form
			frameClient.setVisible(true);
			
			output.flush();
			output.writeObject(new Mensagem(new Comando(1, "gustavo"), "identificacao"));
			output.flush();
		}
		
		catch(Exception e){ JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE); }
    }
	
	private void mostraInterface()
	{
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } 
        
        catch (ClassNotFoundException ex) 					   { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); } 
        catch (InstantiationException ex) 					   { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); } 
        catch (IllegalAccessException ex) 					   { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); }
	}
	
	public void enviaMensagem(Mensagem mensagem)
	{
		try
		{
			output.flush();
			output.writeObject(mensagem);
			output.flush();
        }
		
        catch(Exception e){	JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE); }
	}
	
	public frmClient getFrameCl()
	{
		return frameClient;
	}
	
	/* Envia pacote "start" para o sincronizar novo jogo com o servidor */
	public static void main(String args[])
	{
		/*OpcaoPergunta[] op = new OpcaoPergunta[4];
    	op[0] = new OpcaoPergunta(0, "opcao da perg 1", true);    	
    	op[1] = new OpcaoPergunta(1, "opcao da perg 2", false);
    	op[2] = new OpcaoPergunta(2, "opcao da perg 3", false);
    	op[3] = new OpcaoPergunta(3, "opcao da perg 4", false);
    	
    	Pergunta p = new Pergunta("Pergunta de teste", 1, "Qual o nome?", op, NivelPergunta.FACIL);*/
    	
		Cliente cliente = new Cliente();
		//cliente.getFrameCl().exibePergunta(p);
	}	
}
