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
		
		this.run();
		// this.run();
	}

	@Override
	public void run() {
		int i = 1;
		while (i <= 3) {
			try {
				Thread.sleep(5000);
				Random gerador = new Random();
				x.setText(String.valueOf(gerador.nextInt(76)));
			} catch (Exception t) {
			}

			i++;
		}
	}
}
