package projetoBingo;

import java.util.Random;
import java.util.concurrent.Callable;

import javax.swing.JLabel;

public class SorteioNum implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel x;

	public SorteioNum(JLabel x) {
		// super();
		this.x = x;
		Thread t1 = new Thread(this);
		t1.start();
		
		//this.run();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (Exception t) {
			}
			Random gerador = new Random();
			x.setText(String.valueOf(gerador.nextInt(76)));
		}
	}
}
