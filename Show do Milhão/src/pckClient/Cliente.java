package pckClient;

import java.io.ObjectOutputStream;
import java.net.Socket;

import pckCommon.*;


public class Cliente {
	
	private Socket cliente;
	private Resposta resp = null;
	
	public Cliente(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmClient().setVisible(true);
            }
        });		
		resp = new Resposta("START", 0, 0, 0);
	}
	
	/*
	 * Conecta com o servidor
	 */
	public void conectaSocket() {
		try {
			Socket c = new Socket("127.0.0.1", 6789);
			cliente = c;
			
		}catch (Exception e) {
			System.out.println("Erro (1): " + e);
		}
	}
	
	/*
	 * Envia pacote "start" para o sincronizar novo jogo com o servidor
	 */
	public boolean iniciaJogo() {
		conectaSocket();
		
		ObjectOutputStream output;
		
		try {
			output = new ObjectOutputStream(cliente.getOutputStream());
			
			output.flush();
	        output.writeObject(resp);
	        output.flush();
	        output.close();
	        
		}catch (Exception e) {
			System.out.println("Erro (2): " + e);
		}
		return true;
	}

	/*
	 * Envia uma resposta genérica
	 */
	public boolean enviaResposta() {
		
		return true;
	}
	
	public static void main(String args[])
	{
		Cliente cl = new Cliente();
	}
	
}
