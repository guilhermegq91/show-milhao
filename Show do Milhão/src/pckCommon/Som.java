package pckCommon;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;

public class Som
{	
	public static synchronized void tocar(String som)
	{
		File arquivo = new File("Resources/wav/" + som);
		
		// O AudioListener serve pra esperar o arquivo de som tocar inteiro
		// Sem ele, o playback é cortado.
		class AudioListener implements LineListener
		{
		    private boolean done = false;
		    
		    @Override 
		    public synchronized void update(LineEvent event)
		    {
		    	Type eventType = event.getType();
		      
		    	// Notifica quando termina de tocar
		    	if (eventType == Type.STOP || eventType == Type.CLOSE)
		    	{
		    		done = true;
		    		notifyAll();
		    	}
		    }
		    
	    	// Espera terminar de tocar
	    	public synchronized void waitUntilDone() throws InterruptedException { while (!done) { wait(); } }
		}

		try
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivo);
			AudioListener listener = new AudioListener();
			
			try
			{
			    Clip clip = AudioSystem.getClip();
			    clip.addLineListener(listener);
			    clip.open(audioInputStream);
			    
			    // Toca o clipe e aguarda terminar de tocar
			    try
			    {
			    	clip.start();
			    	listener.waitUntilDone();
			    } 
			    
			    finally { clip.close(); }
			} 
			
			finally { audioInputStream.close(); }
		} 
		
		catch (Exception e){e.printStackTrace();}
	}
}
