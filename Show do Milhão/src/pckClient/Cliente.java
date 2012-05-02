package pckClient;

public class Cliente extends frmClient
{	
	public static void main(String args[])
	{
		// Prepara novo cliente
		Cliente cl = new Cliente();
		
		// Código referente a montagem da interface
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } 
        
        catch (ClassNotFoundException ex) { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); }
        catch (InstantiationException ex) { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); } 
        catch (IllegalAccessException ex) { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); }
        catch (javax.swing.UnsupportedLookAndFeelException ex) { java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); }
        
        // Cria e exibe o form
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new frmClient().setVisible(true);
            }
        });
	}	
}
